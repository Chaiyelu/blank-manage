package com.blank.manage.service.impl;

import com.blank.manage.domain.FoodRating;
import com.blank.manage.mapper.FoodRatingMapper;
import com.blank.manage.model.CategoryCountResult;
import com.blank.manage.service.FoodRatingService;
import com.blank.manage.utils.BeanUtil;
import com.blank.manage.model.PageResult;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodRatingServiceImpl implements FoodRatingService {

    @Autowired
    private FoodRatingMapper foodRatingMapper;

    @Override
    public PageResult<FoodRating> findPage(int pageNum, int pageSize, FoodRating foodRating) {
        PageHelper.startPage(pageNum, pageSize);
        List<FoodRating> list = foodRatingMapper.findPage(foodRating);
        return BeanUtil.toPageResult(list);
    }

    @Override
    public List<CategoryCountResult> findCountForRateTypeBySellerId(Long sellerId) {
        return foodRatingMapper.findCountForRateTypeBySellerId(sellerId);
    }
}
