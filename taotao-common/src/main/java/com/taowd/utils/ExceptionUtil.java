package com.taowd.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @ClassName ExceptionUtil
 * @Description 异常工具类
 * @Author Taowd
 * @Date 2018/6/13 12:59
 * @Version V1.0
 */
public class ExceptionUtil {
    /**
     * 获取异常的堆栈信息
     *
     * @param t
     * @return
     */
    public static String getStackTrace(Throwable t) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);

        try {
            t.printStackTrace(pw);
            return sw.toString();
        } finally {
            pw.close();
        }
    }
}
