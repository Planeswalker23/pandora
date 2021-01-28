package io.walkers.planes.pandora.mq.boardcasting;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * 广播模式 消息生产者
 * @author Planeswalker23
 * @date Created in 2020/5/29
 */
public class BoardCastingProducer {

    public static void main(String[] args) throws MQClientException, UnsupportedEncodingException, RemotingException, InterruptedException, MQBrokerException {

        // 1. 创建 DefaultMQProducer，设置组名
        DefaultMQProducer producer = new DefaultMQProducer("board-casting-group");

        // 2. 设置 NameSer 地址
        producer.setNamesrvAddr("localhost:9876");

        // 3. 开启 DefaultMQProducer
        producer.start();


        // 4. 创建批量消息 Message(主题，标签，key，value)
        List<Message> messages = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            Message message = new Message("board-casting-topic",
                    "board-casting-tag",
                    "board-casting-key",
                    ("This is a body for board-casting: ["+i+"].").getBytes(RemotingHelper.DEFAULT_CHARSET));
            messages.add(message);
        }

        // 5. 发送消息
        SendResult result = producer.send(messages);
        System.out.println(result);

        // 6. 关闭 DefaultMQProducer
        producer.shutdown();

    }
}
