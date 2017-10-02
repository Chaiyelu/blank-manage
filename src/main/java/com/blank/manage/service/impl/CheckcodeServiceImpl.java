package com.blank.manage.service.impl;

import com.blank.manage.domain.Checkcode;
import com.blank.manage.mapper.CheckcodeMapper;
import com.blank.manage.service.CheckcodeService;
import com.blank.manage.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CheckcodeServiceImpl implements CheckcodeService {
    @Autowired
    private CheckcodeMapper checkcodeMapper;

    @Autowired
    private RedisService redisService;

    @Override
    public void insertCheckcode(String mobile, Date date, String ip) {
        Checkcode checkcode = new Checkcode();
        String code = String.valueOf((Math.random()*9+1)*100000);
        checkcode.setMobile(mobile);
        checkcode.setCreatetime(date);
        checkcode.setExpireAt(new Date(date.getTime() + 300000));
        checkcode.setCode(code);
        checkcode.setIp(ip);
        checkcodeMapper.insertSingle(checkcode);

        redisService.set("checkcode"+mobile, code);
        redisService.expire("checkcode"+mobile, 300);
    }

    @Override
    public int findCountIn90Second(String mobile, Date date) {
        int i = checkcodeMapper.findCountIn90Second(mobile, date);
        return i;
    }

    @Override
    public int findCountIn1DayByMobile(String mobile, Date date) {
        int i = checkcodeMapper.findCountIn1DayByMobile(mobile, date);
        return i;
    }

    @Override
    public int findCountIn1DayByIp(String ip, Date date) {
        int i = checkcodeMapper.findCountIn1DayByIp(ip, date);
        return i;
    }

    @Override
    public boolean isChecked(String mobile, String code) {
        String currentCode = redisService.get("checkcode"+mobile);
        if (currentCode.equals(code)) {
            return true;
        }
        return false;
    }
}
