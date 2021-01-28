package io.walkers.planes.pandora.netty.book.protocol.fileserver;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * 基于 Netty 的 HTTP 文件服务端
 * @author lilinfeng
 * @date 2014年2月14日
 * @version 1.0
 */
public class HttpFileServer {

    public void run(final int port, final String url) throws Exception {
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		try {
			ServerBootstrap b = new ServerBootstrap();
			b.group(bossGroup, workerGroup)
				.channel(NioServerSocketChannel.class)
				.childHandler(new ChannelInitializer<SocketChannel>() {
					@Override
					protected void initChannel(SocketChannel ch) throws Exception {
						// 请求消息解码器
						ch.pipeline().addLast("http-decoder", new HttpRequestDecoder());
						// 目的是将多个消息转换为单一的request或者response对象
						// 因为 HTTP 解码器在每个 HTTP 消息中会生成多个消息对象
						ch.pipeline().addLast("http-aggregator", new HttpObjectAggregator(65536));
						// 响应解码器
						ch.pipeline().addLast("http-encoder", new HttpResponseEncoder());
						// 目的是支持异步大文件传输
						// 但不用过多的内存，防止发生 Java 内存溢出错误
						ch.pipeline().addLast("http-chunked", new ChunkedWriteHandler());
						// 业务逻辑
						ch.pipeline().addLast("fileServerHandler", new HttpFileServerHandler(url));
					}
				});
			ChannelFuture future = b.bind("127.0.0.1", port).sync();
			System.out.println("HTTP文件目录服务器启动，网址是 : " + "http://127.0.0.1:" + port + url);
			future.channel().closeFuture().sync();
		} finally {
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
    }

    public static void main(String[] args) throws Exception {
		int port = 8080;
		// 基于模块化的项目，需要将 url 定义为如下的路径
		String url = "/netty/netty-definitive-guide/src/main/java/org/planeswalker";
		new HttpFileServer().run(port, url);
    }
}
