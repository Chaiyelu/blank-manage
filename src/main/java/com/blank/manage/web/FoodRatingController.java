package com.blank.manage.web;

import com.blank.manage.domain.FoodRating;
import com.blank.manage.model.CategoryCountResult;
import com.blank.manage.service.FoodRatingService;
import com.blank.manage.model.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/food_ratings")
public class FoodRatingController {

    @Autowired
    private FoodRatingService foodRatingService;

    @Value("${blank.data.pageSize}")
    private int pageSize;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getFoodRatingPage(
            FoodRating foodRating,
            @RequestParam(value = "page", required = false, defaultValue = "1") int pageNum) {
        Map<String, Object> resp = new HashMap<String, Object>();
        try {
            if (foodRating.getFoodId() == null && foodRating.getSellerId() == null && foodRating.getUserId() == null) {
                resp.put("message", "参数错误");
                return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.BAD_REQUEST);
            }
            PageResult<FoodRating> pege = foodRatingService.findPage(pageNum, pageSize, foodRating);
            resp.put("data", pege);
            return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.OK);
        } catch (Exception e) {
            resp.put("message", e);
        }
        return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(value = "/count",method = RequestMethod.GET)
    public List<CategoryCountResult> getCountForRateTypeBySellerId(@RequestParam(value = "sellerId") Long sellerId) {
        return foodRatingService.findCountForRateTypeBySellerId(sellerId);
    }
}
