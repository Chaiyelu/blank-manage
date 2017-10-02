package com.blank.manage.utils;

import com.blank.manage.model.PageResult;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

public class BeanUtil {

    public static <T> PageResult<T> toPageResult(List<T> datas) {
        PageResult<T> result = new PageResult<T>();
        if (datas instanceof Page) {
            PageInfo pageInfo = new PageInfo(datas);
            result.setRows(pageInfo.getList());
            result.setPage(pageInfo.getPageNum());
            result.setPrevPage(pageInfo.getPrePage());
            result.setNextPage(pageInfo.getNextPage());
            result.setPageSize(pageInfo.getPageSize());
            result.setTotal(pageInfo.getTotal());
            result.setHasNextPage(pageInfo.isHasNextPage());
            result.setHasPrevPage(pageInfo.isHasPreviousPage());
        }
        else {
            result.setPage(1);
            result.setPageSize(datas.size());
            result.setRows(datas);
            result.setTotal(datas.size());
        }

        return result;
    }

}
