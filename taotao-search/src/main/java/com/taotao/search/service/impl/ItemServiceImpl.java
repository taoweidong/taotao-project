package com.taotao.search.service.impl;

import com.taotao.search.mapper.ItemMapper;
import com.taotao.search.pojo.Item;
import com.taotao.search.service.ItemService;
import com.taowd.utils.TaotaoResult;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * @ClassName ItemServiceImpl
 * @Description TODO
 * @Author Taowd
 * @Date 2018/6/26 22:53
 * @Version V1.0
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemMapper itemMapper;
    @Autowired
    private SolrServer solrServer;


    /**
     * 添加索引库数据
     *
     * @return
     * @throws IOException
     * @throws SolrServerException
     */
    @Override
    public TaotaoResult importItemToIndex() throws IOException, SolrServerException {
        //查询商品列表
        List<Item> itemList = itemMapper.getItemList();
        //将商品列表导入solr
        for (Item item : itemList) {
            SolrInputDocument document = new SolrInputDocument();
            document.addField("id", item.getId());
            document.addField("item_title", item.getTitle());
            document.addField("item_sell_point", item.getSell_point());
            document.addField("item_price", item.getPrice());
            document.addField("item_image", item.getImage());
            document.addField("item_category_name", item.getCategory_name());
            //将文档写入索引库
            solrServer.add(document);
        }
        //提交修改
        solrServer.commit();
        return TaotaoResult.ok();
    }

}
