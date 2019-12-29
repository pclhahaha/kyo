package com.amaterasu.kyo.jvm;

import org.openjdk.jol.info.ClassLayout;

/**
 * @description: 对象field重排序优化内存占用
 * @author: panchenlei
 * @create: 2019-12-29 20:52
 **/
public class Reorder {

    private byte a;

    private int b;

    private boolean c;

    private float d;

    private Object e;

    /**
     * com.amaterasu.kyo.jvm.Reorder object internals:
     * OFFSET  SIZE               TYPE DESCRIPTION                               VALUE
     * 0    12                    (object header)                           N/A
     * 12     4                int Reorder.b                                 N/A
     * 16     4              float Reorder.d                                 N/A
     * 20     1               byte Reorder.a                                 N/A
     * 21     1            boolean Reorder.c                                 N/A
     * 22     2                    (alignment/padding gap)
     * 24     4   java.lang.Object Reorder.e                                 N/A
     * 28     4                    (loss due to the next object alignment)
     * Instance size: 32 bytes
     * Space losses: 2 bytes internal + 4 bytes external = 6 bytes total
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(ClassLayout.parseClass(Reorder.class).toPrintable());
    }
}
