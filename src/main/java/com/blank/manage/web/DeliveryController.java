package com.blank.manage.web;

import com.blank.manage.domain.Delivery;
import com.blank.manage.service.AuthService;
import com.blank.manage.service.DeliveryService;
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
@RequestMapping(value = "deliveries")
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    @Autowired
    private AuthService authService;

    @Value("${blank.data.pageSize}")
    private int pageSize;


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getDeliveryList(
            HttpServletRequest request,
            Delivery delivery,
            @RequestParam(value = "page", required = false, defaultValue = "1") int pageNum) {
        Map<String, Object> resp = new HashMap<String, Object>();
        try {
            Long userId = authService.getUserIdByAuthHeader(request);
            delivery.setUserId(userId);
            PageResult<Delivery> page =  deliveryService.getDeliveryList(pageNum, pageSize, delivery);
            resp.put("data", page);
            return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.OK);
        } catch (Exception e) {
            resp.put("message", e);
        }
        return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> insertDelivery(
            HttpServletRequest request, Delivery delivery) {
        Map<String, Object> resp = new HashMap<String, Object>();
        try {
            Long userId = authService.getUserIdByAuthHeader(request);
            delivery.setUserId(userId);
            deliveryService.insertDelivery(delivery);
            resp.put("message","新增成功");
            return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.CREATED);
        } catch (Exception e) {
            resp.put("message","新增失败");
        }
        return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> updateDelivery(HttpServletRequest request, Delivery delivery) {
        Map<String, Object> resp = new HashMap<String, Object>();
        try {
            Long userId = authService.getUserIdByAuthHeader(request);
            delivery.setUserId(userId);
            deliveryService.updateDelivery(delivery);
            resp.put("message","更新成功");
            return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            resp.put("message","更新失败");
        }
        return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteDelivery(@RequestParam(value = "id") String id) {
        Map<String, Object> resp = new HashMap<String, Object>();
        try {
            deliveryService.deleteByIds(id);
            resp.put("message","删除成功");
            return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            resp.put("message","删除失败");
        }
        return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
