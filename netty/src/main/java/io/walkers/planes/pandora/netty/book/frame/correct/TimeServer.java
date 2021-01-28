package io.walkers.planes.pandora.netty.book.frame.correct;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.TooLongFrameException;
import io.netty.handler.codec.string.StringDecoder;

/**
 * 4.3 利用 {@link LineBasedFrameDecoder} 解决 TCP 粘包问题——服务端
 * @see LineBasedFrameDecoder 是以换行符 ("\n"、"\r\n") 为结束标志的解码器，支持携带结束符或者不懈怠结束符两种解码方式，同时支持配置单行最大长度
 * 						      它的工作原理是一次遍历 {@link io.netty.buffer.ByteBuf} 中的可读字节，判断是否含有换行符，若存在，就以此位置为结束位置，从可读索引到结束位置区间的字节就组成一行
 * 							  如果连续读取到最大长度后仍然没有发现换行符，就会抛出异常，同时忽略调之前读取到的异常码流
 * 							  （例如，抛出 RuntimeException 异常，配置的单行最大长度小于异常码流的总长度，会抛出 {@link TooLongFrameException}异常，忽略之前抛出的 RuntimeException 异常）
 * @see StringDecoder 将接收到的对象转换成字符串，然后继续调用后面的 Handler
 * @author lilinfeng
 * @date 2014年2月14日
 * @version 1.0
 */
public class TimeServer {

    public void bind(int port) throws Exception {
		// 配置服务端的NIO线程组
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		try {
			ServerBootstrap b = new ServerBootstrap();
			b.group(bossGroup, workerGroup)
				.channel(NioServerSocketChannel.class)
				.option(ChannelOption.SO_BACKLOG, 1024)
				.childHandler(new ChildChannelHandler());
			// 绑定端口，同步等待成功
			ChannelFuture f = b.bind(port).sync();

			// 等待服务端监听端口关闭
			f.channel().closeFuture().sync();
		} finally {
			// 优雅退出，释放线程池资源
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
    }

    private class ChildChannelHandler extends ChannelInitializer<SocketChannel> {
		@Override
		protected void initChannel(SocketChannel arg0) throws Exception {
			// 为了解决 TCP 粘包问题，在 TimeServerHandler 之前新增 LineBasedFrameDecoder 和 StringDecoder 解码器
			arg0.pipeline().addLast(new LineBasedFrameDecoder(1024));
			arg0.pipeline().addLast(new StringDecoder());
			arg0.pipeline().addLast(new TimeServerHandler());
		}
    }

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
		int port = 8080;
		new TimeServer().bind(port);
    }
}
