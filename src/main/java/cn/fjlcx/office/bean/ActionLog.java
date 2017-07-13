package cn.fjlcx.office.bean;

/**
 * Created by lcx on 2017/7/12.
 */

public class ActionLog {
	private int alId;
	private int alAdminId;
	private String alController;
	private String alMethod;
	private String alParams;
	private String alUri;
	private long alCostTime;
	private long alDate;
	private Admin admin;

	public int getAlAdminId() {
		return alAdminId;
	}

	public void setAlAdminId(int alAdminId) {
		this.alAdminId = alAdminId;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public int getAlId() {
		return alId;
	}

	public void setAlId(int alId) {
		this.alId = alId;
	}

	public String getAlController() {
		return alController;
	}

	public void setAlController(String alController) {
		this.alController = alController;
	}

	public String getAlMethod() {
		return alMethod;
	}

	public void setAlMethod(String alMethod) {
		this.alMethod = alMethod;
	}

	public String getAlParams() {
		return alParams;
	}

	public void setAlParams(String alParams) {
		this.alParams = alParams;
	}

	public String getAlUri() {
		return alUri;
	}

	public void setAlUri(String alUri) {
		this.alUri = alUri;
	}

	public long getAlCostTime() {
		return alCostTime;
	}

	public void setAlCostTime(long alCostTime) {
		this.alCostTime = alCostTime;
	}

	public long getAlDate() {
		return alDate;
	}

	public void setAlDate(long alDate) {
		this.alDate = alDate;
	}

	public ActionLog() {
	}

	public ActionLog(int alId, int alAdminId, String alController, String alMethod, String alParams, String alUri, long alCostTime, long alDate, Admin admin) {
		this.alId = alId;
		this.alAdminId = alAdminId;
		this.alController = alController;
		this.alMethod = alMethod;
		this.alParams = alParams;
		this.alUri = alUri;
		this.alCostTime = alCostTime;
		this.alDate = alDate;
		this.admin = admin;
	}
}
