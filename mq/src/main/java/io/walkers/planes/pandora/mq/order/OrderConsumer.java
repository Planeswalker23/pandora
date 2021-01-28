package io.walkers.planes.pandora.mq.order;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.*;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * 顺序 消息消费者
 * @author Planeswalker23
 * @date Created in 2020/5/29
 */
public class OrderConsumer {

    public static void main(String[] args) throws MQClientException, InterruptedException {
        // 1. 创建 DefaultMQProducer，设置组名
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("order-group");

        // 2. 设置 NameSer 地址
        consumer.setNamesrvAddr("localhost:9876");

        // 3. 设置 subscribe，这里是要读取主题信息，参数1消息主题，参数2过滤规则
        consumer.subscribe("order-topic", "*");

        // 4. 创建消息监听 MessageListener
        consumer.setMessageListener(new MessageListenerOrderly() {
            @Override
            public ConsumeOrderlyStatus consumeMessage(List<MessageExt> msgs, ConsumeOrderlyContext context) {
                // 迭代消息信息
                for (MessageExt msg:msgs){
                    // 获取主题
                    String topic = msg.getTopic();
                    // 获取标签
                    String tags = msg.getTags();

                    // 获取消息体
                    byte[] body = msg.getBody();
                    try {
                        String result = new String(body, RemotingHelper.DEFAULT_CHARSET);
                        System.out.println("consumer 消费信息 --> topic:" + topic + ", tags:" + tags + ", result:" + result);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                        // 消息重试
                        return ConsumeOrderlyStatus.SUSPEND_CURRENT_QUEUE_A_MOMENT;
                    }

                }
                // 6. 返回消息消费状态
                // 消息消费成功
                return ConsumeOrderlyStatus.SUCCESS;
            }
        });

        // 7. 启动消费监听
        consumer.start();
    }
}
