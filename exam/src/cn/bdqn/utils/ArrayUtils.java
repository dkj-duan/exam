package cn.bdqn.utils;

/***
 * 	���鹤����
*/
public final class ArrayUtils {

	private ArrayUtils(){
		
	}
	
	// ��һ������ת����һ���ַ���
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
