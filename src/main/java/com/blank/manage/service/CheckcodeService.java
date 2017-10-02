package com.blank.manage.service;

import java.util.Date;

public interface CheckcodeService {
    void insertCheckcode(String mobile, Date date, String ip);

    int findCountIn90Second(String mobile, Date date);

    int findCountIn1DayByMobile(String mobile, Date date);

    int findCountIn1DayByIp(String ip, Date date);

    boolean isChecked(String mobile, String code);
}
