package com.taotao.service;

import com.taowd.pojo.TbContent;
import com.taowd.utils.EasyUIResult;
import com.taowd.utils.TaotaoResult;

/**
 * @ClassName ContentService
 * @Description 内容管理
 * @Author Taowd
 * @Date 2018/6/21 21:44
 * @Version V1.0
 */
public interface ContentService {

    /**
     * 查询内容
     *
     * @param pageIndex
     * @param pageCount
     * @return
     */
    EasyUIResult queryList(Integer pageIndex, Integer pageCount, Long categoryId);

    /**
     * 插入内容
     *
     * @param content
     * @return
     */
    TaotaoResult insertContent(TbContent content);

    /**
     * 修改内容
     *
     * @param content
     * @return
     */
    TaotaoResult updateContent(TbContent content);

    /**
     * 删除内容
     *
     * @param ids
     * @return
     */
    TaotaoResult deleteContent(Long ids);
}
