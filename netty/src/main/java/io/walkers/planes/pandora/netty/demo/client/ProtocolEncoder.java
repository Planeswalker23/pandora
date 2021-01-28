package io.walkers.planes.pandora.netty.demo.client;

import io.walkers.planes.pandora.netty.demo.ReqAndRes;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.util.List;

/**
 * 客户端发送数据 编码器
 * Object to ByteBuf
 * @author Planeswalker23
 * @date Created in 2020/2/17
 */
public class ProtocolEncoder extends MessageToMessageEncoder<ReqAndRes> {

    protected void encode(ChannelHandlerContext ctx, ReqAndRes msg, List<Object> out) throws Exception {
        // ProtocolEncoder: No1: 客户端编码器: Object<ReqAndRes> to ByteBuf(字节)
        // 获取一个新的 ByteBuf
        ByteBuf byteBuf = ctx.alloc().buffer();
        // 编码
        msg.encode(byteBuf);
        // 输出
        out.add(byteBuf);
    }
}
