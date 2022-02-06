package io.walkers.planes.pandora.design.patterns.strategy.v2;

/**
 * @author Planeswalker23
 */
public class Test {

    public static void main(String[] args) {
        Message message = new Message("老张", "大A", "明天要涨啊！！！");

        // 使用短信通知
        NoticeCenter noticeCenter = new NoticeCenter();
        noticeCenter.setNotify(new Sms());
        noticeCenter.sendMessage(message);

        // 更换策略，使用语音电话通知
        noticeCenter.setNotify(new Call());
        noticeCenter.sendMessage(message);
    }
}
