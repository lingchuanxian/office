package cn.fjlcx.office.global;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lcx on 2017/6/29.
 */

public class MemoryData {
	private static Map<Integer,String> sessionIDMap = new HashMap<Integer,String>();
	public static Map<Integer,String> getSessionIDMap() {
		return sessionIDMap;
	}

	public static void setSessionIDMap(Map<Integer,String> sessionIDMap) {
		MemoryData.sessionIDMap = sessionIDMap;
	}
}
