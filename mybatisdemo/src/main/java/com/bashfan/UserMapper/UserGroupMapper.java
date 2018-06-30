package com.bashfan.UserMapper;

import com.bashfan.domain.Group;
import com.bashfan.domain.User;
import com.bashfan.domain.UserGroup;

import java.util.List;

public interface UserGroupMapper {
    List<User> getUsersByGroupId(int id);

    List<Group> getGroupsByUserId(int id);

    void insertUserGroup(UserGroup userGroup);
}
