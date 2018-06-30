package com.bashfan.main;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.transaction.Transaction;

import javax.sql.DataSource;

public class Config extends Configuration {
    private Transaction transaction;
    private DataSource dataSource;

}
