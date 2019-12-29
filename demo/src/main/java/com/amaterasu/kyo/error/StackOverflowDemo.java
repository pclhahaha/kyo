package com.amaterasu.kyo.error;

public class StackOverflowDemo {

    /**
     * 无限递归
     *
     * @param number
     * @return
     */
    public int calculateFactorial(int number) {
        return number * calculateFactorial(number - 1);
    }

    /**
     * 下面两个类演示：类的构造函数间相互循环调用造成StackOverflow
     */
    public static class ClassOne {
        private int oneValue;
        private ClassTwo clsTwoInstance = null;

        public ClassOne() {
            oneValue = 0;
            clsTwoInstance = new ClassTwo();
        }

        public ClassOne(int oneValue, ClassTwo clsTwoInstance) {
            this.oneValue = oneValue;
            this.clsTwoInstance = clsTwoInstance;
        }
    }

    public static class ClassTwo {
        private int twoValue;
        private ClassOne clsOneInstance = null;

        public ClassTwo() {
            twoValue = 10;
            clsOneInstance = new ClassOne();
        }

        public ClassTwo(int twoValue, ClassOne clsOneInstance) {
            this.twoValue = twoValue;
            this.clsOneInstance = clsOneInstance;
        }
    }

    /**
     * 这个类演示：类在实例化时将类的实例作为成员变量
     */
    public class AccountHolder {
        private String firstName;
        private String lastName;

        AccountHolder jointAccountHolder = new AccountHolder();
    }

}
