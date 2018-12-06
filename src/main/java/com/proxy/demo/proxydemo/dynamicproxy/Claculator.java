package com.proxy.demo.proxydemo.dynamicproxy;

/**
 * @author yy
 * @ProjectName proxy-demo
 * @Description: TODO 计算器接口
 * @date 2018/12/6 11:54
 */
public interface Claculator {


    int add(int a,int b);

    public static class ClaculatorImpl implements Claculator{
        @Override
        public int add(int a, int b) {
            System.out.println("doing");
            return a+b;
        }
    }
    class ClaculatorProxy implements  Claculator{

        private Claculator claculator;

        public ClaculatorProxy(Claculator claculator) {
            this.claculator = claculator;
        }

        @Override
        public int add(int a, int b) {
            //调用代理类之前执行了方法
            System.out.println("begin method");
            int result = claculator.add(a,b);
            //调用代理类之后执行了方法
            System.out.println("end method");
            return result;
        }
    }
    class Main {
        public static void main(String[] args) {
            Claculator claculatorimpl = new ClaculatorImpl();
            Claculator claculator = new ClaculatorProxy(claculatorimpl);
            claculator.add(1,2);
        }
    }

}
