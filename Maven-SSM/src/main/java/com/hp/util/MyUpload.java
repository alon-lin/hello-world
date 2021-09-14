package com.hp.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class MyUpload {
	
	public  static String getNewName(String oldname) {
		String result = "";
		String lastname = oldname.substring(oldname.lastIndexOf("."));
		Date d = new Date();
		SimpleDateFormat ff = new SimpleDateFormat("yyyyMMddHHmmss");
		String time = ff.format(d);
		Random r = new Random();
		int num = r.nextInt(99999999);
		result = time + num + lastname;
		return result;
	}

}
