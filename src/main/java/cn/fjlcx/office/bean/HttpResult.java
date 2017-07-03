package cn.fjlcx.office.bean;

/**
 * Created by lcx on 2017/6/7.
 */

public class HttpResult<T> {
	private int code;
	private String msg;
	private T result;
	private static HttpResult httpResult;
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

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

	public static HttpResult success(){
		httpResult = new HttpResult();
		httpResult.setCode(100);
		httpResult.setMsg("Success");
		return httpResult;
	}

	public static HttpResult fail(){
		httpResult = new HttpResult();
		httpResult.setCode(101);
		httpResult.setMsg("fail");
		return httpResult;
	}

	public static HttpResult addResult(Object data){
		httpResult.setResult(data);
		return httpResult;
	}

	public HttpResult() {
	}
}
