package com.taowd.controller;

import com.taotao.service.ParamService;
import com.taowd.pojo.TbItemParam;
import com.taowd.utils.EasyUIResult;
import com.taowd.utils.TaotaoResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName ParamController
 * @Description 参数查询接口
 * @Author Taowd
 * @Date 2018/6/13 23:23
 * @Version V1.0
 */
@Controller
@RequestMapping("/item/param")
public class ParamController {

    @Autowired
    private ParamService paramService;

    /**
     * @param itemCatId
     * @return
     */
    @RequestMapping("/query/itemcatid/{itemCatId}")
    @ResponseBody
    public TaotaoResult getItemParamByCid(@PathVariable Long itemCatId) {
        TaotaoResult result = paramService.getItemParamByCid(itemCatId);
        return result;
    }

    @RequestMapping("/save/{cid}")
    @ResponseBody
    public TaotaoResult insertItemParam(@PathVariable Long cid, String paramData) {
        //创建pojo对象
        TbItemParam itemParam = new TbItemParam();
        itemParam.setItemCatId(cid);
        itemParam.setParamData(paramData);
        TaotaoResult result = paramService.insertItemParam(itemParam);
        return result;
    }

    /**
     * 查询商品列表
     *
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public EasyUIResult getItemList(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "30") Integer rows) {
        //查询结果
        EasyUIResult result = paramService.getItemParamList(page, rows);
        return result;
    }


    @RequestMapping("/delete")
    @ResponseBody
    public TaotaoResult deleteParam(String ids) {
        if (StringUtils.isEmpty(ids)) {
            return TaotaoResult.build(500, "删除失败，id不能为空！");
        }
        String[] idsArr = ids.split(",");
        TaotaoResult result = paramService.deleteItemById(idsArr);
        return result;
    }

    @RequestMapping("/item/query/{id}")
    @ResponseBody
    public TaotaoResult getParamInfo(@PathVariable Long id) {
        TaotaoResult result = paramService.getParamById(id);
        return result;
    }

}
