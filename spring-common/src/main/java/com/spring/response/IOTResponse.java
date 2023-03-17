package com.spring.response;

import com.spring.page.Page;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class IOTResponse implements Serializable {

	private static final long serialVersionUID = 3022102758312275178L;
	
	private int status;
	private String message;
	private Map<String,Object> data=new HashMap<>(5);
	
	public IOTResponse(){		
	}
	public IOTResponse(int status){
		this(status,null);
	}
	public IOTResponse(int status,String message){
		this.status=status;
		this.message=message;
	}	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Map<String,Object>  getData() {
		return data;
	}
	public void setData(Map<String,Object>  data) {
		this.data = data;
	}	
	
	public IOTResponse addPage(Page page){
		return add("page",page);
	}
	public IOTResponse removePage(){
		return remove("page");
	}	
	public IOTResponse add(String key,Object value){
		data.put(key, value);
		return this;
	}
	public IOTResponse remove(String key){
		data.remove(key);
		return this;
	}
	
}
