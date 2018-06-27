package com.taotao.search.dao;

import com.taotao.search.pojo.SearchResult;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;

/**
 * @ClassName ItemSearchDao
 * @Description TODO
 * @Author Taowd
 * @Date 2018/6/27 21:51
 * @Version V1.0
 */
public interface ItemSearchDao {

    SearchResult searchItem(SolrQuery solrQuery) throws SolrServerException;
}
