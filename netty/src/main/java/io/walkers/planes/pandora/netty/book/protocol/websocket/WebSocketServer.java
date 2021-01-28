package io.walkers.planes.pandora.netty.book.protocol.websocket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.stream.ChunkedWriteHandler;

/** chapter11 Netty 基于 WebSocket 协议栈开发的服务端
 * WebSocket 协议的目的是为了解决 HTTP 协议效率低下的问题
 * 					   为了取代轮询和 Comet 技术，使客户端浏览器具备像 C/S 结构下桌面系统一样的实时通信能力
 * @author lilinfeng
 * @date 2014年2月14日
 * @version 1.0
 */
public class WebSocketServer {

    public void run(int port) throws Exception {
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		try {
			ServerBootstrap b = new ServerBootstrap();
			b.group(bossGroup, workerGroup)
				.channel(NioServerSocketChannel.class)
				.childHandler(new ChannelInitializer<SocketChannel>() {
					@Override
					protected void initChannel(SocketChannel ch) throws Exception {
						ChannelPipeline pipeline = ch.pipeline();
						pipeline.addLast("http-codec", new HttpServerCodec());
						pipeline.addLast("aggregator", new HttpObjectAggregator(65536));
						ch.pipeline().addLast("http-chunked", new ChunkedWriteHandler());
						pipeline.addLast("handler", new WebSocketServerHandler());
					}
				});

			Channel ch = b.bind(port).sync().channel();
			System.out.println("Web socket server started at port " + port + '.');
			System.out.println("Open your browser and navigate to http://localhost:" + port + '/');
			ch.closeFuture().sync();
		} finally {
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
    }

    public static void main(String[] args) throws Exception {
		int port = 8080;
		new WebSocketServer().run(port);
    }
}
