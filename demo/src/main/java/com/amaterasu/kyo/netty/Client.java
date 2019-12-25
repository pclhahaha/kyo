package com.amaterasu.kyo.netty;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

import static com.amaterasu.kyo.netty.ServerConstant.BIO_PORT;
import static com.amaterasu.kyo.netty.ServerConstant.NIO_PORT;

public class Client {

    public static void main(String[] args) throws IOException {
        Client client = new Client();
        client.connectNIO(NIO_PORT);
    }

    void connectBIO(int port) throws IOException {
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress(port));
        System.out.println("bio channel : " + socket.getChannel());
        socket.getOutputStream().write("Hello World!".getBytes());
        socket.close();
    }

    void connectNIO(int port) throws IOException {
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress(port));
        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        int read = -1;
        StringBuilder sb = new StringBuilder();
        while ((read = socketChannel.read(byteBuffer)) != -1) {
            sb.append(new String(byteBuffer.array(), 0, read));
        }
        System.out.println(sb.toString());
    }
}
