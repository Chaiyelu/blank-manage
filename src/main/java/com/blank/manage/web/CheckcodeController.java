package com.blank.manage.web;

import com.blank.manage.domain.Checkcode;
import com.blank.manage.service.CheckcodeService;
import com.blank.manage.utils.NetworkUtil;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/checkcode")
public class CheckcodeController {

    @Autowired
    private CheckcodeService checkcodeService;

    /**
     * 发送验证码
     * @param request
     * @param mobile
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> getCheckcode(HttpServletRequest request, @RequestParam(value = "mobile") String mobile) {
        Map<String, Object> resp = new HashMap<String, Object>();
        try {
            Date date = new Date();
            String ip = NetworkUtil.getIpAddress(request);
            //90秒之内不再重发验证码
            int in90Sec = checkcodeService.findCountIn90Second(mobile, date);
            if (in90Sec > 0) {
                resp.put("message", "操作过于频繁，请于90秒后重试");
                return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.TOO_MANY_REQUESTS);
            }

            //判断手机号是否超过每日限制次数
            int in1DayMobile = checkcodeService.findCountIn1DayByMobile(mobile, date);
            if (in1DayMobile > 3) {
                resp.put("message", "该手机号码发送短信超过每日限制次数");
                return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.TOO_MANY_REQUESTS);
            }

            //判断IP地址是否超过每日限制次数
            int in1DayIp = checkcodeService.findCountIn1DayByIp(ip, date);
            if (in1DayIp > 3) {
                resp.put("message", "该IP地址发送短信超过每日限制次数");
                return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.TOO_MANY_REQUESTS);
            }
            checkcodeService.insertCheckcode(mobile, date, ip);
            resp.put("message", "发送成功");
            return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.CREATED);
        } catch (Exception e) {
            resp.put("message", e);
        }
        return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * 验证验证码
     * @param mobile
     * @param code
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> checkCheckcode(@RequestParam(value = "mobile") String mobile, @RequestParam(value = "code") String code) {
        Map<String, Object> resp = new HashMap<String, Object>();
        try {
            if (checkcodeService.isChecked(mobile, code)) {
                resp.put("message", "验证成功");
                return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.OK);
            } else {
                resp.put("message", "验证失败");
                return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            resp.put("message", "服务器故障，请耐心等待");
        }
        return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
