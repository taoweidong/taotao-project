package com.taotao.service.impl;

import com.taotao.service.PictureService;
import com.taowd.utils.FtpUtil;
import com.taowd.utils.IDUtils;
import com.taowd.utils.PictureResult;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @ClassName PictureServiceImpl
 * @Description 上传图片处理服务实现类
 * @Author Taowd
 * @Date 2018/6/11 22:22
 * @Version V1.0
 */
@Service
public class PictureServiceImpl implements PictureService {

    @Value("${FTP_ADDRESS}")
    private String FTP_ADDRESS;
    @Value("${FTP_PORT}")
    private String FTP_PORT;
    @Value("${FTP_USER_NAME}")
    private String FTP_USER_NAME;
    @Value("${FTP_PASSWORD}")
    private String FTP_PASSWORD;
    @Value("${FTP_BASE_PATH}")
    private String FTP_BASE_PATH;
    @Value("${IMAGE_BASE_URL}")
    private String IMAGE_BASE_URL;
    /**
     * 日志
     */
    private static final Logger logger = LoggerFactory.getLogger(PictureServiceImpl.class);


    /**
     * 图片上传服务
     *
     * @param uploadFile 文件内容
     * @return
     */
    @Override
    public PictureResult uploadPicture(MultipartFile uploadFile) {
        PictureResult result = null;
        //判断文件是否为空
        if (uploadFile == null || uploadFile.isEmpty()) {
            return PictureResult.error("上传文件不能为空!");
        }
        //取原始文件名
        String oldName = uploadFile.getOriginalFilename();
        //生成新的文件名
        String newName = IDUtils.genImageName();
        newName = newName + oldName.substring(oldName.indexOf("."));
        String imagePath = new DateTime().toString("/yyyy/MM/dd");
        //上传文件
        try {
            boolean flag = FtpUtil.uploadFile(FTP_ADDRESS, Integer.parseInt(FTP_PORT), FTP_USER_NAME, FTP_PASSWORD,
                    FTP_BASE_PATH, imagePath, newName, uploadFile.getInputStream());
            logger.info("上传图片结果：" + flag);
            if (flag) {
                result = PictureResult.ok(IMAGE_BASE_URL + imagePath + "/" + newName);
            } else {
                result = PictureResult.error("上传文件失败!");
            }
        } catch (IOException e) {
            result = PictureResult.error("上传文件失败!" + e.getMessage());
            e.printStackTrace();
        }

        return result;
    }
}
