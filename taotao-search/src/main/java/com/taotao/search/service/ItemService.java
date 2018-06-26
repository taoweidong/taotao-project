package com.taotao.search.service;

import com.taowd.utils.TaotaoResult;
import org.apache.solr.client.solrj.SolrServerException;

import java.io.IOException;

/**
 * @ClassName ItemService
 * @Description TODO
 * @Author Taowd
 * @Date 2018/6/26 22:52
 * @Version V1.0
 */
public interface ItemService {

    TaotaoResult importItemToIndex() throws IOException, SolrServerException;
}
