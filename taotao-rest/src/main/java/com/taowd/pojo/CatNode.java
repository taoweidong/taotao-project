package com.taowd.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @ClassName CatNode
 * @Description 1、分类列表的节点。包含u、n、i属性。
 * @Author Taowd
 * @Date 2018/6/18 22:45
 * @Version V1.0
 */
public class CatNode {

    @JsonProperty("n")
    private String name;
    @JsonProperty("u")
    private String url;
    @JsonProperty("i")
    private List<?> item;

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public List<?> getItem() {
        return item;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setItem(List<?> item) {
        this.item = item;
    }
}
