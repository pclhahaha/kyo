package com.amaterasu.kyo.runtime;

import ognl.OgnlException;

import java.util.Map;

/**
 * @description: ognl
 * @author: panchenlei
 * @create: 2020-01-12 11:18
 **/
public class OgnlDemo {
    /**
     * 通过传入的OGNL表达式，在给定的上下文环境中，从root对象里取值
     */
//    public static Object getValue(String expression, Map context, Object root) throws OgnlException {
//        return getValue(expression, context, root, null);
//    }

    /**
     * 通过传入的OGNL表达式，在给定的上下文环境中，往root对象里写值
     */
    public static void setValue(String expression, Map context, Object root, Object value) throws OgnlException {
//        setValue(parseExpression(expression), context, root, value);
    }
}
