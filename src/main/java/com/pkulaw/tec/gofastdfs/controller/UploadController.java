package com.pkulaw.tec.gofastdfs.controller;

import cn.hutool.core.io.resource.InputStreamResource;
import cn.hutool.core.lang.Console;
import cn.hutool.http.HttpUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UploadController {
    @PostMapping("/upload")
    public String  upload(MultipartFile upFile) {
        String result = "";
        try {
            InputStreamResource isr = new InputStreamResource(upFile.getInputStream(), upFile.getOriginalFilename());
            Map<String, Object> params = new HashMap<>();
            params.put("file", isr);
//            params.put("path", "86501729");
            params.put("output", "json");
            String resp = HttpUtil.post("http://192.168.216.128:8080/group1/upload", params);
            Console.log("resp: {}", resp);
            result = resp;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}

