package com.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.service.ParamService;
import com.taowd.dao.TbItemParamMapper;
import com.taowd.pojo.TbItemParam;
import com.taowd.pojo.TbItemParamExample;
import com.taowd.utils.EasyUIResult;
import com.taowd.utils.ExceptionUtil;
import com.taowd.utils.TaotaoResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @ClassName ParamServiceImpl
 * @Description 商品规格参数模板管理
 * @Author Taowd
 * @Date 2018/6/13 23:20
 * @Version V1.0
 */
@Service
public class ParamServiceImpl implements ParamService {

    @Autowired
    private TbItemParamMapper itemParamMapper;

    @Override
    public TaotaoResult getItemParamByCid(long cid) {

        //根据cid查询数据库
        TbItemParamExample example = new TbItemParamExample();
        TbItemParamExample.Criteria criteria = example.createCriteria();
        criteria.andItemCatIdEqualTo(cid);
        List<TbItemParam> list = itemParamMapper.selectByExampleWithBLOBs(example);
        //如果查询中有结果返回查询结果
        if (list != null && !list.isEmpty()) {
            return TaotaoResult.ok(list.get(0));
        }
        //查询成功但是没有查到数据
        return TaotaoResult.ok();
    }

    /**
     * 插入参数
     *
     * @param itemParam
     * @return
     */
    @Override
    public TaotaoResult insertItemParam(TbItemParam itemParam) {
        //补全pojo
        itemParam.setCreated(new Date());
        itemParam.setUpdated(new Date());
        //插入到规格参数模板表
        itemParamMapper.insert(itemParam);
        return TaotaoResult.ok();
    }

    /**
     * 查询参数信息
     *
     * @param page
     * @param rows
     * @return
     */
    @Override
    public EasyUIResult getItemParamList(Integer page, Integer rows) {
        //分页处理
        PageHelper.startPage(page, rows);
        //查询规格列表
        List<TbItemParam> list = itemParamMapper.selectByExampleWithBLOBs(new TbItemParamExample());
        //取分页信息
        PageInfo<TbItemParam> pageInfo = new PageInfo<>(list);
        //返回结果
        EasyUIResult result = new EasyUIResult(pageInfo.getTotal(), list);

        return result;

    }

    @Override
    public TaotaoResult getParamById(Long id) {
        TbItemParam tbItemParam = itemParamMapper.selectByPrimaryKey(id);

        return TaotaoResult.ok(tbItemParam);
    }

    /**
     * 删除功能
     *
     * @param ids
     * @return
     */
    @Override
    public TaotaoResult deleteItemById(String[] ids) {

        try {
            itemParamMapper.deleteByIds(ids);
        } catch (Exception ex) {
            return TaotaoResult.build(500, ExceptionUtil.getStackTrace(ex));
        }


        return TaotaoResult.ok();
    }
}
