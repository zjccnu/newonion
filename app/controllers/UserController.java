package controllers;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

import models.UserInfo;
import play.libs.Json;
import play.mvc.*;
import sun.misc.BASE64Encoder;
import utils.GleUtils;
public class UserController extends Controller {
	public static Result test(String username,String password){
		Map<String, Object> map=new HashMap<>();
		GleUtils utils=new GleUtils(username, password);
		utils.dologin();
		map=utils.getData("","");
		return ok(Json.toJson(map));
	}
	public static Result doLogin(String username,String password) {
		Map<String, Object> map=new HashMap<>();
		GleUtils utils=new GleUtils(username, password);
    	map=utils.dologin();
    	UserInfo userInfo=new UserInfo();
    	//存放用户名的MD5加密  用来判断是否点赞
    	userInfo.setUsername(EncoderByMd5(username));
    	//如果用户名和密码是正确的
        return ok(Json.toJson(map));
    }
	
	//获取学分
	public static Result getGrade(String username,String password,String xnm,String xqm){
    	Map<String, Object> map=new HashMap<>();
    	GleUtils utils=new GleUtils(username, password);
    	if(utils.dologin().get("state")=="1"){
    		map=utils.getData(xnm,xqm);
    	}else{
    		map=utils.dologin();
    	}
    	
    	return ok(Json.toJson(map));
    }
    
	 public static String EncoderByMd5(String str){
	        //确定计算方法
		 try{
	        MessageDigest md5=MessageDigest.getInstance("MD5");
	        BASE64Encoder base64en = new BASE64Encoder();
	        //加密后的字符串
	        String newstr=base64en.encode(md5.digest(str.getBytes("utf-8")));
	        return newstr;
		 }catch(Exception e){
			 System.out.println("md5异常");
		 }
		 return "";
	    }
	
}
