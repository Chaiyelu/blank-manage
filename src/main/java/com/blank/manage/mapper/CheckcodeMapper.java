package com.blank.manage.mapper;

import com.blank.manage.domain.Checkcode;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

@Mapper
public interface CheckcodeMapper {

    void insertSingle(Checkcode checkcode);

    int findCountIn90Second(@Param("mobile") String mobile, @Param("date") Date date);

    int findCountIn1DayByMobile(@Param("mobile") String mobile, @Param("date") Date date);

    int findCountIn1DayByIp(@Param("ip") String ip, @Param("date") Date date);
}
