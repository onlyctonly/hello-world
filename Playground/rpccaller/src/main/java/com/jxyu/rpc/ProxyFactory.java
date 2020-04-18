package com.jxyu.rpc;

import com.jxyu.rpc.api.IClientService;

import java.lang.reflect.Proxy;

public class ProxyFactory {
    public static <T> T getService(Class<T> interfaceClass) {
        return (T) Proxy.newProxyInstance(ProxyFactory.class.getClassLoader(), new Class[]{IClientService.class},new RpcInvocationHandler());
    }
}
