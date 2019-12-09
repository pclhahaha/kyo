package com.amaterasu.kyo.servlet;

import javax.servlet.AsyncContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import java.io.IOException;
import java.util.Queue;

public class WriteListenerImpl implements WriteListener {

    ServletOutputStream outputStream = null;
    Queue queue = null;
    AsyncContext asyncContext = null;

    public WriteListenerImpl(ServletOutputStream outputStream, Queue queue, AsyncContext asyncContext) {
        this.outputStream = outputStream;
        this.queue = queue;
        this.asyncContext = asyncContext;
    }

    @Override
    public void onWritePossible() throws IOException {
        while (queue.peek() != null && outputStream.isReady()) {
            String data = (String) queue.poll();
            outputStream.print(data);
        }
        if (queue.peek() == null) {
            asyncContext.complete();
        }
    }

    @Override
    public void onError(Throwable throwable) {
        asyncContext.complete();
        throwable.printStackTrace();
    }
}
