package com.http.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 随机产生日期+uuid
 * 
 * 
 * 
 */
public class UUIDTool {

	public static String getUUID(){
        UUID uuid=UUID.randomUUID();
        String str = uuid.toString(); 
        String uuidStr=str.replace("-", "");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String dateStr = sdf.format(new Date());
        return dateStr+uuidStr;
      }
	
	public static void main(String[] args) {
		System.out.println(getUUID());
	}
}
