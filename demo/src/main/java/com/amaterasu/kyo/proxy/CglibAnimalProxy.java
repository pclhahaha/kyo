package com.amaterasu.kyo.proxy;


import com.alibaba.fastjson.JSON;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibAnimalProxy<T> implements MethodInterceptor {

    // 相当于JDK动态代理中的绑定
    public T getInstance(Class target) {
        Enhancer enhancer = new Enhancer(); // 创建加强器，用来创建动态代理类
        enhancer.setSuperclass(target); // 为加强器指定要代理的业务类（即：为下面生成的代理类指定父类）
        // 设置回调：对于代理类上所有方法的调用，都会调用CallBack，而Callback则需要实现intercept()方法进行拦截
        enhancer.setCallback(this);
        // 创建动态代理类对象并返回
        return (T) enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib before invoke method:" + method);
        System.out.println("cglib object:" + o.getClass().getName() + "," + method.getName() + "," + JSON.toJSONString(objects) + "," + methodProxy.getSuperName());
        Object obj = methodProxy.invokeSuper(o, objects);
        System.out.println(obj.toString());
        System.out.println("cglib after invoke method:" + method);
        return obj;
    }
}
