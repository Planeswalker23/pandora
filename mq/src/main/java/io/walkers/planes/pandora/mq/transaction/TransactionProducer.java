package io.walkers.planes.pandora.mq.transaction;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.client.producer.TransactionSendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.*;

/**
 * 事务 消息生产者
 * @author Planeswalker23
 * @date Created in 2020/5/29
 */
public class TransactionProducer {

    public static void main(String[] args) throws MQClientException, UnsupportedEncodingException {

        // 1. 创建 DefaultMQProducer，设置组名
        TransactionMQProducer producer = new TransactionMQProducer("transaction-group");

        // 2. 设置 NameSer 地址
        producer.setNamesrvAddr("localhost:9876");

        // 2.1 指定消息监听对象，同于执行本地事务和消息回答
        TransactionListenerImpl transactionListener = new TransactionListenerImpl();
        producer.setTransactionListener(transactionListener);

        // 2.2 创建线程池，模拟多线程操作
        ThreadFactory factory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setName("transaction-thead-pool-%d");
                return thread;
            }
        };
        ExecutorService executorService = new ThreadPoolExecutor(2,
                5,
                100,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2000),
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread thread = new Thread(r);
                        thread.setName("transaction-thead-pool-%d");
                        return thread;
                }});
        producer.setExecutorService(executorService);


        // 3. 开启 DefaultMQProducer
        producer.start();

        // 4. 创建消息 Message(主题，标签，key，value)
        Message message = new Message("transaction-topic",
                "transaction-tag",
                "transaction-key",
                "This is a body for transaction".getBytes(RemotingHelper.DEFAULT_CHARSET));

        // 5. 发送事务消息
        TransactionSendResult result = producer.sendMessageInTransaction(message, "transaction");
        System.out.println(result);

        // 6. 关闭 DefaultMQProducer
        producer.shutdown();

    }
}
