package cn.bdqn.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * ǩ��
 * @author �ο���
 *
 */
public final class MD5Util {
	public static String encode(String text) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] result = md.digest(text.getBytes()); // ���ı�����ǩ��
            // b
            // 000000..0000011111111
            StringBuilder sb = new StringBuilder();
            for (byte b : result) {
                int i = b & 0xff ; // ȡ�ֽڵĺ��λ��Чֵ
                String s = Integer.toHexString(i);
                if (s.length() < 2) {
                    s = "0" + s;
                }
                sb.append(s);
            }
            
            // ���ܵĽ��
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            // �Ҳ������㷨,һ�㲻���������
            throw new RuntimeException(e);
        }
    }
}
