package cn.fjlcx.office.utils;

import java.util.Random;

/**
 * Created by lcx on 2017/6/28.
 */

public class StringRandom {
	private static StringRandom mStringRandom;
	//获取StringRandom的实例
	public static StringRandom getInstance(){
		if(mStringRandom == null){
			mStringRandom = new StringRandom();
		}
		return mStringRandom;
	}
	//生成随机数字和字母,
	public String getStringRandom(int length) {

		String val = "";
		Random random = new Random();

		//参数length，表示生成几位随机数
		for(int i = 0; i < length; i++) {
			String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
			//输出字母还是数字
			if( "char".equalsIgnoreCase(charOrNum) ) {
				//输出是大写字母还是小写字母
				int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
				val += (char)(random.nextInt(26) + temp);
			} else if( "num".equalsIgnoreCase(charOrNum) ) {
				val += String.valueOf(random.nextInt(10));
			}
		}
		return val;
	}
}
