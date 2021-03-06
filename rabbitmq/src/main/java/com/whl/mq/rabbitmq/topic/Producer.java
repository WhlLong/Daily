package com.whl.mq.rabbitmq.topic;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 〈生产者〉
 *
 * @author whl
 * @create 2019/1/22
 * @since 1.0.0
 */
public class Producer {

    private  static  final String EXCHANGE_NAME = "logs-routing" ;
    private  static  final String LOG_LEVEL_INFO = "info" ;
    private  static  final String LOG_LEVEL_WARN = "warn";
    private  static  final String LOG_LEVEL_ERROR = "error" ;

    public static void main(String[] args) {
        send();
    }

    public static void send()
    {
        ConnectionFactory factory = null;
        Connection connection = null;
        Channel channel = null;
        try {
            factory = new ConnectionFactory();
            factory.setHost("localhost");
            connection = factory.newConnection();
            channel = connection.createChannel();

            channel.exchangeDeclare(EXCHANGE_NAME,"direct");
            //将当前channel设置为confirm模式
            channel.confirmSelect();
            //设置confirm监听器
            channel.addConfirmListener(new ConfirmListener() {
                @Override
                public void handleAck(long deliveryTag, boolean multiple) throws IOException {
                    //这个回调，说明消息已经被mq持久化了
                    System.out.println("handleAck: "+deliveryTag+" "+multiple);
                }

                @Override
                public void handleNack(long deliveryTag, boolean multiple) throws IOException {
                    //这个回调，说明消息confirm失败，即持久化失败，可以选择在这里重新投递
                    System.out.println("handleNack: "+deliveryTag+" "+multiple);

                }
            });


            //第二个参数false -> true   将MQ的队列设置为可持久化的
            //String queue, boolean durable, boolean exclusive, boolean autoDelete, Map<String, Object> arguments
//            channel.queueDeclare(QUEUE_NAME, true, false, false, null);
            for(int i=0;i<100;i++){

                String level = "";
                String message = "";
                if(i % 3 == 0){
                    level = LOG_LEVEL_INFO;
                    message = "LOG_LEVEL_INFO..."+i;
                }else if(i % 3 == 1){
                    level = LOG_LEVEL_WARN;
                    message = "LOG_LEVEL_WARN..."+i;
                }else{
                    level = LOG_LEVEL_ERROR;
                    message = "LOG_LEVEL_ERROR..."+i;
                }


                //第三个参数  意思是这条数据是可持久化的
                //String exchange, String routingKey, BasicProperties props, byte[] body
                channel.basicPublish(EXCHANGE_NAME, level, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes("UTF-8"));
//                System.out.println("已经发送消息....."+message);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        } finally{

        }
    }

}