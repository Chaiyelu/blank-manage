package com.blank.manage.web;

import com.blank.manage.domain.Seller;
import com.blank.manage.domain.MerchantCollection;
import com.blank.manage.service.AuthService;
import com.blank.manage.service.SellerService;
import com.blank.manage.service.MerchantCollectionService;
import com.blank.manage.model.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "seller")
public class SellerController {
    @Autowired
    private AuthService authService;

    @Autowired
    private SellerService sellerService;

    @Autowired
    private MerchantCollectionService merchantCollectionService;

    @Value("${blank.data.pageSize}")
    private int pageSize;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getDeliveryList(
            Seller seller,
            @RequestParam(value = "page", required = false, defaultValue = "1") int pageNum) {
        Map<String, Object> resp = new HashMap<String, Object>();
        try {
            PageResult<Seller> page =  sellerService.getSellerList(pageNum, pageSize, seller);
            resp.put("data", page);
            return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.OK);
        } catch (Exception e) {
            resp.put("message", e);
        }
        return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Seller getSellerById(HttpServletRequest request, @PathVariable(name = "id") Long id) {
        Long userId = authService.getUserIdByAuthHeader(request);
        Seller seller = sellerService.getById(id);
        if (userId != null) {
            //如果用户id不为空，则查询该用户是否已收藏该商户
            MerchantCollection queryParams = new MerchantCollection();
            queryParams.setUserId(userId);
            queryParams.setMerchantType("seller");
            queryParams.setMerchantId(id);
            Long ucId = merchantCollectionService.findIdByParams(queryParams);
            if (ucId != null) {
                seller.setCollectionId(ucId);
                return seller;
            }
        }
        seller.setCollectionId(0L);
        return seller;
    }
}
