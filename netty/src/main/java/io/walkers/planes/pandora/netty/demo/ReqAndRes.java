package io.walkers.planes.pandora.netty.demo;

import io.netty.buffer.ByteBuf;

/**
 * @author Planeswalker23
 * @date Created in 2020/2/17
 */
public class ReqAndRes {

    private int value;

    public ReqAndRes() {
    }

    public ReqAndRes(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ReqAndRes{" +
                "value=" + value +
                '}';
    }

    /**
     * 解码，ByteBuf to ReqAndRes
     * @param byteBuf
     */
    public void decode(ByteBuf byteBuf) {
        this.value = byteBuf.readInt();
    }

    /**
     * 编码，ReqAndRes to ByteBuf
     * @param byteBuf
     */
    public void encode(ByteBuf byteBuf) {
        byteBuf.writeInt(this.value);
    }
}
