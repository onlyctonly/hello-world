package com.bashfan.main;

import com.bashfan.UserMapper.GroupMapper;
import com.bashfan.UserMapper.PostMapper;
import com.bashfan.UserMapper.UserGroupMapper;
import com.bashfan.domain.Group;
import com.bashfan.domain.Post;
import com.bashfan.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MainXml {
    public static void main(String[] args) {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

//        User user = sqlSession.selectOne("com.bashfan.domain.UserMapper.GetUserByID", 1);
//        System.out.println(user);

//        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//        User user=userMapper.getUser(1);
//        System.out.println(user);
//
//
//
//        User user2 = new User("Xinhe","Home","888888","n/a");
//        userMapper.insertUser(user2);
//
//        User user3 = userMapper.getUser(12);
//        if (user3 != null) {
//            user3.setName("mama");
//            userMapper.updateUser(user3);
//        }
//
//        userMapper.deleteUser(10);
//
//
//        List<User> users = userMapper.getUsers();
//
//        for (User entry : users) {
//            System.out.println(entry);
//        }
//        PostMapper postMapper = sqlSession.getMapper(PostMapper.class);
//        List<Post> posts=postMapper.getPosts();
//        for (Post post : posts) {
//            System.out.println(post);
//        }
//        User user = postMapper.getUser(1);
//        System.out.println(user);

        UserGroupMapper userGroupMapper =  sqlSession.getMapper(UserGroupMapper.class);
//        List<User> users = userGroupMapper.getUsersByGroupId(1);
//        for (User u : users) {
//            System.out.println(u);
//        }

        List<Group> groups=userGroupMapper.getGroupsByUserId(1);
        for (Group g : groups) {
            System.out.println(g);
        }

        sqlSession.commit();
        sqlSession.close();
    }
}
