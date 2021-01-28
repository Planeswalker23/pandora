package io.walkers.planes.pandora.netty.demo.server;

import io.walkers.planes.pandora.netty.demo.ReqAndRes;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

import java.util.List;

/**
 * 客户端传来需要解码
 * ByteBuf to Object
 * @author Planeswalker23
 * @date Created in 2020/2/17
 */
public class ProtocolDecoder extends MessageToMessageDecoder<ByteBuf> {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
        // ProtocolDecoder: No2: 解码器: Buffer(字节) to Object<ReqAndRes>
        // Buffer to Object
        ReqAndRes reqAndRes = new ReqAndRes();
        reqAndRes.decode(msg);
        out.add(reqAndRes);
    }
}
