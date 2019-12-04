package com.amaterasu.kyo.lambda;

import java.lang.annotation.Annotation;

public class FuncInterfaceImpl implements FuncInterface {

    @Override
    public String hello() {
        return "hello";
    }
}
