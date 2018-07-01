package com.bashfan.service;

import com.bashfan.domain.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountServiceImpl implements AccountService {

    public void insertAccount(Account acc) {
        System.out.println("inserting Account");
    }

    public List<Account> getAccounts(String name) {
        List<Account> list = new ArrayList<Account>();
        list.add(new Account("test"));
        list.add(new Account("yoyoyo"));
        return list;
    }

}