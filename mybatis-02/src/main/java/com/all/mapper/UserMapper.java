package com.all.mapper;

import com.all.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> getUserList();

    List<User> getUserLike(String value);

    User getUserById(int id);

    int addUser(User user);

    int addUser2(Map<String, Object> map);

    User getUserById2(Map<String, Object> map);



}
