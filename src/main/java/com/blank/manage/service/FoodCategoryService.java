package com.blank.manage.service;

import com.blank.manage.domain.FoodCategory;

import java.util.List;

public interface FoodCategoryService {
    List<FoodCategory> getFoodCategoryAndFoodListBySellerId(Long sellerId);
}
