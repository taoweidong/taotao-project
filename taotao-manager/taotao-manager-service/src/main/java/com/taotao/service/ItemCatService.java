package com.taotao.service;

import com.taowd.pojo.TbItemCat;

import java.util.List;

/**
 * @ClassName ItemCatService
 * @Description TODO
 * @Author Taowd
 * @Date 2018/6/9 21:42
 * @Version V1.0
 */
public interface ItemCatService {

    /**
     * 可以根据parentid查询分类列表
     *
     * @param parentId 父节点
     * @return
     */
    List<TbItemCat> getItemCatList(Long parentId);
}
