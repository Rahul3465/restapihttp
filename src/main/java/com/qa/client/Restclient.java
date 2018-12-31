package com.qa.client;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class Restclient {

	// GET method
	public CloseableHttpResponse get(String url, HashMap<String, String> headerMap)
			throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url); 
		
		for (Map.Entry<String, String> entry : headerMap.entrySet()) {
			httpget.addHeader(entry.getKey(), entry.getValue());
		}
		CloseableHttpResponse closebaleHttpResponse = httpClient.execute(httpget); // hit the GET URL
		return closebaleHttpResponse;

	}
	
	//Post method
	public CloseableHttpResponse post(String url,String entityString,HashMap<String, String> headerMap) throws ClientProtocolException, IOException
	{
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost httppost = new HttpPost(url); 
		httppost.setEntity(new StringEntity(entityString));
		
		for (Map.Entry<String, String> entry : headerMap.entrySet()) {
			httppost.addHeader(entry.getKey(), entry.getValue());
		}
		CloseableHttpResponse closebaleHttpResponse = httpClient.execute(httppost); 
		return closebaleHttpResponse;
		
		
	}
	
	//Delete method
	public CloseableHttpResponse delete(String url,HashMap<String, String> headerMap) throws ClientProtocolException, IOException
	{
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpDelete httpdelete = new HttpDelete(url);
		for (Map.Entry<String, String> entry : headerMap.entrySet()) {
			httpdelete.addHeader(entry.getKey(), entry.getValue());
		}
		CloseableHttpResponse closebleHttpResponse = httpClient.execute(httpdelete);
		return closebleHttpResponse;
	}
	
	//put method
	public CloseableHttpResponse put(String url, String entityString, HashMap<String, String> headerMap)
            throws ClientProtocolException, IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPut httpput = new HttpPut(url);
        httpput.setEntity(new StringEntity(entityString)); 
        // for headers:
        for (Map.Entry<String, String> entry : headerMap.entrySet()) {
            httpput.addHeader(entry.getKey(), entry.getValue());
        }

        CloseableHttpResponse closebaleHttpResponse = httpClient.execute(httpput);
        return closebaleHttpResponse;
    }
	
	
}

