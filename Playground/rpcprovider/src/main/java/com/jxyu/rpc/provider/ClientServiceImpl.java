package com.jxyu.rpc.provider;

import com.jxyu.rpc.api.Client;
import com.jxyu.rpc.api.IClientService;

import java.util.Random;

public class ClientServiceImpl implements IClientService {

    @Override
    public Client addClient(Client client) {
        System.out.println("received: " + client);
        client.setUserID(String.valueOf(new Random().nextInt()));
        System.out.println("sending: " + client);
        return client;
    }
}
