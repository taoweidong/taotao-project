package com.taowd.controller;

import com.taotao.service.ContentCategoryService;
import com.taowd.utils.EasyUITreeNode;
import com.taowd.utils.TaotaoResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ClassName ContentCategoryController
 * @Description TODO
 * @Author Taowd
 * @Date 2018/6/19 23:15
 * @Version V1.0
 */
@Controller
@RequestMapping("/content/category")
public class ContentCategoryController {

    @Autowired
    private ContentCategoryService contentCategoryService;

    /**
     * 节点列表
     *
     * @param parentid
     * @return
     * @throws Exception
     */
    @RequestMapping("/list")
    @ResponseBody
    public List<EasyUITreeNode> getContentCategoryList(@RequestParam(value = "id", defaultValue = "0") long parentid) throws Exception {
        List<EasyUITreeNode> list = contentCategoryService.getContentCategoryList(parentid);

        return list;
    }

    /**
     * 添加节点
     *
     * @param parentId
     * @param name
     * @return
     * @throws Exception
     */
    @RequestMapping("/create")
    @ResponseBody
    public TaotaoResult addNode(Long parentId, String name) throws Exception {

        TaotaoResult result = contentCategoryService.addNode(parentId, name);

        return result;
    }

    @RequestMapping("/update")
    @ResponseBody
    public TaotaoResult updateNode(Long id, String name) {
        TaotaoResult result = contentCategoryService.updateNode(id, name);
        return result;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public TaotaoResult deleteNode(Long parentId, Long id) {
        System.out.println("parentId:" + parentId + " id:" + id);
        TaotaoResult result = contentCategoryService.deleteNode(parentId, id);
        return result;
    }
}
