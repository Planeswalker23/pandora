/*
 * Copyright 2012 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package io.walkers.planes.pandora.netty.book.time.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * 由于 Netty 5.X 已经被废弃，这里使用的是 4.1.42.Final 版本，继承 ChannelInboundHandlerAdapter 类
 * @author lilinfeng
 * @date 2014年2月14日
 * @version 1.0
 */
public class TimeServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
    	// 将消息转换成 ByteBuf 对象
		ByteBuf buf = (ByteBuf) msg;
		// 获取缓冲区可读的字节数，创建对应大小的字节数组
		byte[] req = new byte[buf.readableBytes()];
		// 将缓冲区中的字节数组赋值到新建的 byte 数组中
		buf.readBytes(req);
		// 将字节数组转换为 String 类型，转换编码，获取消息内容
		String body = new String(req, "UTF-8");
		System.out.println("The time server receive order : " + body);
		String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body)
				? new java.util.Date(System.currentTimeMillis()).toString() : "BAD ORDER";
		// 创建 ByteBuf 返回消息
		ByteBuf resp = Unpooled.copiedBuffer(currentTime.getBytes());
		// 异步发送应答消息给客户端
		// 此处调用 write 方法只是把待发送的消息放到缓冲数组中
		ctx.write(resp);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
    	// 将消息发送队列总的消息写入到 SocketChannel 中发送给对方
		ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		//打印异常栈跟踪
		cause.printStackTrace();
		//关闭该 Channel
		ctx.close();
    }
}
