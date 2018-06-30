package com.bashfan.UserMapper;

import com.bashfan.domain.Post;
import com.bashfan.domain.User;

import java.util.List;

public interface PostMapper {
    Post getPost(long id);

    User getUser(long id);

    List<Post> getPosts();
}
