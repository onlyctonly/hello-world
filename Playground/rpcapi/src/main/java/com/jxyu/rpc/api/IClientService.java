package com.jxyu.rpc.api;

@ServiceMapped("com.jxyu.rpc.provider.ClientServiceImpl")
public interface IClientService {
    Client addClient(Client c);
}
