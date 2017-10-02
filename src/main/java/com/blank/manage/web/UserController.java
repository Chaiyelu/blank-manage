package com.blank.manage.web;

import com.blank.manage.domain.User;
import com.blank.manage.service.AuthService;
import com.blank.manage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public List<User> getUserList() {
        List<User> r = userService.getUserList();
        return r;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUserById(HttpServletRequest request, @PathVariable(name = "id") Long id) {
        Long userId = authService.getUserIdByAuthHeader(request);
        return userService.getById(userId);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateUserById(HttpServletRequest request, User user) {
        Map<String, Object> resp = new HashMap<String, Object>();
        try {
            Long userId = authService.getUserIdByAuthHeader(request);
            user.setId(userId);
            userService.update(user);
            resp.put("message","更新成功");
            return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            resp.put("message","更新失败");
        }
        return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
