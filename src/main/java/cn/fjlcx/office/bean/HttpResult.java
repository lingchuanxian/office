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

	public static HttpResult setReturnCode(int code){
		httpResult = new HttpResult();
		httpResult.setCode(code);
		switch (code){
			case 100:
				httpResult.setMsg("请求成功");
				break;
			case 101:
				httpResult.setMsg("用户名或密码有误");
				break;
			case 102:
				httpResult.setMsg("查询数据库异常");
				break;
			case 103:
				httpResult.setMsg("验证码已失效");
				break;
			case 104:
				httpResult.setMsg("验证码输入有误");
				break;
			case 105:
				httpResult.setMsg("缺少必需参数");
				break;
			case 107:
				httpResult.setMsg("登录超时");
				break;
		}

		return httpResult;
	}

	public static HttpResult loginSuccess(String ticket) {
		httpResult = new HttpResult();
		httpResult.setCode(0);
		httpResult.setMsg(ticket);
		return httpResult;
	}

	public static HttpResult addResult(Object data){
		httpResult.setResult(data);
		return httpResult;
	}

	public HttpResult() {
	}
}
