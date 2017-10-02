package com.blank.manage.service.impl;

import com.blank.manage.domain.User;
import com.blank.manage.mapper.UserMapper;
import com.blank.manage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    public UserMapper userMapper;

    public List<User> getUserList() {
        return userMapper.getUserList();
    }

    public User findByMobile(String mobile) {
        return userMapper.findByMobile(mobile);
    }

    @Override
    public User getById(Long userId) {
        return userMapper.findById(userId);
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }
}
