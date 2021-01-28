package io.walkers.planes.pandora.mq.quickstart;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.io.UnsupportedEncodingException;

/**
 * QuickStart 消息生产者
 * @author Planeswalker23
 * @date Created in 2020/5/29
 */
public class Producer {

    public static void main(String[] args) throws MQClientException, UnsupportedEncodingException, RemotingException, InterruptedException, MQBrokerException {

        // 1. 创建 DefaultMQProducer，设置组名
        DefaultMQProducer producer = new DefaultMQProducer("quickstart-group");

        // 2. 设置 NameSer 地址
        producer.setNamesrvAddr("localhost:9876");

        // 3. 开启 DefaultMQProducer
        producer.start();

        // 4. 创建消息 Message(主题，标签，key，value)
        Message message = new Message("quickstart-topic",
                "quickstart-tag",
                "quickstart-key",
                "This is a body for quickstart".getBytes(RemotingHelper.DEFAULT_CHARSET));

        // 5. 发送消息
        SendResult result = producer.send(message);
        System.out.println(result);

        // 6. 关闭 DefaultMQProducer
        producer.shutdown();

    }
}
