package io.walkers.planes.pandora.netty.demo.client;

import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

/**
 * 客户端接收数据 解决粘包/半包问题
 * @author Planeswalker23
 * @date Created in 2020/2/17
 */
public class FrameDecoder extends LengthFieldBasedFrameDecoder {

    public FrameDecoder() {
        // FrameDecoder: No3: 客户端解码器: 原始数据流 to ByteBuf(字节)
        super(Integer.MAX_VALUE,0,2,0,2);
    }
}
