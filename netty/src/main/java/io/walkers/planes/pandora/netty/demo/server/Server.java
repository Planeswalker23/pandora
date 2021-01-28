package io.walkers.planes.pandora.netty.demo.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

import java.util.concurrent.ExecutionException;

/**
 * @author Planeswalker23
 * @date Created in 2020/2/17
 */
public class Server {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.channel(NioServerSocketChannel.class);
        // 设置 Reactor 方式
        serverBootstrap.group(new NioEventLoopGroup());
        serverBootstrap.handler(new LoggingHandler(LogLevel.INFO));
        serverBootstrap.childHandler(new ChannelInitializer<NioSocketChannel>() {
            @Override
            protected void initChannel(NioSocketChannel ch) throws Exception {
                ChannelPipeline pipeline = ch.pipeline();

                pipeline.addLast(new FrameDecoder());
                pipeline.addLast(new FrameEncoder());
                pipeline.addLast(new ProtocolEncoder());
                pipeline.addLast(new ProtocolDecoder());
                pipeline.addLast(new WorkHandler());

                pipeline.addLast(new LoggingHandler());
            }
        });

        ChannelFuture channelFuture = serverBootstrap.bind(8001).sync();
        channelFuture.channel().closeFuture().get();
    }
}
