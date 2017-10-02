package com.blank.manage.service;

import com.blank.manage.domain.User;

import java.util.List;

public interface UserService {
    List<User> getUserList();

    User findByMobile(String mobile);

    User getById(Long userId);

    void update(User user);
}
