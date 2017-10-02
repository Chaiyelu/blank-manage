package com.blank.manage.service;

import com.blank.manage.domain.Seller;
import com.blank.manage.model.PageResult;

public interface SellerService {
    PageResult<Seller> getSellerList(int pageNum, int pageSize, Seller seller);

    Seller getById(Long id);
}
