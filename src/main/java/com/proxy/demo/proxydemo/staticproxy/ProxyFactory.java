package com.proxy.demo.proxydemo.staticproxy;

import com.proxy.demo.proxydemo.dynamicproxy.Claculator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author yy
 * @ProjectName proxy-demo
 * @Description: TODO
 * @date 2018/12/6 12:12
 */
public class ProxyFactory implements InvocationHandler {

    private Class<?> target;

    private Object obj;

    /**
     * 委托类class
     * @param target
     */
    public ProxyFactory(Class<?> target) {
        this.target = target;
    }

    /**
     * 实际执行类bind
     * @param obj
     */
    public Object bind(Object obj) {
        this.obj = obj;
        return Proxy.newProxyInstance(target.getClassLoader(),new Class[]{target},this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("begin method");
        Object invoke = method.invoke(obj,args);
        System.out.println("end method");
        return invoke;
    }
}
    class Main{
        public static void main(String[] args) {
            Claculator proxy = (Claculator) new ProxyFactory(Claculator.class).bind(new Claculator.ClaculatorImpl());
            proxy.add(1,2);
        }
    }