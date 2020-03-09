package com.amaterasu.kyo.nioandnetty;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.amaterasu.kyo.nioandnetty.ServerConstant.BIO_PORT;

public class PlainBIOServer {

    public static void main(String[] args) throws IOException {
        PlainBIOServer server = new PlainBIOServer();
        server.serve(BIO_PORT);
    }

    private void serve(int port) throws IOException {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(port));
        while (!Thread.currentThread().isInterrupted()) {
            Socket socket = serverSocket.accept();
            executorService.submit(new ConnectHandler(socket));
        }
    }

    class ConnectHandler extends Thread {
        private Socket socket;

        public ConnectHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            StringBuilder sb = new StringBuilder();
            while (!Thread.currentThread().isInterrupted() && !socket.isClosed()) {
                try {

                    byte[] buffer = new byte[1024];
                    int read = socket.getInputStream().read(buffer);
                    if (read == -1) break;
                    sb.append(new String(buffer, 0, read));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + " read : " + sb.toString());
        }
    }
}
