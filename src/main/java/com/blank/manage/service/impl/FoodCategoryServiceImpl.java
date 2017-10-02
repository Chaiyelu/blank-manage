package com.blank.manage.service.impl;

import com.blank.manage.domain.FoodCategory;
import com.blank.manage.mapper.FoodCategoryMapper;
import com.blank.manage.service.FoodCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class FoodCategoryServiceImpl implements FoodCategoryService{
    @Autowired
    private FoodCategoryMapper foodCategoryMapper;

    public List<FoodCategory> getFoodCategoryAndFoodListBySellerId(@RequestParam("sellerId") Long sellerId) {
        return foodCategoryMapper.getFoodCategoryAndFoodListBySellerId(sellerId);
    }
}
