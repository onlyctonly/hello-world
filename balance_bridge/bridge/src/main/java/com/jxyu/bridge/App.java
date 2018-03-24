package com.jxyu.bridge;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class App 
{
    public static void main( String[] args )
    {
    		CloseableHttpClient httpClient = HttpClients.createDefault();
    		HttpGet httpGet = new HttpGet("http://www.google.com/");
    		System.out.println("executing get request: " + httpGet.getURI());
    		
    		try {
				CloseableHttpResponse res = httpClient.execute(httpGet);
				HttpEntity entity = res.getEntity();
				System.out.println(res.getStatusLine());
				
				if (entity!=null) {
					System.out.println(entity.getContentLength());
					System.out.println(EntityUtils.toString(entity));
				}
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    		
    }
}
