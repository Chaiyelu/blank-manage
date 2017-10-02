/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2017
 */

package com.blank.manage.service;

import com.blank.manage.domain.MerchantCollection;
import com.blank.manage.model.PageResult;

import java.util.*;

/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */


/**
 *
 * @author chaiyelu 2017-09-09 14:12:35
 * @version 1.0
 * @since 1.0
 * */
public interface MerchantCollectionService {

    /** 
     * 创建UserCollection
     **/
    Long insert(MerchantCollection merchantCollection);
    
    /** 
     * 删除UserCollection
     **/
    public int deleteById(Integer id);
    
    /** 
     * 根据ID得到UserCollection
     **/    
    public MerchantCollection getById(Integer id);

    /**
     * 查询全部
     */
    public List<MerchantCollection>  findAll();


    Long findIdByParams(MerchantCollection queryParams);

    PageResult<MerchantCollection> findPage(int pageNum, int pageSize, Long userId);

    void deleteByIds(String id);
}
