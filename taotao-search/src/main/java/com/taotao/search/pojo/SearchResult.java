package com.taotao.search.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @ClassName SearchResult
 * @Description TODO
 * @Author Taowd
 * @Date 2018/6/27 21:50
 * @Version V1.0
 */
@Setter
@Getter
@ToString
public class SearchResult {
    /**
     * 总记录
     */
    private Long recordCount;
    /**
     * 商品数据
     */
    private List<Item> itemList;
    /**
     * 每页总数
     */
    private Integer pageCount;
    /**
     * 页码
     */
    private Integer curPage;

}
