package com.proxy.demo.proxydemo.cglib;

import com.proxy.demo.proxydemo.dynamicproxy.Claculator;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author yy
 * @ProjectName proxy-demo
 * @Description: TODO
 * @date 2018/12/6 14:58
 */
public class Main {


    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Claculator.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("begin method");
                Object invoke = methodProxy.invoke(new Claculator.ClaculatorImpl(),objects);
                System.out.println("end mehtod");
                return invoke;
            }
        });
        Claculator proxy = (Claculator) enhancer.create();
        proxy.add(1,2);
    }


}
