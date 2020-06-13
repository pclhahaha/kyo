package com.amaterasu.kyo.leetcode;

/**
 * @description:
 * @author: panchenlei
 * @create: 2020-03-14 23:39
 **/
public class DiningPhilosophers {

    public DiningPhilosophers() {

    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {


        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        putRightFork.run();
        putLeftFork.run();
    }

}
