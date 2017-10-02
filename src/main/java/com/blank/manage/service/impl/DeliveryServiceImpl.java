package com.blank.manage.service.impl;

import com.blank.manage.domain.Delivery;
import com.blank.manage.mapper.DeliveryMapper;
import com.blank.manage.service.DeliveryService;
import com.blank.manage.utils.BeanUtil;
import com.blank.manage.model.PageResult;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DeliveryServiceImpl implements DeliveryService {

    @Autowired
    private DeliveryMapper deliveryMapper;

    public PageResult<Delivery> getDeliveryList(int pageNum, int pageSize, Delivery delivery) {
        PageHelper.startPage(pageNum, pageSize);
        List<Delivery> list = deliveryMapper.getDeliveryList(delivery);
        return BeanUtil.toPageResult(list);
    }

    @Override
    public void insertDelivery(Delivery delivery) {
        Date date = new Date();
        Long selected = delivery.getSelected();
        if (selected!=null && selected == 1L) {
            deliveryMapper.toggleSelectedByUserId(delivery.getUserId(), date, 0L);
        }
        delivery.setCreatetime(date);
        delivery.setUpdatetime(date);
        deliveryMapper.insertSingle(delivery);
    }

    @Override
    public void updateDelivery(Delivery delivery) {
        Date date = new Date();
        Long selected = delivery.getSelected();
        if (selected!=null && selected == 1L) {
            deliveryMapper.toggleSelectedByUserId(delivery.getUserId(), date, 0L);
        }
        delivery.setUpdatetime(date);
        deliveryMapper.update(delivery);
    }

    @Override
    public void deleteByIds(String id) {
        String[] ids = id.split(",");
        deliveryMapper.deleteByIds(ids);
    }
}
