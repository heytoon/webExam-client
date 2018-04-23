package com.http.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.http.util.FileUpload;



@Controller
@RequestMapping("/file")  
public class EduFileController {
	
	private static Logger logger = Logger.getLogger(EduUserController.class); 

	@RequestMapping("/toupload.html")
    public String toUpload(HttpServletRequest request){
        logger.info("upload page"); 
        //资源路径
        request.setAttribute("contextPath", request.getContextPath());
        return "account/testupload";
    }
	@ResponseBody
    @RequestMapping("/upload.html")
    public String fileUpload(@RequestParam("iconUrl") CommonsMultipartFile[] file,HttpSession session,HttpServletRequest request,HttpServletResponse response){
        logger.info("upload page");  
        //上传至文件服务器
        for(int i=0;i<file.length;i++){
            String url = FileUpload.upload(file[i],request,response);
            System.out.println(url);
        }
        return "success";
    }
}
