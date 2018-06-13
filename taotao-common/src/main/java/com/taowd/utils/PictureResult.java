package com.taowd.utils;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @ClassName PictureResult
 * @Description TODO
 * @Author Taowd
 * @Date 2018/6/12 23:41
 * @Version V1.0
 */
@Setter
@Getter
@ToString
public class PictureResult {

    private int error;
    private String url;
    private String message;

    private PictureResult(int error, String url, String message) {
        this.error = error;
        this.url = url;
        this.message = message;
    }

    /**
     * 成功时调用的方法
     *
     * @param url 成功后图片的URL地址
     * @return
     */
    public static PictureResult ok(String url) {
        return new PictureResult(0, url, null);
    }

    /**
     * 失败时调用的方法
     *
     * @param message 失败信息
     * @return
     */
    public static PictureResult error(String message) {
        return new PictureResult(1, null, message);
    }


}
