package com.blank.manage.web;

import com.blank.manage.domain.MerchantCollection;
import com.blank.manage.service.AuthService;
import com.blank.manage.service.MerchantCollectionService;
import com.blank.manage.model.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "merchant_collections")
public class MerchantCollectionController {

    @Autowired
    private AuthService authService;

    @Value("${blank.data.pageSize}")
    private int pageSize;

    @Autowired
    private MerchantCollectionService merchantCollectionService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getMerchantCollectionList(
            HttpServletRequest request,
            @RequestParam(value = "page", required = false, defaultValue = "1") int pageNum) {
        Map<String, Object> resp = new HashMap<String, Object>();
        try {
            Long userId = authService.getUserIdByAuthHeader(request);
            PageResult<MerchantCollection> page =  merchantCollectionService.findPage(pageNum, pageSize, userId);
            resp.put("data", page);
            return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.OK);
        } catch (Exception e) {
            resp.put("message", e);
        }
        return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> insertMerchantCollection(
            HttpServletRequest request,
            MerchantCollection merchantCollection) {
        Map<String, Object> resp = new HashMap<String, Object>();
        try {
            Long userId = authService.getUserIdByAuthHeader(request);
            merchantCollection.setUserId(userId);
            Long mcId = merchantCollectionService.findIdByParams(merchantCollection);
            if (mcId == null) {
                merchantCollectionService.insert(merchantCollection);
                mcId = merchantCollection.getId();
            }
            resp.put("message","收藏成功");
            resp.put("data",mcId);
            return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.CREATED);
        } catch (Exception e) {
            resp.put("message","收藏失败");
        }
        return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteMerchantCollection(
            @RequestParam(value = "id") String id) {
        Map<String, Object> resp = new HashMap<String, Object>();
        try {
            merchantCollectionService.deleteByIds(id);
            resp.put("message","取消收藏成功");
            return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            resp.put("message","取消收藏失败");
        }
        return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
