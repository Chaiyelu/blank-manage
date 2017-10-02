package com.blank.manage.mapper;

import com.blank.manage.domain.Delivery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface DeliveryMapper {
    List<Delivery> getDeliveryList(Delivery delivery);

    void toggleSelectedByUserId(@Param("userId") Long userId, @Param("updatetime") Date updatetime, @Param("selected") Long selected);

    void insertSingle(Delivery delivery);

    void update(Delivery delivery);

    void deleteByIds(@Param("ids") String[] ids);
}
