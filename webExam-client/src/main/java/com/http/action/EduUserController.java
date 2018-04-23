package com.http.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.http.model.EduUser;
import com.http.service.EduUserService;

import redis.clients.jedis.Jedis;


@Controller
@RequestMapping("/eduuser")
public class EduUserController{

	private static Logger logger = Logger.getLogger(EduUserController.class); 
	
	@Autowired
    private EduUserService eduUserService;
	
    @RequestMapping("/main.html")
    public String showUserName(HttpServletRequest request){
        logger.info("This is info message.");  
        logger.debug("This is info message1231.");  
        EduUser user = new EduUser();
        //起始页面
        List<EduUser> eduUserList = eduUserService.queryUser(user);
        request.setAttribute("eduUserList", eduUserList);
        request.setAttribute("userName", eduUserList.get(0).getName());

        Jedis jedis = new Jedis();
        String sessionId = jedis.get("sessionId");
        System.out.println(sessionId);
        HttpSession session = request.getSession();
        System.out.println(session.getAttribute("test")+"测试");
       // session.setAttribute("test",eduUserList.get(0));
        //资源路径
        request.setAttribute("contextPath", request.getContextPath());
        return "home_main";
    }
    
}
