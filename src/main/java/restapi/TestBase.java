package restapi;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class TestBase {
	
	public static  int statuscode_204 = 204;
	public static int statuscode_200=200;
	public static int statuscode_500=500;
	
	public Properties prop;
	public TestBase()
	{
		try {
		prop = new Properties();
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"/home/sijil/qapitol-qa-api/src/test/resources/config.properties");
		
			prop.load(ip);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public HashMap<String, String> headersConfiguration() {
        HashMap<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("Content-Type", "application/json");
        headerMap.put("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJQRGo5X1FaMl9pQmFCR0ROaDR1aWdTZWU0ckpOWWpKZ2gyZmNEcTVYLVRJIn0.eyJqdGkiOiIxMDMwNTU1OC1hMmYyLTQzN2EtYTQ4Yy02MzU0MjVmMTgxMmQiLCJleHAiOjE1NDQ1OTYwMzcsIm5iZiI6MCwiaWF0IjoxNTQ0MTY0MDM3LCJpc3MiOiJodHRwOi8vc3RhZ2UuYXV0aC5mZXJubGluay5jb20vYXV0aC9yZWFsbXMvZGVtb19hY2NvdW50IiwiYXVkIjoiY29uc29sZSIsInN1YiI6Ijk0YTM5ZDkwLTRkYjgtNGM5Yi1iMmU5LTM4NzVmNzEyYzA1NiIsInR5cCI6IkJlYXJlciIsImF6cCI6ImNvbnNvbGUiLCJub25jZSI6IjcwYjViOTI2LTRhNjYtNDQzOS1hOWExLWIwNDM3NGJhYjEzNiIsImF1dGhfdGltZSI6MTU0NDE2NDAzMywic2Vzc2lvbl9zdGF0ZSI6ImRjNmYyYzU0LTJjZDUtNGYxZS1hYTg2LWUzYTA4Zjc4OGE4MiIsImFjciI6IjEiLCJhbGxvd2VkLW9yaWdpbnMiOlsiKiJdLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsidW1hX2F1dGhvcml6YXRpb24iXX0sInJlc291cmNlX2FjY2VzcyI6eyJhY2NvdW50Ijp7InJvbGVzIjpbIm1hbmFnZS1hY2NvdW50IiwibWFuYWdlLWFjY291bnQtbGlua3MiLCJ2aWV3LXByb2ZpbGUiXX19LCJuYW1lIjoiU2lqaWwgS3VtYXIiLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJzaWppbC5rQHFhcGl0b2wuY29tIiwiZ2l2ZW5fbmFtZSI6IlNpamlsIiwiZmFtaWx5X25hbWUiOiJLdW1hciIsImVtYWlsIjoic2lqaWwua0BxYXBpdG9sLmNvbSJ9.XZibT11MkdX2f9ht_-vargLh0L6J7blBA8bDwK8ivSt3fK_UdOu0AtJZWy_3ic4rphCi1YATGty8thVaEIuNAL2G2sCTGP-EyVJXPzei1L5LbBTVR7tySC4wsokgkFz4LbHleZ7wLs0WwwQS_Aw8Uaia7cy16B3tdhhTA29dp9Ku82_zSoMtP8yZauHhTVRykHEsN9p-lIBTgGtX6PeWIRntesOn2wFLoVPZOZvKMrSFEihQhqMOrVd60Ud3iAEk36wl6KMj_aG_1U5rzyLLNXzpfEy3FkoLdYERE27_Tp8WetEO2YQgWjeN02VeUnRWcdJ56a2RJkbvoTBCbek1-w");
        headerMap.put("x-realm-name", "demo_account");    
        return headerMap;
	}
	

}
