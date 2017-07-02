package cn.fjlcx.office.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lcx on 2017/6/28.
 */

public class Result{
	private int code;//100--成功 101--失败 102--验证码已失效,请刷新页面后重试 103--验证码输入有误
	private String msg;
	private Map<String,Object> data = new HashMap<String,Object>();

	public static Result success(){
		Result result = new Result();
		result.setCode(100);
		result.setMsg("Success");
		return result;
	}

	public static Result fail(){
		Result result = new Result();
		result.setCode(101);
		result.setMsg("fail");
		return result;
	}

	public Result add(String key,Object value){
		this.getData().put(key,value);
		return this;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}
}
