package com.taowd.search;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.junit.Test;

/**
 * @ClassName TestSolr
 * @Description TODO
 * @Author Taowd
 * @Date 2018/6/27 21:55
 * @Version V1.0
 */
public class TestSolr {
    @Test
    public void queryDocument() throws SolrServerException {
        SolrServer solrServer = new HttpSolrServer("http://192.168.230.130:8888/solr");
        //创建查询条件
        SolrQuery query = new SolrQuery();
        //设置查询条件
        query.setQuery("*:*");
        query.setStart(1);
        query.setRows(10000);
        //执行查询
        QueryResponse response = solrServer.query(query);

        //取查询条件
        SolrDocumentList solrDocuments = response.getResults();


        System.out.println("共查询到：" + solrDocuments.getNumFound());

        for (SolrDocument document : solrDocuments) {
            System.out.println(document.get("id"));
            System.out.println(document.get("item_title"));
            System.out.println(document.get("item_price"));
            System.out.println(document.get("item_image"));
        }
    }
}
