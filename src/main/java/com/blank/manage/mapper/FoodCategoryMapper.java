package com.blank.manage.mapper;

import com.blank.manage.domain.FoodCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FoodCategoryMapper {

    List<FoodCategory> getFoodCategoryAndFoodListBySellerId(@Param("sellerId") Long sellerId);
}
