package com.bashfan.UserMapper;

import com.bashfan.domain.Group;

public interface GroupMapper {
    void insertGroup(Group group);
    Group getGroup(int id);
}
