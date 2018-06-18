package com.taowd.pojo;

import java.util.List;

/**
 * @ClassName CatResult
 * @Description 2、返回值pojo。包含data属性是一个list类型。
 * @Author Taowd
 * @Date 2018/6/18 22:42
 * @Version V1.0
 */
public class CatResult {

    private List<?> data;

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}
