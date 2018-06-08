package com.taowd.utils;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @ClassName EasyUIResult
 * @Description Easyui的DataGrid数据填充格式
 * @Author Taowd
 * @Date 2018/6/8 21:50
 * @Version V1.0
 */
@Setter
@Getter
@ToString
public class EasyUIResult {
    /**
     * 总条数
     */
    private Integer total;
    /**
     * 行数据
     */
    private List<?> rows;

    public EasyUIResult(Integer total, List<?> rows) {
        this.total = total;
        this.rows = rows;
    }

    public EasyUIResult(Long total, List<?> rows) {
        this.total = total.intValue();
        this.rows = rows;
    }

}
