package io.walkers.planes.pandora.netty.book.time.nio;

/**
 * @author lilinfeng
 * @date 2014年2月14日
 * @version 1.0
 */
public class TimeClient {

    /**
     * @param args
     */
    public static void main(String[] args) {

		int port = 8080;
		new Thread(new TimeClientHandle("127.0.0.1", port), "TimeClient-001").start();
    }
}
