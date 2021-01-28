package io.walkers.planes.pandora.netty.demo.client;

import io.netty.handler.codec.LengthFieldPrepender;

/**
 * 客户端发送数据 解决粘包/半包问题 编码器
 * @author Planeswalker23
 * @date Created in 2020/2/17
 */
public class FrameEncoder extends LengthFieldPrepender {

    public FrameEncoder() {
        // FrameEncoder: No2: 客户端编码器: ByteBuf(字节) to 原始数据流
        super(2);
    }
}
