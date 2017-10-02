package com.blank.manage.service;

import com.blank.manage.domain.Delivery;
import com.blank.manage.model.PageResult;

public interface DeliveryService {

    PageResult<Delivery> getDeliveryList(int pageNum, int pageSize, Delivery delivery);

    void insertDelivery(Delivery delivery);

    void updateDelivery(Delivery delivery);

    void deleteByIds(String ids);
}
