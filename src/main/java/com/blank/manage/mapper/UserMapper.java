package com.blank.manage.mapper;

import com.blank.manage.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM USER WHERE NAME = #{username}")
    User findByUserame(@Param("username") String username);

    //@Select("SELECT * FROM user WHERE mobile = #{mobile}")
    User findByMobile(@Param("mobile") String mobile);

    @Select("SELECT * FROM USER")
    List<User> getUserList();

    User insertSingle(User user);

    User findById(@Param("userId") Long userId);

    void update(User user);
}
