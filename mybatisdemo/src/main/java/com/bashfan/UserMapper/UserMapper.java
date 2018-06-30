package com.bashfan.UserMapper;

import com.bashfan.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {
//    @Select("select * from mybatis.users where id=#{id}")
    User getUser(int id);

//    @Select("select * from mybatis.users")
    List<User> getUsers();

//    @Insert("insert into mybatis.users (name,department,phone,website) values (#{name},#{department},#{phone},#{website})")
    void insertUser(User user);

//    @Update("update mybatis.users set name=#{name},department=#{department},phone=#{phone},website=#{website} where id=#{id}")
    void updateUser(User user);

//    @Delete("delete from mybatis.users where id=#{id}")
    void deleteUser(int id);
}
