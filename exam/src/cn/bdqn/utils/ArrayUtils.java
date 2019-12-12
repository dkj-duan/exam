package cn.bdqn.utils;

/***
 * 	数组工具类
*/
public final class ArrayUtils {

	private ArrayUtils(){
		
	}
	
	// 将一个数组转换成一个字符串
	public static String  array2string(String[] arrs){
		StringBuilder sb = new StringBuilder();
		if(arrs != null && arrs.length > 0){
			for(String arr : arrs){
				sb.append(arr).append(",");
			}
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb.toString();
	}
}
