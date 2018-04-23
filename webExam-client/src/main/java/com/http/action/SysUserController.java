package com.http.action;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.RequestBody;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.bind.annotation.ResponseBody;  
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.http.model.BaseModel;
import com.http.model.EduUser;
import com.http.model.SysUser;
import com.http.model.TestUser;
import com.http.service.EduUserService;
import com.http.util.ErrorMsg.MobileService;
import com.http.util.ErrorUtil;


  
/** 
 * <p> 
 * 系统用户表 前端控制器 
 * </p> 
 * 
 * @since 2017-11-17 
 */  
@Controller  
@RequestMapping("/user")  
public class SysUserController {  
      
      
    /** 
     *  
     *  
     * @Title: index 
     * @Description: 项目根目录访问index.jsp 
     * @param: @param modelAndView 
     * @param: @return 
     * @return: ModelAndView 
     * @user: GR·cheng 
     * 
     */  
	
	@Autowired
    private EduUserService eduUserService;
	
    @RequestMapping("/")  
    public ModelAndView index(ModelAndView modelAndView) {  
        modelAndView.setViewName("index");  
        return modelAndView;  
    }  
      
      
    /** 
     *  
     *  
     * @Title: getParams 
     * @Description: get方法提交 
     * @param: @param id 
     * @param: @param name 
     * @param: @param age 
     * @param: @param ctime 
     * @param: @return 
     * @return: SysUser 
     * @user: GR·cheng 
     * 
     */  
    @ResponseBody  
    @RequestMapping(value = "/getParams",method = RequestMethod.GET)  
    public EduUser getParams(@RequestBody SysUser params) {  
    	EduUser user = new EduUser();
    	List<EduUser> eduUserList = eduUserService.queryUser(user);
    	String json = JSONArray.toJSONString(eduUserList);
    	System.out.println(params.getParams());
        return eduUserList.get(0);  
    }  
      
    /** 
     *  
     *  
     * @Title: postParams 
     * @Description: post方法提交 
     * @param: @param id 
     * @param: @param name 
     * @param: @param age 
     * @param: @param ctime 
     * @param: @return 
     * @return: SysUser 
     * @user: GR·cheng 
     * 
     */  
    @ResponseBody  
    @RequestMapping(value = "/postParams",method = RequestMethod.POST)  
    public String postParams(@RequestBody BaseModel params) {  
    	TestUser testuser = JSON.parseObject(params.getParams(), TestUser.class);  
    	System.out.println(testuser.getName()+"---[测试]----"+testuser.getPassword());
    	EduUser user = new EduUser();
    	List<EduUser> eduUserList = eduUserService.queryUser(user);
    	System.out.println(eduUserList.size());
    	if(eduUserList.size()==62){
    		return ErrorUtil.errorToMessage(MobileService.M100002.getErrCode());
    	}
        return JSON.toJSONString(eduUserList);  
    }  
      
    /** 
     *  
     *  
     * @Title: postJson 
     * @Description: post方法提交json数据 
     * @param: @param param 
     * @param: @return 
     * @return: SysUser 
     * @user: GR·cheng 
     * 
     */  
    @ResponseBody  
    @RequestMapping(value = "/postJson",method = RequestMethod.POST)  
    public static SysUser postJson(@RequestBody String param) {  
        SysUser user = JSON.parseObject(param, SysUser.class);  
        return user;  
    }  
      
}  