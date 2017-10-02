package com.blank.manage.service;

import com.blank.manage.domain.FoodRating;
import com.blank.manage.model.CategoryCountResult;
import com.blank.manage.model.PageResult;

import java.util.List;

public interface FoodRatingService {
    PageResult<FoodRating> findPage(int pageNum, int pageSize, FoodRating foodRating);

    List<CategoryCountResult> findCountForRateTypeBySellerId(Long sellerId);
}
