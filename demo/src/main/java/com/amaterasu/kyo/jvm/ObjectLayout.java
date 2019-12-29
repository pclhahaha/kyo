package com.amaterasu.kyo.jvm;

import org.openjdk.jol.vm.VM;

/**
 * @description: 对象存储分布
 * @author: panchenlei
 * @create: 2019-12-29 20:42
 **/
public class ObjectLayout {

    /**
     * # Running 64-bit HotSpot VM.
     * # Using compressed oop with 3-bit shift.
     * # Using compressed klass with 3-bit shift.
     * # WARNING | Compressed references base/shifts are guessed by the experiment!
     * # WARNING | Therefore, computed addresses are just guesses, and ARE NOT RELIABLE.
     * # WARNING | Make sure to attach Serviceability Agent to get the reliable addresses.
     * # Objects are 8 bytes aligned.  // 以 8 bytes的粒度对齐
     * # Field sizes by type: 4, 1, 1, 2, 2, 4, 4, 8, 8 [bytes]    // 分别对应[Oop(Object Original Pointer), boolean, byte, char, short, int, float, long, double]的大小
     * # Array element sizes: 4, 1, 1, 2, 2, 4, 4, 8, 8 [bytes]    // 数组中元素的大小，分别对应的是[Oop(Object Original Pointer), boolean, byte, char, short, int, float, long, double]
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(VM.current().details());
    }
}
