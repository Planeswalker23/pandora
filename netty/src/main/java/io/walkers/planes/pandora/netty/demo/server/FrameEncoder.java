package io.walkers.planes.pandora.netty.demo.server;

import io.netty.handler.codec.LengthFieldPrepender;

/**
 * 解决粘包/半包问题
 * @author Planeswalker23
 * @date Created in 2020/2/17
 */
public class FrameEncoder extends LengthFieldPrepender {

    public FrameEncoder() {
        // FrameEncoder: No5: 编码器: ByteBuf(字节) to 原始数据流
        super(2);
    }
}
