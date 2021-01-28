package io.walkers.planes.pandora.netty.demo.server;

import io.walkers.planes.pandora.netty.demo.ReqAndRes;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author Planeswalker23
 * @date Created in 2020/2/17
 */
public class WorkHandler extends SimpleChannelInboundHandler<ReqAndRes> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ReqAndRes msg) throws Exception {
        // WorkHandler: No3: 业务处理器
        int value = msg.getValue();
        System.out.println("传入的信息是：" + msg);
        int newValue = 100-value;
        msg.setValue(newValue);
        System.out.println("返回的信息是：" + msg);
        // 返回 ReqAndRes 类
        ctx.writeAndFlush(msg);
    }
}
