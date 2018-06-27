package com.taowd.service;

/**
 * @ClassName SearchService
 * @Description TODO
 * @Author Taowd
 * @Date 2018/6/27 23:02
 * @Version V1.0
 */
public interface SearchService {

    com.taowd.pojo.SearchResult search(String queryString, int page);
}
