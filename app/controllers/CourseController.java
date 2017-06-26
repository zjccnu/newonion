package controllers;
import java.util.HashMap;
import java.util.List;
import com.avaje.ebean.Ebean;
import com.avaje.ebean.Expr;
import models.Course;
import models.CourseComment;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
public class CourseController extends Controller{
	   public static Result  addCourse(){
		   HashMap<String, Object> map=new HashMap<>();
		   Form<Course>  comment=Form.form(Course.class);
		   Course course=comment.bindFromRequest().get();
		   String courseName=course.getCourseName();
		   String courseTeacher=course.getCourseTeacher();
		   List<Course> list=Ebean.find(Course.class).where().eq("courseName", courseName).eq("courseTeacher", courseTeacher).findList();
		   if(list.size()==0){
		   if(courseName!=null&&courseTeacher!=null){
			   Ebean.save(course);
			   //如果没有这门课 ,则先插入后取出
			   List<Course> list1=Ebean.find(Course.class).where().eq("courseName", courseName).eq("courseTeacher", courseTeacher).findList();
			   map.put("state", "1");
			   map.put("msg", "ok");
			   map.put("data", list1);
		   }else{
			   map.put("state", "0");
			   map.put("msg", "faile");
		   }
		   }else{
			   //已经插入后
			   map.put("state", "2");
			   map.put("msg", "ok");
			   map.put("data", list.get(0));
		   }
		   return ok(Json.toJson(map)); 
	   }
	   
	   //通过教师或者课程名模糊查询获取课程号
	   public static  Result getCourseIds(String search){
		      HashMap<String, Object> map=new HashMap<>();
		   //  List<Course> list= Ebean.find(Course.class).where().or(Expr.like("courseName","%"+ search + "%"),Expr.like("courseTeacher","%"+ search + "%")).findList();
		      List<Course> list= Ebean.find(Course.class).where().or(Expr.contains("courseName", search),Expr.contains("courseTeacher", search)).findList();
		      //外键的in语句,直接使用外键对象即可
	    	   List<CourseComment> lsit=Ebean.find(CourseComment.class).where().in("course", list).findList();
	    	   //Ebean.find(CourseComment.class).f
	    	   map.put("state", "1");
			   map.put("msg", "ok");
	    	   map.put("data", lsit);
	      
	      return ok(Json.toJson(map)); 
		 
	   }
   
 
   
}
