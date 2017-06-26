package controllers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlRow;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import utils.GetNotice;

public class NoticeController extends Controller{
	//进行数据爬虫
	public static Result getNotice(){
		GetNotice.getGgxs();
		GetNotice.getGgxy();
		return ok();
	}
	//获取公告学生
	public static Result getNoticeTop15Tzggxs(){
		String sql="select * from notice where type='1' order by noticeid desc limit 15 ";
		List<SqlRow> list=Ebean.createSqlQuery(sql).findList();
		Map<String, Object> map=new  HashMap<>();
		map.put("state", "1");
		map.put("msg", "ok");
		map.put("data", list);
		return ok(Json.toJson(map));
	}
	//获取公告学院
	public static Result getNoticeTop15Tzggxy(){
		String sql="select * from notice where type='0' order by noticeid desc limit 15 ";
		List<SqlRow> list=Ebean.createSqlQuery(sql).findList();
		Map<String, Object> map=new  HashMap<>();
		map.put("state", "1");
		map.put("msg", "ok");
		map.put("data", list);
		return ok(Json.toJson(map));
	}
}
