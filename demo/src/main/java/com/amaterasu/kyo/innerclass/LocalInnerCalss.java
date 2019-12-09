package com.amaterasu.kyo.innerclass;

public class LocalInnerCalss {
    interface Destionation {
        String getName();
    }

    public Destionation destionation(String str) {
        class DomesticDestination implements Destionation {
            private String name;

            private DomesticDestination(String whereTo) {
                name = whereTo;
            }

            public String getName() {
                return name;
            }
        }
        return new DomesticDestination(str);
    }
//    Destionation dest = new DomesticDestination("");//超出方法体无法访问

    private void foreign(boolean b) {
        if (b) {
            class ForeignDestination implements Destionation {
                private String name;

                ForeignDestination(String s) {
                    name = s;
                }

                public String getName() {
                    return name;
                }
            }
            ForeignDestination ts = new ForeignDestination("paris");
            String string = ts.getName();
            System.out.println(string);
        }
//        Destionation ts = new ForeignDestination("chenssy");//出了作用域无法创建对象
    }

    public static void main(String[] args) {
        LocalInnerCalss localInnerCalss = new LocalInnerCalss();
        Destionation d = localInnerCalss.destionation("shanghai");
        System.out.println(d.getName());
        localInnerCalss.foreign(true);
    }
}