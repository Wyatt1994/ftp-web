package com.wyatt.service.impl;

import com.wyatt.service.UploadService;
import com.wyatt.utils.FtpUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

/**
 * Created by ASUS on 2018/10/8.
 */
@Service
public class UploadServiceImpl implements UploadService{


    @Value("${ftpclient.host}")
    private String host;
    @Value("${ftpclient.port}")
    private int port;
    @Value("${ftpclient.username}")
    private String username;
    @Value("${ftpclient.password}")
    private String password;
    @Value("${ftpclient.basepath}")
    private String basepath;
    @Value("${ftpclient.filepath}")
    private String filepath;

    public boolean upload(MultipartFile file) throws IOException{
//        UUID是Universally Unique Identifier的缩写，它是在一定的范围内（从特定的名字空间到全球）唯一的机器生成的标识符。
        String fileName= UUID.randomUUID()+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        return FtpUtil.uploadFile(host,port,username,password,basepath,filepath,fileName,file.getInputStream());

    }
}
