package com.taowd.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @ClassName Item
 * @Description TODO
 * @Author Taowd
 * @Date 2018/6/27 23:03
 * @Version V1.0
 */
@Setter
@Getter
@ToString
public class Item {
    private String id;
    private String title;
    private String sell_point;
    private long price;
    private String image;
    private String category_name;
    private String item_des;
}
