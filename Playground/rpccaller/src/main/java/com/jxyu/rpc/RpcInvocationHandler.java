package com.jxyu.rpc;

import com.jxyu.rpc.api.RPCTransferObj;
import com.jxyu.rpc.api.ServiceMapped;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class RpcInvocationHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName());
        System.out.println(args.length);
        for (int i = 0; i <args.length ; i++) {
            System.out.println(args[i]);
        }

        RPCTransferObj request = new RPCTransferObj();
        String className=method.getDeclaringClass().getAnnotation(ServiceMapped.class).value();
        request.setFullClassName(className);
        request.setArgs(args);
        request.setMethodName("addClient");



        return BioClient.callRemote(request,"127.0.0.1",7777);
    }
}
