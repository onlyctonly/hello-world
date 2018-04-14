package com.bashfan.jms_activemp_demo2;

public class TestConsumer {
    public static void main(String[] args){
        Consumer consumer = new Consumer();
        consumer.init();
        TestConsumer testConsumer = new TestConsumer();
        new Thread(testConsumer.new ConsumerMq(consumer)).start();
        new Thread(testConsumer.new ConsumerMq(consumer)).start();
        new Thread(testConsumer.new ConsumerMq(consumer)).start();
        new Thread(testConsumer.new ConsumerMq(consumer)).start();
    }

    private class ConsumerMq implements Runnable{
    	Consumer comsumer;
        public ConsumerMq(Consumer comsumer){
            this.comsumer = comsumer;
        }

        public void run() {
            while(true){
                try {
                    comsumer.getMessage("test");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                	
                }
            }
        }
    }
}