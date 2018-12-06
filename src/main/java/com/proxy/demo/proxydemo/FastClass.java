package com.proxy.demo.proxydemo;

/**
 * @author yy
 * @ProjectName proxy-demo
 * @Description: TODO
 * @date 2018/12/6 15:10
 */
public class FastClass {

    public int getIndex(String signature){
        //方法签名做hash
        switch (signature.hashCode()){
            case 3078479:
                return 1;
            case 3108270:
                return 2;
        }
        return -1;
    }


    public Object invoke(int index,Object obj,Object[] objs){
        FastClass f = (FastClass) obj;
        switch (index){

        }
        return null;
    }
}
