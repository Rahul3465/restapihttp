package com.qa.test;

import java.io.File;
import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.client.Restclient;
import com.qa.data.Createversion;
import com.qa.data.Updateversion;

import restapi.TestBase;

public class ApipostTest extends TestBase {

	String serviceUrl;
	String apiUrl;
	String url;
	Restclient restClient;
	CloseableHttpResponse response;
	Object versionID;
	
	public int Status_200=200;
	public int Status_500=500;
	public int Status_404=404;
	
	@BeforeMethod
    public void setUp() throws ClientProtocolException, IOException{
        serviceUrl = prop.getProperty("URL");
        apiUrl = prop.getProperty("serviceURL");
        url = serviceUrl + apiUrl;        
    }

	@Test(description="Creating version with valid credentials")
	public void createversion() throws JsonGenerationException, JsonMappingException, IOException {
		
		restClient=new Restclient();
		ObjectMapper mapper=new ObjectMapper();
		Createversion version=new Createversion("Hello version!!", "2.01", "Testeddds");
		mapper.writeValue(new File("/home/sijil/restapi/src/main/java/com/qa/data/Createuser.json"), version);
		
		String versionString =mapper.writeValueAsString(version);
		
		System.out.println("--------"+versionString);
		
		response =restClient.post(url, versionString, headersConfiguration());
		int statuscode =response.getStatusLine().getStatusCode();
		System.out.println("Status code = "+statuscode);
		
		String responseString = EntityUtils.toString(response.getEntity(), "UTF-8");

        JSONObject responseJson = new JSONObject(responseString);
        versionID= responseJson.get("versionId");
		
		Assert.assertEquals(statuscode,statuscode_200);
		
	}
	
	@Test(description="Update version")
	public void updateversion() throws JsonGenerationException, JsonMappingException, IOException
	{
		restClient = new Restclient();
		ObjectMapper mapper=new ObjectMapper();
		Updateversion updateversion = new Updateversion("Hi!!","3.0","Tested");
		mapper.writeValue(new File("/home/sijil/restapi/src/main/java/com/qa/data/Updateversion.json"), updateversion);
		
		String versionString = mapper.writeValueAsString(updateversion);
		response=restClient.put("http://stage.api.fernlink.com/v1/applications/10000041/versions/"+versionID ,versionString, headersConfiguration());
		int statuscode = response.getStatusLine().getStatusCode();
		Assert.assertEquals(statuscode,statuscode_200);
		JSONObject object = new JSONObject(EntityUtils.toString(response.getEntity(),"UTF-8"));
		Assert.assertEquals(object.get("version"), "3.0");
		
	}
	
	
	

}
