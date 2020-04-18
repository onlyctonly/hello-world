package com.jxyu.rpc;


import com.jxyu.rpc.provider.BIOSocketServer;

public class App
{
    public static void main( String[] args )
    {

        BIOSocketServer.startServer(7777);
    }
}
