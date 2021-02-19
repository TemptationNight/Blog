package com.lucas.blog.myblog.utils;/**
 * @ProjectName: myblog
 * @Package: com.lucas.blog.myblog.utils
 * @ClassName: DateUtils
 * @Author: Heyuanhui
 * @Description: ${description}
 * @Date: 2019/10/31 15:47
 * @Version: 1.0
 */

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: myblog
 *
 * @ClassName: DateUtils

 *
 * @author: Lucas
 *
 * @create: 2019-10-31 15:47
 **/


public class DateUtils {



	//实现ate类型转换成String类型
	public static  String dateToString(Date date){
		DateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sf.format(date);
	}

	//实现String类型传唤成Date类型
	public static  Date stringToDate(String  date){
		DateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
		Date date1=null;
		try {
			date1=sf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return  date1;
	}
}
