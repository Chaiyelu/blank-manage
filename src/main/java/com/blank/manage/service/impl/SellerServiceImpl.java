package com.blank.manage.service.impl;

import com.blank.manage.domain.Seller;
import com.blank.manage.mapper.SellerMapper;
import com.blank.manage.service.SellerService;
import com.blank.manage.utils.BeanUtil;
import com.blank.manage.model.PageResult;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerServiceImpl implements SellerService{
    @Autowired
    private SellerMapper sellerMapper;

    @Override
    public PageResult<Seller> getSellerList(int pageNum, int pageSize, Seller seller) {
        PageHelper.startPage(pageNum, pageSize);
        List<Seller> list = sellerMapper.getSellerList(seller);
        return BeanUtil.toPageResult(list);
    }

    @Override
    public Seller getById(Long id) {
        return this.sellerMapper.getById(id);
    }
}
