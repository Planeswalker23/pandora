package io.walkers.planes.pandora.netty.demo.server;

import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

/**
 * 解决粘包/半包问题
 * @author Planeswalker23
 * @date Created in 2020/2/17
 */
public class FrameDecoder extends LengthFieldBasedFrameDecoder {

    public FrameDecoder() {
        // FrameDecoder: No1: 解码器: 原始数据流 to ByteBuf(字节)
        super(Integer.MAX_VALUE,0,2,0,2);
    }
}
