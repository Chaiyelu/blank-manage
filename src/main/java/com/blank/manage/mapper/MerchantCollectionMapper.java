/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2017
 */

package com.blank.manage.mapper;

import java.util.*;


/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.blank.manage.domain.MerchantCollection;

/**
 *
 * @author chaiyelu 2017-09-09 14:12:35
 * @version 1.0
 * @since 1.0
 * */
@Mapper
public interface MerchantCollectionMapper {

    /**
     * 创建UserCollection
     **/
    Long insert(MerchantCollection merchantCollection);

    /**
     * 删除UserCollection
     **/
    public int deleteById(@Param("id") Integer id);

    /**
     * 根据ID得到UserCollection
     **/
    public MerchantCollection getById(@Param("id") Integer id);

    /**
     * 查询全部
     */
    public List<MerchantCollection>  findAll();


    Long findIdByParams(MerchantCollection queryParams);

    List<MerchantCollection> findPage(@Param("userId") Long userId);

    void deleteByIds(@Param("ids") String[] ids);
}
