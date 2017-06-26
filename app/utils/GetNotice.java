package utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import com.avaje.ebean.Ebean;
import models.Notice;

//获取学院公告和学生公告
public class GetNotice {
   public final  static String tzggxs="http://jwc.ccnu.edu.cn/index/tzggxs.htm";
   public final  static String tzggxy="http://jwc.ccnu.edu.cn/index/tzggxy.htm";
  //文章类型 1代表公告学生 0代表公告学院
  //学院公告
   public static void getNotice(String url,String type){
	   try {
		Document doc = Jsoup.connect(url).get();
		 Elements list = doc.getElementsByClass("list");
		 for(Element element:list){
			 Document li = Jsoup.parse(element.toString());
			 Elements elements=li.select("li");
			 for(Element e:elements){
				 Notice notice=new Notice();
				 String t=e.text();
				 String title=t.substring(0, t.length()-10);
				 String time=t.substring(t.length()-10);
				 String link=e.select("a").attr("href");
				 link="http://jwc.ccnu.edu.cn"+link.substring(2);
				 notice.setTitle(title);
				 notice.setType(type);
				 notice.setNoticeTime(time);
				 notice.setUrl(link);
				 Ebean.save(notice);
				 System.out.println(title+"  "+link+" "+time);
			 }
		 }
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

   }
   //类型为1 代表公告学生 
   public static void getGgxs(){
	   GetNotice.getNotice(tzggxs,"1");
   }
   //为0代表公告学院
   public static void getGgxy(){
	   GetNotice.getNotice(tzggxy,"0");
   }
}
