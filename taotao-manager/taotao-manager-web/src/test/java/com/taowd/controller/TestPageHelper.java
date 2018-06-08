package com.taowd.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taowd.dao.TbItemMapper;
import com.taowd.pojo.TbItem;
import com.taowd.pojo.TbItemExample;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @ClassName TestPageHelper
 * @Description 测试分页插件
 * @Author Taowd
 * @Date 2018/6/8 22:29
 * @Version V1.0
 */
public class TestPageHelper {

    @Test
    public void testPageHelper() {
        //创建一个Spring容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
        //从spring中获得Mapper的代理对象
        TbItemMapper tbItemMapper = applicationContext.getBean(TbItemMapper.class);
        //执行查询，测试分页
        TbItemExample example = new TbItemExample();
        //执行分页功能
        PageHelper.startPage(1, 20);
        //执行查询
        List<TbItem> tbItemsList = tbItemMapper.selectByExample(example);

//        for (TbItem item : tbItemsList) {
//            System.out.println(item.getTitle());
//        }

        //获取分页信息
        PageInfo<TbItem> pageInfo = new PageInfo<TbItem>(tbItemsList);

        Assert.assertEquals(3096, pageInfo.getTotal());


    }
}
