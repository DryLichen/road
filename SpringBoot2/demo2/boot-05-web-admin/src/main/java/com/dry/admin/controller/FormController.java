package com.dry.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Slf4j
@Controller
public class FormController {
    @RequestMapping(value = "/form_layouts", method = RequestMethod.GET)
    public String form(){
        return "form/form_layouts";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(@RequestParam("email") String email,
                         @RequestParam("username") String username,
                         @RequestPart("avatar") MultipartFile avatar,
                         @RequestPart("photos") MultipartFile[] photos) throws IOException {

        log.info("上传信息：email{}, username{}, avatar{}, photos{}",email, username, avatar.getSize(), photos.length);

        if(!avatar.isEmpty()){
            String orgName = avatar.getOriginalFilename();
            avatar.transferTo(new File("D:\\java\\code\\SpringBoot2\\demo2\\cache" + File.separator + orgName));
        }

        if(photos.length > 0){
            for (MultipartFile photo : photos) {
                if(!photo.isEmpty()){
                    String orgName = photo.getOriginalFilename();
                    photo.transferTo(new File("D:\\java\\code\\SpringBoot2\\demo2\\cache" + File.separator + orgName));
                }
            }
        }
        return "main";
    }
}
