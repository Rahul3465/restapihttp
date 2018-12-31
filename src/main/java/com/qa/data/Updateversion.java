package com.qa.data;

public class Updateversion {
	
	String description;
	String version;
	String versionState;
	
	public Updateversion()
	{
		
	}
	public Updateversion(String description,String version,String versionstate)
	{
		
		this.description=description;
		this.version=version;
		this.versionState=versionstate;
		
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getVersionState() {
		return versionState;
	}
	public void setVersionState(String versionState) {
		this.versionState = versionState;
	}
	
	

}
