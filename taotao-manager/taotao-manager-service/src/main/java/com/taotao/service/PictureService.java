package com.taotao.service;

import com.taowd.utils.PictureResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName PictureService
 * @Description 图片上传服务
 * @Author Taowd
 * @Date 2018/6/11 22:20
 * @Version V1.0
 */
public interface PictureService {
    /**
     * 图片上传
     *
     * @param uploadFile 文件内容
     * @return
     */
    PictureResult uploadPicture(MultipartFile uploadFile);
}
