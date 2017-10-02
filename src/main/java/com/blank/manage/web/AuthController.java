package com.blank.manage.web;

import com.blank.manage.domain.JwtUser;
import com.blank.manage.domain.User;
import com.blank.manage.factory.JwtUserFactory;
import com.blank.manage.service.AuthService;
import com.blank.manage.service.CheckcodeService;
import com.blank.manage.service.RedisService;
import com.blank.manage.service.UserService;
import com.blank.manage.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private CheckcodeService checkcodeService;

    @Autowired
    private RedisService redisService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserService userService;
    /**
     * 登录验证
     * @param mobile
     * @param password
     * @param code
     * @return
     */
    @RequestMapping(value = "${jwt.route.authentication.path}", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> login(@RequestParam(value = "mobile") String mobile,
                                @RequestParam(value = "password", required = false) String password,
                                @RequestParam(value = "code", required = false) String code) throws AuthenticationException {
        Map<String, Object> resp = new HashMap<String, Object>();
        if (password==null&&code==null) {
            resp.put("success", false);
            return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.BAD_REQUEST);
        }
        User user = userService.findByMobile(mobile);
        if (password!=null) {
            String token = authService.login(mobile, password);

            resp.put("success", true);
            resp.put("message", "验证成功");
            resp.put("token", token);
            resp.put("user", user);

        } else {
            String checkCode = redisService.get("checkcode"+mobile);
            if (code.equals(checkCode)) {
                if (user == null) {
                    User addUser = new User();
                    addUser.setMobile(mobile);
                    addUser.setAvatar("https://avatars2.githubusercontent.com/u/11835988?v=3&u=2a181779eb2164666606366a1df31f9c17cf7a20&s=100");
                    addUser.setUsername("mt-" + mobile);
                    addUser.setLastPasswordResetDate(new Date());
                    addUser = authService.register(addUser);
                    JwtUser jwtUser = JwtUserFactory.create(addUser);
                    String token = jwtTokenUtil.generateToken(jwtUser);
                    resp.put("success", true);
                    resp.put("message", "验证成功");
                    resp.put("token", token);
                    resp.put("user", addUser);
                } else {
                    JwtUser jwtUser = JwtUserFactory.create(user);
                    String token = jwtTokenUtil.generateToken(jwtUser);
                    resp.put("success", true);
                    resp.put("message", "验证成功");
                    resp.put("token", token);
                    resp.put("user", user);
                }
            } else {
                resp.put("success", false);
                resp.put("message", "验证码出错");
                return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.OK);
    }

    /**
     * 注册
     * @param mobile
     * @param code
     * @return
     * @throws AuthenticationException
     */
    @RequestMapping(value = "${jwt.route.authentication.register}", method = RequestMethod.POST)
    public ResponseEntity<?> register(@RequestParam(value = "mobile") String mobile,
                              @RequestParam(value = "code", required = false) String code) throws AuthenticationException{
        Map<String, Object> resp = new HashMap<String, Object>();
        try {
            if (checkcodeService.isChecked(mobile, code)) {
                User addUser = new User();
                addUser.setMobile(mobile);
                addUser.setAvatar("https://avatars2.githubusercontent.com/u/11835988?v=3&u=2a181779eb2164666606366a1df31f9c17cf7a20&s=100");
                addUser.setUsername("mt-" + mobile);
                addUser.setLastPasswordResetDate(new Date());
                addUser = authService.register(addUser);
                JwtUser jwtUser = JwtUserFactory.create(addUser);
                String token = jwtTokenUtil.generateToken(jwtUser);
                resp.put("success", true);
                resp.put("message", "注册成功");
                resp.put("token", token);
                resp.put("user", addUser);
                return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.OK);
            } else {
                resp.put("success", false);
                resp.put("message", "验证码错误");
                return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            resp.put("success", false);
            resp.put("message", "服务器错误");
        }
        return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(value = "auth/checkmobileisreg")
    public ResponseEntity<?> checkMobileIsRegistered(@RequestParam(value = "mobile") String mobile) {
        Map<String, Object> resp = new HashMap<String, Object>();
        try {
            User user = userService.findByMobile(mobile);
            if (user == null) {
                return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.OK);
            } else {
                return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            resp.put("success", false);
            resp.put("message", "服务器错误");
        }
        return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
