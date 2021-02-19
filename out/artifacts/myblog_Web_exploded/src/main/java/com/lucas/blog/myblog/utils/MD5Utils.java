package com.lucas.blog.myblog.utils;


import java.security.MessageDigest;



/**
 * @ProjectName: myblog
 * @Package: com.heyuanhui.blog.myblog.utils
 * @ClassName: MD5Utils
 * @Author: Heyuanhui
 * @Description: ${实现MD加密  对密码进行验证}
		* @Date: 2019/9/4 17:10
		* @Version: 1.0
		*/
public class MD5Utils {

	private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5",
			"6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

	/**
	 * MD5 password
	 *
	 *
	 * @param inputString
	 * @return   一个MD5加密之后的密码
	 */


	public static String generatePassword(String inputString) {
		return encodeByMD5(inputString);
	}

	/**
	 * validate password
	 *
	 * @param password
	 * @param inputString
	 * @return
	 */
	public static boolean validatePassword(String password, String inputString) {
		if (password.equals(encodeByMD5(inputString))) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * encode
	 *
	 * @param originString
	 * @return
	 */
	private static String encodeByMD5(String originString) {
		if (originString != null) {
			try {
				MessageDigest md = MessageDigest.getInstance("MD5");
				byte[] results = md.digest(originString.getBytes());
				String resultString = byteArrayToHexString(results);
				return resultString.toUpperCase();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * change the Byte[] to hex string
	 *
	 * @param b
	 * @return
	 */
	private static String byteArrayToHexString(byte[] b) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			resultSb.append(byteToHexString(b[i]));
		}
		return resultSb.toString();
	}

	/**
	 * change a byte to hex string
	 *
	 * @param b
	 * @return
	 */
	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0)
			n = 256 + n;
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}

	public static void main(String[] args) {

		MD5Utils md5Utils = new MD5Utils();

		String pw1="admin123456";

		String pwd2 = md5Utils.generatePassword(pw1);
		System.out.println("加密�?" + pwd2);


	}

}



