package com.amaterasu.kyo.error;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @description:
 * @author: panchenlei
 * @create: 2019-12-29 13:24
 **/
public class StackOverflowDemoTest {

    @Test(expected = StackOverflowError.class)
    public void givenPositiveIntNoOne_whenCalFact_thenThrowsException() {
        int numToCalcFactorial= 1;
        StackOverflowDemo uir
                = new StackOverflowDemo();

        uir.calculateFactorial(numToCalcFactorial);
    }

    @Test(expected = StackOverflowError.class)
    public void whenInstanciatingClassOne_thenThrowsException() {
        StackOverflowDemo.ClassOne obj = new StackOverflowDemo.ClassOne();
    }

    @Test(expected = StackOverflowError.class)
    public void whenInstanciatingAccountHolder_thenThrowsException() {
        StackOverflowDemo.AccountHolder holder = new StackOverflowDemo().new AccountHolder();
    }
}