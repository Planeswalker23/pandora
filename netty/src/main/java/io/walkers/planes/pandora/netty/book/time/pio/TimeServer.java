package io.walkers.planes.pandora.netty.book.time.pio;


import io.walkers.planes.pandora.netty.book.time.bio.TimeServerHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 伪异步 I/O 实现的 Timer
 * 弊端：伪异步 I/O 无法从根本上解决同步 I/O 导致的通信线程阻塞问题
 * 阻塞的时间取决于对方 I/O 线程的处理速度和网络 I/O 的传输速度
 * @author lilinfeng
 * @date 2014年2月14日
 * @version 1.0
 */
public class TimeServer {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
		int port = 8080;
		ServerSocket server = null;
		try {
			server = new ServerSocket(port);
			System.out.println("The time server is start in port : " + port);
			Socket socket = null;
			// 创建IO任务线程池
			TimeServerHandlerExecutePool singleExecutor = new TimeServerHandlerExecutePool(50, 10000);
			while (true) {
			socket = server.accept();
			singleExecutor.execute(new TimeServerHandler(socket));
			}
		} finally {
			if (server != null) {
			System.out.println("The time server close");
			server.close();
			server = null;
			}
		}
    }
}
