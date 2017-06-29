package cn.fjlcx.office.bean;

/**
 * Created by lcx on 2017/6/28.
 */

public class Result{
	private String code;
	private String description;
	private Object data;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Result(String code, String description, Object data) {
		super();
		this.code = code;
		this.description = description;
		this.data = data;
	}
	public Result() {
		super();
	}
	@Override
	public String toString() {
		return "Result [code=" + code + ", description=" + description + ", data=" + data + "]";
	}

}
