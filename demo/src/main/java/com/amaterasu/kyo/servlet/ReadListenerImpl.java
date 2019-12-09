package com.amaterasu.kyo.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class ReadListenerImpl implements ReadListener {

    ServletInputStream inputStream = null;
    HttpServletResponse response = null;
    AsyncContext asyncContext = null;
    Queue queue = new LinkedBlockingQueue();

    public ReadListenerImpl(ServletInputStream inputStream, HttpServletResponse response, AsyncContext asyncContext) {
        this.inputStream = inputStream;
        this.response = response;
        this.asyncContext = asyncContext;
    }

    @Override
    public void onDataAvailable() throws IOException {
        System.out.println("Data is available");

        StringBuilder sb = new StringBuilder();
        int len = -1;
        byte b[] = new byte[1024];
        while (inputStream.isReady() && (len = inputStream.read(b)) != -1) {
            String data = new String(b, 0, len);
            sb.append(data);
        }
        queue.add(sb.toString());
    }

    @Override
    public void onAllDataRead() throws IOException {
        System.out.println("Data is all read");

        // now all data are read, set up a WriteListener to write
        ServletOutputStream output = response.getOutputStream();
        WriteListener writeListener = new WriteListenerImpl(output, queue, asyncContext);
        output.setWriteListener(writeListener);
    }

    @Override
    public void onError(Throwable throwable) {
        asyncContext.complete();
        throwable.printStackTrace();
    }
}
