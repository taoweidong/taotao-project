package com.taowd.service;

import com.taowd.pojo.TbContent;

import java.util.List;

/**
 * @ClassName ContentService
 * @Description 内容管理
 * @Author Taowd
 * @Date 2018/6/21 23:02
 * @Version V1.0
 */
public interface ContentService {

    /**
     * 根据id获取内容
     *
     * @param contentCid
     * @return
     */
    List<TbContent> getContentList(Long contentCid);
}
