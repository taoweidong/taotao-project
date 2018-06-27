package com.taotao.search.service;

import com.taotao.search.pojo.SearchResult;
import org.apache.solr.client.solrj.SolrServerException;

/**
 * @ClassName ItemSearchService
 * @Description TODO
 * @Author Taowd
 * @Date 2018/6/27 22:19
 * @Version V1.0
 */
public interface ItemSearchService {

    SearchResult search(String queryString, int page, int rows) throws Exception;
}
