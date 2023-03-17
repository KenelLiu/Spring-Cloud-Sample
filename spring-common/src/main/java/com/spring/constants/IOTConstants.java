package com.spring.constants;

import java.time.Duration;

public interface IOTConstants {
	public static class Response{
		public	static	String Status ="status";
		public	static	String Message="message";
		public	static	int Status_SUCCESS=0;//成功
		public	static	int	Status_FAIL=1;//业务失败
		public  static  int Status_AuthToken_FAIL=2;//验证token失败
		public  static  int Status_Part_Success=3;//部分成功
	}
}
