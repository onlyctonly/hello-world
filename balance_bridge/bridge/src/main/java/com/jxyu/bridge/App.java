package com.jxyu.bridge;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.util.EntityUtils;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	
    	//system property
    	//java -Dbridge.restart.type=full
    	System.out.println(System.getProperty("bridge.restart.type"));
    	
    	//logging
    	final Logger logger= Logger.getLogger(App.class.getName());
    	//create filehandler and set to append mode
    	FileHandler fileTxt = new FileHandler("Logging.txt", true);
    	
    	SimpleFormatter sf = new SimpleFormatter();
    	fileTxt.setFormatter(sf);
    	logger.addHandler(fileTxt);
    	String t = System.getProperty("bridge.restart.type");
    	if (t!=null) {
        	logger.info(t);
		}
    	//set cookie
    	CookieStore cookieStore = new BasicCookieStore();
    	BasicClientCookie cookie = new BasicClientCookie("name", "value");
    	cookie.setDomain(".goolge.com");
    	cookie.setPath("/");
    	cookieStore.addCookie(cookie);

    	
    		// attach cookie
    		CloseableHttpClient httpClient = HttpClients.custom()
    				 .setDefaultCookieStore(cookieStore)
    				 .build();
    		HttpGet httpGet = new HttpGet("http://www.baidu.com");
    		System.out.println("executing get request: " + httpGet.getURI());
    		logger.info(httpGet.getURI().toString());
			CloseableHttpResponse res = null;
			try {
				res = httpClient.execute(httpGet);
			} catch (ClientProtocolException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

    		try {
				HttpEntity entity = res.getEntity();
				System.out.println(res.getStatusLine());
				
				if (entity!=null) {
					System.out.println(entity.getContentLength());
					System.out.println(EntityUtils.toString(entity));
				}
    		}
			 catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				res.close();
			}
    		
    		
    }
}
