package com.blank.manage.service.impl;

import com.blank.manage.domain.User;
import com.blank.manage.factory.JwtUserFactory;
import com.blank.manage.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String mobile) throws UsernameNotFoundException {
        User user = userMapper.findByMobile(mobile);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("no user find by mobile"));
        } else {
            return JwtUserFactory.create(user);
        }
    }
}
