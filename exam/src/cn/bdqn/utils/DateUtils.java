package cn.bdqn.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/****
 *		日期工具类 
*/
public final class DateUtils {

	private DateUtils(){
		
	}
	
	// 将字符串转日期
	public static Date string2date(String value){
		if(value != null && !"".equals(value.trim())){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd MM:hh:ss");
			Date date = null;
			try {
				date = sdf.parse(value);
			} catch (ParseException e) {
				throw new RuntimeException();
			}
			return date;
		}
		return null;
	}
	
	// 将日期转字符串
	
}
