package com.blank.manage.mapper;

import com.blank.manage.domain.Seller;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SellerMapper {
    List<Seller> getSellerList(Seller seller);

    Seller getById(@Param("id") Long id);
}
