package com.learn.controller;

import com.learn.controller.base.BaseController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.List;

/**
 * 文件上传测试
 */
@Controller
@Slf4j
public class UploadController extends BaseController {

    @RequestMapping(value = "uploadPre", method = RequestMethod.GET)
    public String uploadPre() {
        return "upload_page";
    }

    /**
     * 单文件上传
     *
     * @param name  文件名
     * @param photo 上传文件
     * @return
     */
    @RequestMapping(value = "upload", method = RequestMethod.POST)
    @ResponseBody
    public String upload(String name, MultipartFile photo) {
        if (photo != null && !photo.isEmpty()) {    // 判断文件上传不为空
            System.err.println("文件名：" + name);
            System.err.println("文件名Name：" + photo.getName());
            System.err.println("文件名OriginalFilename：" + photo.getOriginalFilename());
            System.err.println("文件ContentType：" + photo.getContentType());
            System.err.println("文件大小Size：" + photo.getSize());
        }
        return "fileUpload_success";
    }

    /**
     * 多文件上传
     *
     * @param name    文件名
     * @param request
     * @return
     */
    @RequestMapping(value = "uploadMultipart", method = RequestMethod.POST)
    @ResponseBody
    public String uploadMultipart(String name, HttpServletRequest request) {
        if (request instanceof MultipartHttpServletRequest) {    // 判断是否是多文件上传请求
            MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
            List<MultipartFile> multiPhoto = multipartHttpServletRequest.getFiles("photo");
            Iterator<MultipartFile> iterator=multiPhoto.iterator();
            while (iterator.hasNext()){
                MultipartFile photo = iterator.next();
                if (photo != null && !photo.isEmpty()) {    // 判断文件上传不为空
                    System.err.println("文件名：" + name);
                    System.err.println("文件名Name：" + photo.getName());
                    System.err.println("文件名OriginalFilename：" + photo.getOriginalFilename());
                    System.err.println("文件ContentType：" + photo.getContentType());
                    System.err.println("文件大小Size：" + photo.getSize());
                }
            }
        }
        return "multiFileUpload_success";
    }
}
