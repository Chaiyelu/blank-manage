package com.blank.manage.service;

import com.blank.manage.domain.User;

import javax.servlet.http.HttpServletRequest;

public interface AuthService {
    User register(User user);
    String login(String mobile, String password);
    String refresh(String oldToken);
    User getUserByAuthHeader(HttpServletRequest request);
    Long getUserIdByAuthHeader(HttpServletRequest request);
}
