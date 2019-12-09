package com.amaterasu.kyo.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/nonblockingio", asyncSupported = true)
public class NonBlockingIOServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        AsyncContext context = request.startAsync();
        // set up async listener
        context.addListener(new AsyncListener() {
            public void onComplete(AsyncEvent event) throws IOException {
                event.getSuppliedResponse().getOutputStream().print("Complete");

            }

            public void onError(AsyncEvent event) {
                System.out.println(event.getThrowable());
            }

            public void onStartAsync(AsyncEvent event) {
            }

            public void onTimeout(AsyncEvent event) {
                System.out.println("my asyncListener.onTimeout");
            }
        });
        ServletInputStream input = request.getInputStream();
        ReadListener readListener = new ReadListenerImpl(input, response, context);
        input.setReadListener(readListener);
    }
}
