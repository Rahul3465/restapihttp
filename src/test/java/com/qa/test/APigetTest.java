package com.qa.test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.protocol.ResponseAuthCache;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.client.Restclient;

import restapi.TestBase;

public class APigetTest extends TestBase {

	TestBase testBase = new TestBase();
	Restclient restclient= new Restclient();
	CloseableHttpResponse response;

	@Test
	public void getall() throws ClientProtocolException, IOException {

		CloseableHttpResponse src = restclient.get("http://stage.api.fernlink.com/v1/applications/10000041/versions",
				testBase.headersConfiguration());
		System.out.println(src.getStatusLine().getStatusCode());
		int statuscode = src.getStatusLine().getStatusCode();
		Assert.assertEquals(statuscode, statuscode_200);
	
	}
	
	@Test(description="Get version with valid credentials")
	public void getversion() throws ClientProtocolException, IOException
	{
		response = restclient.get("http://stage.api.fernlink.com/v1/applications/10000041/versions/594", testBase.headersConfiguration());
	    int statuscode = response.getStatusLine().getStatusCode();
	    Assert.assertEquals(statuscode, statuscode_200);
	    String jsonStringResponce = EntityUtils.toString(response.getEntity(), "UTF-8");
	    
	    JSONObject object=new JSONObject(jsonStringResponce);
	    System.out.println("--"+object);
	    
	    String version = object.getString("version");
	    System.out.println(version);
	    
	    Assert.assertEquals(version,"2.990");
	    Assert.assertEquals(object.get("versionId"),594);    
	    		
	}
	
	@Test(description="get version with invalid credentials")
	public void getversion1() throws ClientProtocolException, IOException
	{
		response=restclient.get("http://stage.api.fernlink.com/v1/applications/10000041/versions/700", testBase.headersConfiguration());
		int statuscode = response.getStatusLine().getStatusCode();
		Assert.assertEquals(statuscode, 404);
		JSONObject object = new JSONObject(EntityUtils.toString(response.getEntity(),"UTF-8"));
		
		String name = object.getString("name");
		Assert.assertEquals(name,"NotFoundException");		
	}
	
	@Test(description="Delete a version")
	public void deleteversion() throws ClientProtocolException, IOException
	{
		response = restclient.delete("http://stage.api.fernlink.com/v1/applications/10000041/versions/600",testBase.headersConfiguration());
		int statuscode = response.getStatusLine().getStatusCode();
		System.out.println(statuscode);
		Assert.assertEquals(statuscode, statuscode_204);
	}
	
	
	
	

}
