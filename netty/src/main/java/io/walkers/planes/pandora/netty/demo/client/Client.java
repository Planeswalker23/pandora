package io.walkers.planes.pandora.netty.demo.client;

import io.walkers.planes.pandora.netty.demo.ReqAndRes;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

import java.util.concurrent.ExecutionException;

/**
 * @author Planeswalker23
 * @date Created in 2020/2/17
 */
public class Client {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        Bootstrap bootstrap = new Bootstrap();
        bootstrap.channel(NioSocketChannel.class);
        // 设置 Reactor 方式
        bootstrap.group(new NioEventLoopGroup());
        bootstrap.handler(new ChannelInitializer<NioSocketChannel>() {
            @Override
            protected void initChannel(NioSocketChannel ch) throws Exception {
                ChannelPipeline pipeline = ch.pipeline();

                pipeline.addLast(new FrameDecoder());
                pipeline.addLast(new FrameEncoder());
                pipeline.addLast(new ProtocolEncoder());
                pipeline.addLast(new ProtocolDecoder());
                pipeline.addLast(new ProtocolEncoder());

                pipeline.addLast(new LoggingHandler(LogLevel.INFO));
            }
        });

        ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 8001).sync();

        ReqAndRes msg = new ReqAndRes(12);
        channelFuture.channel().writeAndFlush(msg);

        channelFuture.channel().closeFuture().get();
    }
}
