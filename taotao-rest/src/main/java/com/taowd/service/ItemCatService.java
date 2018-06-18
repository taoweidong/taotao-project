package com.taowd.service;

import com.taowd.pojo.CatResult;

import java.util.List;

/**
 * @ClassName ItemCatService
 * @Description TODO
 * @Author Taowd
 * @Date 2018/6/18 22:48
 * @Version V1.0
 */
public interface ItemCatService {

    CatResult getItemCatList();

    /**
     * 查询分类列表
     * @param parentId
     * @return
     */
    List<?> getCatList(long parentId);
}
