package com.blank.manage.service.impl;

import com.blank.manage.domain.JwtUser;
import com.blank.manage.domain.User;
import com.blank.manage.mapper.UserMapper;
import com.blank.manage.service.AuthService;
import com.blank.manage.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Service
public class AuthServiceImpl implements AuthService {

    private AuthenticationManager authenticationManager;
    private UserDetailsService userDetailsService;
    private JwtTokenUtil jwtTokenUtil;
    private UserMapper userMapper;

    @Value("${jwt.header}")
    private String tokenHeader;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    public AuthServiceImpl(
            AuthenticationManager authenticationManager,
            UserDetailsService userDetailsService,
            JwtTokenUtil jwtTokenUtil,
            UserMapper userMapper) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userMapper = userMapper;
    }

    public User register(User user) {
        if (userMapper.findByMobile(user.getMobile())!=null){
            return null;
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        final String rawPassword = user.getPassword();
        user.setPassword(encoder.encode(rawPassword));
        user.setLastPasswordResetDate(new Date());
        user.setUpdatetime(new Date());
        user.setStatus(new Long(1));
        return userMapper.insertSingle(user);
    }

    public String login(String mobile, String password) {
        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(mobile, password);
        final Authentication authentication = authenticationManager.authenticate(upToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        final UserDetails userDetails = userDetailsService.loadUserByUsername(mobile);
        final String token = jwtTokenUtil.generateToken(userDetails);
        return token;
    }

    public String refresh(String oldToken) {
        final String token = oldToken.substring(tokenHead.length());
        String mobile = jwtTokenUtil.getUsernameFromToken(token);
        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(mobile);
        if (jwtTokenUtil.canTokenBeRefreshed(token, user.getLastPasswordResetDate())){
            return jwtTokenUtil.refreshToken(token);
        }
        return null;
    }

    public User getUserByAuthHeader(HttpServletRequest request) {
        String authHeader = request.getHeader(tokenHeader);
        final String authToken = authHeader.substring(tokenHead.length());
        String mobile = jwtTokenUtil.getUsernameFromToken(authToken);
        return userMapper.findByMobile(mobile);
    }

    public Long getUserIdByAuthHeader(HttpServletRequest request) {
        String authHeader = request.getHeader(tokenHeader);
        if (authHeader == null) {
            return null;
        }
        final String authToken = authHeader.substring(tokenHead.length());
        String mobile = jwtTokenUtil.getUsernameFromToken(authToken);
        if (mobile == null) {
            return null;
        }
        return userMapper.findByMobile(mobile).getId();
    }
}
