package cn.bdqn.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/****
 *		���ڹ����� 
*/
public final class DateUtils {

	private DateUtils(){
		
	}
	
	// ���ַ���ת����
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
	
	// ������ת�ַ���
	
}
