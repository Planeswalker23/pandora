package io.walkers.planes.pandora.netty.book.time.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Netty 实现的 Time —— 服务端
 * @author Lilinfeng
 * @date 2014年3月15日
 * @version 1.0
 */
public class TimeServer {

    public void bind(int port) throws Exception {
		// 配置服务端的 NIO 线程组
		// 一个用于服务端接收客户端的连接，另一个用于进行 SocketChannel 的网络读写
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		try {
			// Netty 用于启动 NIO 服务的辅助启动类，目的是降低服务端的开发复杂度
			ServerBootstrap b = new ServerBootstrap();
			b.group(bossGroup, workerGroup)
					.channel(NioServerSocketChannel.class)
					// 将 backlog 设置为1024
					.option(ChannelOption.SO_BACKLOG, 1024)
					// 作用类似于 Reactor 模式中的 Handler 类，主要用于处理网络 I/O 事件，例如记录日志、对消息进行编解码等
					.childHandler(new ChildChannelHandler());

			// 绑定监听端口
			ChannelFuture f = b.bind(port)
					// 等待绑定操作完成
					.sync();

			// 绑定完成后 Netty 会返回一个 ChannelFuture 类，主要用于异步操作的通知回调
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
			arg0.pipeline().addLast(new TimeServerHandler());
		}
	}

	/**
	 * 启动 Time 服务器
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		int port = 8080;
		new TimeServer().bind(port);
	}
}
