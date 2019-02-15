package com.whl.mq.rabbitmq.helloworld;

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

    private final static String QUEUE_NAME = "Queue20190122";

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
            channel.queueDeclare(QUEUE_NAME, true, false, false, null);
            for(int i=0;i<100;i++){


                String message = "my message ....."+i;
                //第三个参数  意思是这条数据是可持久化的
                //String exchange, String routingKey, BasicProperties props, byte[] body
                channel.basicPublish("", QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes("UTF-8"));
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