package com.taotao.search.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @ClassName Item
 * @Description 搜索实体
 * @Author Taowd
 * @Date 2018/6/26 22:48
 * @Version V1.0
 */
@Setter
@Getter
@ToString
public class Item {
    private Long id;
    private String title;
    private String sell_point;
    private Long price;
    private String image;
    private String category_name;

}
