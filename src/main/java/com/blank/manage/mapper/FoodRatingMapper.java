package com.blank.manage.mapper;

import com.blank.manage.domain.FoodRating;
import com.blank.manage.model.CategoryCountResult;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FoodRatingMapper {
    List<FoodRating> findPage(FoodRating foodRating);

    List<CategoryCountResult> findCountForRateTypeBySellerId(Long sellerId);
}
