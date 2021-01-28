package io.walkers.planes.pandora.mq.transaction;

import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * 事务监听器
 * @author Planeswalker23
 * @date Created in 2020/5/30
 */
public class TransactionListenerImpl implements org.apache.rocketmq.client.producer.TransactionListener {

    /**
     * 存储对应事务的状态信息
     */
    private ConcurrentHashMap<String, Integer> localTrans = new ConcurrentHashMap<>();

    /**
     * 执行本地事务
     *
     * @param msg Half(prepare) message
     * @param arg Custom business parameter
     * @return Transaction state
     */
    @Override
    public LocalTransactionState executeLocalTransaction(Message msg, Object arg) {
        // 事务ID
        String transactionId = msg.getTransactionId();

        // 0-执行中，状态未知 1-本地事务执行成功 2-本地事务执行失败
        localTrans.put(transactionId, 0);

        // 业务执行，处理本地事务，service
        System.out.println("transactionId: " + transactionId + " is being handled!");

        try {
            System.out.println("正在执行本地事务");
            TimeUnit.SECONDS.sleep(60+10);
            System.out.println("本地事务执行成功");
            localTrans.put(transactionId, 1);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("本地事务执行失败");
            localTrans.put(transactionId, 2);
            // 事务回滚
            return LocalTransactionState.ROLLBACK_MESSAGE;
        }

        // 提交事务
        return LocalTransactionState.COMMIT_MESSAGE;
    }

    /**
     * 消息回答
     *
     * @param msg Check message
     * @return Transaction state
     */
    @Override
    public LocalTransactionState checkLocalTransaction(MessageExt msg) {
        // 获取对应事务的执行状态
        String transactionId = msg.getTransactionId();
        Integer status = localTrans.get(transactionId);

        System.out.println("消息回答---> id:" + transactionId + ", 状态:" + status);

        switch (status) {
            case 0:
                return LocalTransactionState.UNKNOW;
            case 1:
                return LocalTransactionState.COMMIT_MESSAGE;
            case 2:
                return LocalTransactionState.ROLLBACK_MESSAGE;
        }
        return LocalTransactionState.UNKNOW;
    }
}
