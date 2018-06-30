package com.bashfan.main;

import com.bashfan.UserMapper.UserMapper;
import com.bashfan.domain.Number;
import com.bashfan.domain.User;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DataSource dataSource = new MyDataSourece().getDataSource();
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("devl",transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.addMapper(NumberMapper.class);
        configuration.addMapper(UserMapper.class);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        NumberMapper numberMapper = sqlSession.getMapper(NumberMapper.class);
        Number number = numberMapper.selectNumber(1);
        System.out.println(number.toString());

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUser(1);
        System.out.println(user.getName());
        //create
        User user1 = new User("LeLe", "School", "6986789300", "qzone");
        userMapper.insertUser(user1);
//        sqlSession.commit(); //这里只能commit一次


        //update
        User user3 = userMapper.getUser(7);
        user3.setName("LeLeMa");
        userMapper.updateUser(user3);

        //delete
        userMapper.deleteUser(11);

        sqlSession.commit();

        //read
        List<User> users = userMapper.getUsers();
        for (User entry : users) {
            System.out.println(entry);
        }

        sqlSession.close();
    }
}
