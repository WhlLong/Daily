package com.whl.mq.rabbitmq.helloworld;


import com.rabbitmq.client.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.TimeoutException;

/**
 * 〈消费者〉
 *
 * @author whl
 * @create 2019/1/22
 * @since 1.0.0
 */
public class Receiver1 {

        private final static String QUEUE_NAME = "Queue20190122";

        public static void main(String[] args) {
            receive();
        }

        public static void receive()
        {
            ConnectionFactory factory = null;
            Connection connection = null;
            Channel channel = null;

            try {
                factory = new ConnectionFactory();
                factory.setHost("localhost");
                connection = factory.newConnection();
                channel = connection.createChannel();
                //第二个参数false -> true   将MQ的队列设置为可持久化的
                channel.queueDeclare(QUEUE_NAME, true, false, false, null);
                //设置最大的unnack消息数量
                channel.basicQos(5);
                Channel finalChannel = channel;
                DeliverCallback callback = (String consumerTag, Delivery delivery) -> {
                    try {
                        doWork(consumerTag,delivery);

                        //手动ack
                        finalChannel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
                    }catch(Exception e){
                        //消费失败，nack
                        //long deliveryTag, boolean multiple, boolean requeue
                        finalChannel.basicNack(delivery.getEnvelope().getDeliveryTag(),false,true);
                    }
                };

                //true -> false  自动ack修改为手动ack
                channel.basicConsume(QUEUE_NAME, false, callback, new CancelCallback() {
                    @Override
                    public void handle(String s) throws IOException {
                        System.out.println("CancelCallback.handle : "+s);
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {

                e.printStackTrace();
            } finally{
               /* try {
                    //关闭资源
                    channel.close();
                    connection.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (TimeoutException e) {
                    e.printStackTrace();
                }*/
            }
        }

    private static void doWork(String consumerTag, Delivery delivery) throws UnsupportedEncodingException, InterruptedException {
            Thread.sleep(1000);
        String message = new String(delivery.getBody(), "UTF-8");
        System.out.println(" [x] Received '" + message + "'");
    }


}