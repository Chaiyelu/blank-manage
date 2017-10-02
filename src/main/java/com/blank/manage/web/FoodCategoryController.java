package com.blank.manage.web;

import com.blank.manage.domain.FoodCategory;
import com.blank.manage.service.impl.FoodCategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class FoodCategoryController {
    @Autowired
    private FoodCategoryServiceImpl foodCategoryService;

    @RequestMapping(method = RequestMethod.GET)
    public List<FoodCategory> getFoodCategoryList(Long sellerId) {
        return foodCategoryService.getFoodCategoryAndFoodListBySellerId(sellerId);
    }
}
