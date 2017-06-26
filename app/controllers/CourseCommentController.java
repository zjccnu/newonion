package controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.avaje.ebean.Ebean;

import play.data.Form;
import play.libs.Json;
import models.CourseComment;
import play.mvc.Controller;
import play.mvc.Result;

public class CourseCommentController extends Controller {
   
	  public static Result  addCourseComment(){
		  Map<String, Object> map=new HashMap<>();
		  Form<CourseComment>  comment=Form.form(CourseComment.class);
		  CourseComment courseComment=comment.bindFromRequest().get();
		  List<CourseComment> list=Ebean.find(CourseComment.class).where().eq("courseId", courseComment.getCourse().getCourseId()).eq("usname", courseComment.getUsname()).findList();
		 //是否评论过
		  if(list.size()!=0){
		     map.put("state", "0");
			 map.put("msg", "faile");
		  }else{
		  SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		  courseComment.setTime(format.format(new Date()));
		  courseComment.setCount("0");
		  courseComment.save();
		  map.put("state", "1");
		  map.put("msg", "ok");
		  }
		  return ok(Json.toJson(map)); 
	  }
	  
	   //获取评论
	   public static Result getCourseComment(String courseId){  
		   Map<String, Object> map=new HashMap<>();
		   if(courseId!=null){
		   List<CourseComment> list=Ebean.find(CourseComment.class).where().eq("courseId", courseId).order().desc("time").findList();
		   map.put("state", "1");
		   map.put("msg", "ok");
		   map.put("data", list);
		   }else{
			   map.put("state", "0");
			   map.put("msg", "faile");
		   }
		   return ok(Json.toJson(map));
	   }
}
