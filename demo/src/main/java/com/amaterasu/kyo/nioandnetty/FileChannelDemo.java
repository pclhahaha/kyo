package com.amaterasu.kyo.nioandnetty;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @description:
 * @author: panchenlei
 * @create: 2020-03-05 23:46
 **/
public class FileChannelDemo {

    public static void main(String[] args) throws IOException {
        RandomAccessFile aFile = new RandomAccessFile("nio-data.txt", "rw");
        FileChannel fileChannel = aFile.getChannel();

        ByteBuffer inBuf = ByteBuffer.allocate(48);
        ByteBuffer outBuf = ByteBuffer.allocate(48);
        outBuf.put("data".getBytes());
        fileChannel.write(outBuf);
        int bytesRead = fileChannel.read(inBuf);
        while (bytesRead != -1) {

            System.out.println("Read " + bytesRead);
            inBuf.flip();

            while (inBuf.hasRemaining()) {
                System.out.print((char) inBuf.get());
            }

            inBuf.clear();
            bytesRead = fileChannel.read(inBuf);
        }
        aFile.close();
    }

}
