package com.jxyu.rpc;

import com.jxyu.rpc.api.Client;
import com.jxyu.rpc.api.IClientService;

public class App 
{
    public static void main( String[] args )
    {
        IClientService iClientService = ProxyFactory.getService(IClientService.class);
        Client c = new Client();
        c.setName("Jia");
        c.setName("Zhou");
        Client rc = iClientService.addClient(c);
        System.out.println(rc);
    }
}
