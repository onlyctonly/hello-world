package com.jxyu.rpc.provider;

import com.jxyu.rpc.api.RPCTransferObj;

import java.lang.reflect.Method;

public class ServiceDispather {
    public static Object dispatch(Object requestObj){
        RPCTransferObj rpcTransferObj = (RPCTransferObj) requestObj;
        String fullClassName = rpcTransferObj.getFullClassName();
        String methodName = rpcTransferObj.getMethodName();
        Object[] args = rpcTransferObj.getArgs();
        Class[] types = new Class[args.length];
        for (int i = 0; i < args.length; i++) {
            types[i]=args[i].getClass();
        }
` `
        Object responseObj = null;
        try {
            Class thisClass = Class.forName(fullClassName);
            Method method=thisClass.getDeclaredMethod(methodName, types);
            responseObj=method.invoke(thisClass.getDeclaredConstructor().newInstance(),args);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseObj;
    }
}
