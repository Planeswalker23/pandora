package io.walkers.planes.pandora.mq.order;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * 顺序 消息生产者
 * @author Planeswalker23
 * @date Created in 2020/5/29
 */
public class OrderProducer {

    public static void main(String[] args) throws MQClientException, UnsupportedEncodingException, RemotingException, InterruptedException, MQBrokerException {

        // 1. 创建 DefaultMQProducer，设置组名
        DefaultMQProducer producer = new DefaultMQProducer("order-group");

        // 2. 设置 NameSer 地址
        producer.setNamesrvAddr("localhost:9876");

        // 3. 开启 DefaultMQProducer
        producer.start();



        // 5. 发送消息
        for (int i = 0; i < 5; i++) {
            // 4. 创建消息 Message(主题，标签，key，value)
            Message message = new Message("order-topic",
                    "order-tag",
                    "order-key",
                    ("This is a body for order: ["+i+"].").getBytes(RemotingHelper.DEFAULT_CHARSET));
            sendMessage(producer, message);
        }

        // 6. 关闭 DefaultMQProducer
        producer.shutdown();

    }

    private static void sendMessage(DefaultMQProducer producer, Message message) throws InterruptedException, RemotingException, MQClientException, MQBrokerException {
        // 参数1：发送的消息信息
        // 参数2：选择指定的消息队列对象（将所有消息队列传入进来）
        // 参数3：指定对应的队列下标
        SendResult result = producer.send(message, new MessageQueueSelector() {
                    @Override
                    public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {
                        Integer index = (Integer) arg;
                        // 获取响应下标的队列
                        return mqs.get(index);
                    }}
                ,0);
        System.out.println(result);
    }
}
