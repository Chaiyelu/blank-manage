/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2017
 */

package com.blank.manage.service.impl;

import com.blank.manage.utils.BeanUtil;
import com.blank.manage.model.PageResult;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import com.blank.manage.mapper.MerchantCollectionMapper;
import com.blank.manage.domain.MerchantCollection;
import com.blank.manage.service.MerchantCollectionService;

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
@Service
public class MerchantCollectionServiceImpl implements MerchantCollectionService {

    @Resource
    private MerchantCollectionMapper merchantCollectionMapper;

    /**
     * 创建UserCollection
     **/
    public Long insert(MerchantCollection merchantCollection) {
        merchantCollection.setCreateTime(new Date());
        return merchantCollectionMapper.insert(merchantCollection);
    }

    /**
     * 删除UserCollection
     **/
    public int deleteById(Integer id) {
        return this.merchantCollectionMapper.deleteById(id);
    }

    /**
     * 根据ID得到UserCollection
     **/
    public MerchantCollection getById(Integer id) {
        return this.merchantCollectionMapper.getById(id);
    }

    /**
     * 查询全部
     */
    public List<MerchantCollection>  findAll(){
        return (List<MerchantCollection>) merchantCollectionMapper.findAll();
    }

    @Override
    public Long findIdByParams(MerchantCollection queryParams) {
        return merchantCollectionMapper.findIdByParams(queryParams);
    }

    @Override
    public PageResult<MerchantCollection> findPage(int pageNum, int pageSize, Long userId) {
        PageHelper.startPage(pageNum, pageSize);
        List<MerchantCollection> list = merchantCollectionMapper.findPage(userId);
        return BeanUtil.toPageResult(list);
    }

    @Override
    public void deleteByIds(String id) {
        String[] ids = id.split(",");
        merchantCollectionMapper.deleteByIds(ids);
    }

}
