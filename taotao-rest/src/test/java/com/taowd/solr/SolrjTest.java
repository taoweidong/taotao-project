package com.taowd.solr;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

import java.io.IOException;

/**
 * @ClassName SolrjTest
 * @Description TODO
 * @Author Taowd
 * @Date 2018/6/26 22:23
 * @Version V1.0
 */
public class SolrjTest {

    @Test
    public void addDocument() throws IOException, SolrServerException {
        //创建一个连接
        SolrServer solrServer = new HttpSolrServer("http://192.168.230.130:8888/solr");
        //创建一个文档对象
        SolrInputDocument document = new SolrInputDocument();
        document.addField("id", "test00001");
        document.addField("item_title", "测试文档标题22222222");
        document.addField("item_price", 8888);
        //把文档写入索引库
        solrServer.add(document);
        //提交
        solrServer.commit();
    }

    @Test
    public void deleteDocument() throws IOException, SolrServerException {
        //创建一个连接
        SolrServer solrServer = new HttpSolrServer("http://192.168.230.130:8888/solr");
//        solrServer.deleteById("");//根据id删除
        solrServer.deleteByQuery("*:*");//根据id删除

        solrServer.commit();
    }
}
