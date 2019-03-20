package com.wyatt.controller;

import com.wyatt.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * Created by ASUS on 2018/10/8.
 */


@Controller
public class UploadController {
    @Resource
    private UploadService uploadServiceImpl;
    @RequestMapping("upload")
    public String upload(MultipartFile file){
        try {
            boolean result=uploadServiceImpl.upload(file);
            if (result){
                return "success.jsp";
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return "error.jsp";

    }

}
