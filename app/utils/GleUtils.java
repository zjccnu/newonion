package utils;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLException;

import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.NameValuePair;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import bean.AllInfo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
public class GleUtils {
	 public   String link;
	  public   String username;
	  public   String password; 
	    //重定向策略
	    RequestConfig globalConfig = RequestConfig.custom()  
	    	    .setCookieSpec(CookieSpecs.STANDARD_STRICT)
	    	    .setConnectTimeout(8000)
	    	    .setSocketTimeout(8000)
	    	    .build();  
	    //重传策略
	    HttpRequestRetryHandler handle=new HttpRequestRetryHandler() {
			@Override
			public boolean retryRequest(IOException arg0, int retryTimes, HttpContext arg2) {
				// TODO 自动生成的方法存根
				  if (arg0 instanceof UnknownHostException || arg0 instanceof ConnectTimeoutException  
	                      || !(arg0 instanceof SSLException) || arg0 instanceof NoHttpResponseException) {  
	                  return true;  
	              }  
	              if (retryTimes > 5) {  
	                  return false;  
	              }  
	              HttpClientContext clientContext = HttpClientContext.adapt(arg2);  
	              HttpRequest request = clientContext.getRequest();  
	              boolean idempotent = !(request instanceof HttpEntityEnclosingRequest);  
	              if (idempotent) {  
	                  // 如果请求被认为是幂等的，那么就重试。即重复执行不影响程序其他效果的  
	                  return true;  
	              }  
	              return false;  
	          } 
			
		};
	   // HttpHost proxy = new HttpHost("localhost", 8888, "http");调试设置代理  
	    //不允许自动重定向
	    HttpClientBuilder builder=HttpClients.custom().disableRedirectHandling().setRetryHandler(handle)/*.setProxy(proxy)*/;
	    HttpClientContext context=HttpClientContext.create();
	    CloseableHttpClient httpclient = builder.build();
		public GleUtils(String username,String password) {
			// TODO 自动生成的构造函数存根
			this.link="http://portal.ccnu.edu.cn/loginAction.do";
			this.username=username;
			this.password=password;
		}	
		//登陆目的是获取cookie，从而进行其它页面的操作
		public Map<String, Object> dologin(){	
			 HttpPost httpPost = new HttpPost(link);
			 Map<String, Object> map=new HashMap<>();
			//表单提交
			 httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
			 List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		     nvps.add(new BasicNameValuePair("userName", username));	  
		     nvps.add(new BasicNameValuePair("userPass", password));
		     try {
		     httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
		     CloseableHttpResponse r=httpclient.execute(httpPost,context);
		     String result=EntityUtils.toString(r.getEntity());
		     //看返回的结果是不是包含index_jg
		     if(result.contains("index_jg.jsp")){
		    	 HttpGet httpGet=new HttpGet("http://portal.ccnu.edu.cn/roamingAction.do?appId=XK");
			     CloseableHttpResponse response= httpclient.execute(httpGet,context);
			     String url=EntityUtils.toString(response.getEntity());
			     url=url.substring(url.indexOf("\"")+1);
			     url=url.substring(0,url.indexOf("\""));
			     HttpGet g1=new HttpGet(url);
			     //第一次通过js的重定向
			     CloseableHttpResponse re1=httpclient.execute(g1,context);
			     //第二次是相对路径重定向
			     String url2=re1.getHeaders("location")[0].getValue();
			     url2=url2.replace("../", "");
			     HttpGet g2=new HttpGet(url2);
			     httpclient.execute(g2,context);  	
			     map.put("state", "1");
			     map.put("msg", "ok");
			     return map;
		        }else{
	        	 map.put("state", "0");
			     map.put("msg", "用户名或密码错误");
			     return map;
			     } 
			     }catch (Exception e) {
					e.printStackTrace();
				}
			     map.put("state", "0");
			     map.put("msg", "用户名或密码错误");
			     return map; 
		}
		
			//通过相同的httpclient进行操作
		public Map<String, Object> getData(String xnm,String xqm){
			 Map<String, Object> map=new HashMap<String, Object>();
		    try {
				HttpPost httpPost=new HttpPost("http://122.204.187.6/cjcx/cjcx_cxDgXscj.html?doType=query&gnmkdmKey=N305005&sessionUserKey="+username);
				httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
				httpPost.setConfig(globalConfig);
				 List<NameValuePair> nvps = new ArrayList<NameValuePair>();
				 nvps.add(new BasicNameValuePair("xnm", xnm));
				 nvps.add(new BasicNameValuePair("xqm", xqm));
				 nvps.add(new BasicNameValuePair("_search", "false"));
			     nvps.add(new BasicNameValuePair("nd", "1494606098648"));	  
			     nvps.add(new BasicNameValuePair("queryModel.showCount", "300"));
			     nvps.add(new BasicNameValuePair("queryModel.currentPage", "1"));	
			     nvps.add(new BasicNameValuePair("queryModel.sortOrder", "asc"));
			     nvps.add(new BasicNameValuePair("time", "1"));
			     httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
				 String info=EntityUtils.toString(httpclient.execute(httpPost,context).getEntity());
				 Gson gson=new GsonBuilder().create();
				 AllInfo allInfo=gson.fromJson(info, AllInfo.class);
				 if(allInfo==null){
					 map.put("state", 0);
					 map.put("msg", "服务器异常");
					 return map;
				 }else{
					 map.put("state", 1);
					 map.put("msg", "ok");
					 map.put("data", allInfo);
					 return map;
				 }		
				} catch (Exception e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				} 
			    map.put("state", 0);
				 map.put("msg", "服务器异常");
				 return map;
			}
				
}
