package com.xjl.learn.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @Description:
 * @author: xjl
 * @date: 2021-01-20-16:43
 */
public class FileUtil {

    private static final String PATH = "F:/资料";

    //文件上传
    public static void fileUpload(MultipartFile file) throws IOException {

        if(!file.isEmpty() && file.getSize() >0){

            String fileName = file.getOriginalFilename();
            String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
            //String realFileName = (new Date()).getTime().concat(".").concat(suffix);
            String realFileName = (new Date()).getTime() + "." + suffix;
            //创建文件
            File dest = new File(PATH, realFileName);
            if(dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            // 存入临时文件
            file.transferTo(dest.getAbsoluteFile());
        }
    }
}
