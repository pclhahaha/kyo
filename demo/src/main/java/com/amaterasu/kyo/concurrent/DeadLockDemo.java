package com.amaterasu.kyo.concurrent;

/**
 * @description: 死锁
 * @author: panchenlei
 * @create: 2020-01-04 23:41
 **/
//public class DeadLockDemo {
//
//    private final Object left = new Object();
//    private final Object right = new Object();
//
//    public void leftRight() {
//        // 得到left锁
//        synchronized (left) {
//            // 得到right锁
//            synchronized (right) {
//                doSomething();
//            }
//        }
//    }
//
//    public void rightLeft() {
//        // 得到right锁
//        synchronized (right) {
//            // 得到left锁
//            synchronized (left) {
//                doSomethingElse();
//            }
//        }
//    }
//
//}
//
//
//
//public class CooperatingDeadlock {
//    // Warning: deadlock-prone!
//    class Taxi {
//        @GuardedBy("this") private Point location, destination;
//        private final Dispatcher dispatcher;
//
//        public Taxi(Dispatcher dispatcher) {
//            this.dispatcher = dispatcher;
//        }
//
//        public synchronized Point getLocation() {
//            return location;
//        }
//
//        // setLocation 需要Taxi内置锁
//        public synchronized void setLocation(Point location) {
//            this.location = location;
//            if (location.equals(destination))
//                // 调用notifyAvailable()需要Dispatcher内置锁
//                dispatcher.notifyAvailable(this);
//        }
//
//        public synchronized Point getDestination() {
//            return destination;
//        }
//
//        public synchronized void setDestination(Point destination) {
//            this.destination = destination;
//        }
//    }
//
//    class Dispatcher {
//        @GuardedBy("this") private final Set<Taxi> taxis;
//        @GuardedBy("this") private final Set<Taxi> availableTaxis;
//
//        public Dispatcher() {
//            taxis = new HashSet<Taxi>();
//            availableTaxis = new HashSet<Taxi>();
//        }
//
//        public synchronized void notifyAvailable(Taxi taxi) {
//            availableTaxis.add(taxi);
//        }
//
//        // 调用getImage()需要Dispatcher内置锁
//        public synchronized Image getImage() {
//            Image image = new Image();
//            for (Taxi t : taxis)
//                // 调用getLocation()需要Taxi内置锁
//                image.drawMarker(t.getLocation());
//            return image;
//        }
//    }
//
//    class Image {
//        public void drawMarker(Point p) {
//        }
//    }
//}
