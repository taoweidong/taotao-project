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

    /**
     * 添加节点数据
     *
     * @param parentid
     * @param name
     * @return
     */
    TaotaoResult addNode(long parentid, String name);

    /**
     * 更新节点数据
     *
     * @param id
     * @param name
     * @return
     */
    TaotaoResult updateNode(long id, String name);

    /**
     * 删除节点
     *
     * @param parentId
     * @param id
     * @return
     */
    TaotaoResult deleteNode(Long parentId, Long id);
}
