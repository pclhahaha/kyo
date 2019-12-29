package com.amaterasu.kyo.innerclass;

/**
 * @description: 内部类demo
 * @author: panchenlei
 * @create: 2019-12-29 19:52
 **/
class Outter {
    // 成员内部类
    class Inner {
        public void show() {
            System.out.println("In a nested class method");
        }
// 成员内部类不能有静态方法
//        public static void main(String[] args){
//            System.out.println("inside inner class Method");
//        }
    }

    private static void outerStaticMethod() {
        System.out.println("inside outerMethod");
    }

    // 静态内部类
    static class StaticInner {
        public static void main(String[] args) {
            System.out.println("inside inner class Method");
            outerStaticMethod();
        }
    }

    /**
     * 局部内部类
     * Local inner class cannot access non-final local variable till JDK 1.7.
     * Since JDK 1.8, it is possible to access the non-final local variable in method local inner class.
     */
    void outerMethod() {
        int x = 98;
        System.out.println("inside outerMethod");
        class Inner {
            void innerMethod() {
                System.out.println("x= " + x);
            }
        }
        Inner y = new Inner();
        y.innerMethod();
    }
}

class Main {
    public static void main(String[] args) {
        Outter.Inner in = new Outter().new Inner();
        in.show();

        Outter x = new Outter();
        x.outerMethod();
    }
}

/**
 * 匿名内部类
 */
class Demo {
    void show() {
        System.out.println("i am in show method of super class");
    }
}

class Flavor1Demo {

    // An anonymous class with Demo as base class
    static Demo d = new Demo() {
        void show() {
            super.show();
            System.out.println("i am in Flavor1Demo class");
        }
    };

    public static void main(String[] args) {
        d.show();
    }
}

class Flavor2Demo {

    // An anonymous class that implements Hello interface
    static Hello h = new Hello() {
        public void show() {
            System.out.println("i am in anonymous class");
        }
    };

    public static void main(String[] args) {
        h.show();

        int x = 100;
        Hello testFinal = new Hello() {
            public void show() {
                System.out.println("i am in anonymous class:" + x);
            }
        };
        testFinal.show();
    }
}

interface Hello {
    void show();
}
