package com.taotao.service;

import com.taowd.utils.EasyUITreeNode;
import com.taowd.utils.TaotaoResult;

import java.util.List;

/**
 * @ClassName ContentCategoryService
 * @Description 内容管理服务
 * @Author Taowd
 * @Date 2018/6/19 23:11
 * @Version V1.0
 */
public interface ContentCategoryService {
    /**
     * 获取信息
     *
     * @param parentid
     * @return
     */
    List<EasyUITreeNode> getContentCategoryList(long parentid);

    TaotaoResult addNode(long parentid, String name);

}
