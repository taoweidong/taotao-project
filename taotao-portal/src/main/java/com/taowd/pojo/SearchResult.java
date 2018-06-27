package com.taowd.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @ClassName SearchResult
 * @Description TODO
 * @Author Taowd
 * @Date 2018/6/27 23:03
 * @Version V1.0
 */
@Setter
@Getter
@ToString
public class SearchResult {


    //商品列表
    private List<Item> itemList;
    //总记录数
    private long recordCount;
    //总页数
    private long pageCount;
    //当前页
    private long curPage;
}
