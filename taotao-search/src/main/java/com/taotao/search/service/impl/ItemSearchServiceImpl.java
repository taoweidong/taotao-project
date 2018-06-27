package com.taotao.search.service.impl;

import com.taotao.search.dao.ItemSearchDao;
import com.taotao.search.pojo.SearchResult;
import com.taotao.search.service.ItemSearchService;
import org.apache.solr.client.solrj.SolrQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @ClassName ItemSearchServiceImpl
 * @Description TODO
 * @Author Taowd
 * @Date 2018/6/27 22:19
 * @Version V1.0
 */
@Service
public class ItemSearchServiceImpl implements ItemSearchService {

    @Value("${SEARCH_RESULT_PAGE_SIZE}")
    private Integer PAGE_SIZE;
    @Autowired
    private ItemSearchDao itemSearchDao;


    @Override
    public SearchResult search(String queryString, int page, int rows) throws Exception {
        //创建查询对象
        SolrQuery query = new SolrQuery();
        //设置查询条件
        query.setQuery(queryString);
        //设置分页
        query.setStart((page - 1) * rows);
        query.setRows(rows);
        //设置默认搜素域
        query.set("df", "item_keywords");
        //设置高亮显示
        query.setHighlight(true);
        query.addHighlightField("item_title");
        query.setHighlightSimplePre("<em style=\"color:red\">");
        query.setHighlightSimplePost("</em>");
        //执行查询
        SearchResult searchResult = itemSearchDao.searchItem(query);
        //计算查询结果总页数
        long recordCount = searchResult.getRecordCount();
        long pageCount = recordCount / rows;
        if (recordCount % rows > 0) {
            pageCount++;
        }
        searchResult.setPageCount((int) pageCount);
        searchResult.setCurPage(page);

        return searchResult;
    }
}
