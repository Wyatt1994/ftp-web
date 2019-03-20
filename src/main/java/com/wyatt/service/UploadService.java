package com.wyatt.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by ASUS on 2018/10/8.
 */
public interface UploadService {
    boolean upload(MultipartFile file)throws IOException;
}
