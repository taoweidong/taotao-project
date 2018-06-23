package com.taotao.service;

import com.taowd.pojo.TbItemParam;
import com.taowd.utils.EasyUIResult;
import com.taowd.utils.TaotaoResult;

/**
 * @ClassName ParamService
 * @Description 参数接口
 * @Author Taowd
 * @Date 2018/6/13 23:19
 * @Version V1.0
 */
public interface ParamService {
    /**
     * @param cid
     * @return
     */
    TaotaoResult getItemParamByCid(long cid);

    TaotaoResult insertItemParam(TbItemParam itemParam);

    /**
     * @param page
     * @param rows
     * @return
     */
    EasyUIResult getItemParamList(Integer page, Integer rows);

    TaotaoResult getParamById(Long id);

    TaotaoResult deleteItemById(String[] ids);
}
