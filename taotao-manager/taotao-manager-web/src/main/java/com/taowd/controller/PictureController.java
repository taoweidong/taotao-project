package com.taowd.controller;

import com.taotao.service.PictureService;
import com.taowd.utils.JsonUtils;
import com.taowd.utils.PictureResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName PictureController
 * @Description 图片上传
 * @Author Taowd
 * @Date 2018/6/11 23:20
 * @Version V1.0
 */
@Controller
public class PictureController {

    /**
     * 日志
     */
    private static final Logger logger = LoggerFactory.getLogger(PictureController.class);

    @Autowired
    private PictureService pictureService;

    @RequestMapping("/pic/upload")
    @ResponseBody//标记本接口返回的是JSON串
    public PictureResult upload(MultipartFile uploadFile) {
        PictureResult result = pictureService.uploadPicture(uploadFile);
        //将result转成JSON数据格式
//        String jsonResult = JsonUtils.objectToJson(result);

        logger.info("上传图片结果：" + JsonUtils.objectToJson(result));
        return result;
    }

}
