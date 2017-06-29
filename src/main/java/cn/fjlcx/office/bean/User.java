package cn.fjlcx.office.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by lcx on 2017/6/27.
 */

public class User implements Serializable {
	private int usId;
	private String usLoginname;
	private String usPwd;
	private String usHead;
	private String usName;
	private String usSex;
	private String usPhone;
	private String usMail;
	private String usAddress;
	private String usState;
	private Date usRegistdate;
	public int getUsId() {
		return usId;
	}
	public void setUsId(int usId) {
		this.usId = usId;
	}
	public String getUsLoginname() {
		return usLoginname;
	}
	public void setUsLoginname(String usLoginname) {
		this.usLoginname = usLoginname;
	}
	public String getUsPwd() {
		return usPwd;
	}
	public void setUsPwd(String usPwd) {
		this.usPwd = usPwd;
	}
	public String getUsHead() {
		return usHead;
	}
	public void setUsHead(String usHead) {
		this.usHead = usHead;
	}
	public String getUsName() {
		return usName;
	}
	public void setUsName(String usName) {
		this.usName = usName;
	}
	public String getUsSex() {
		return usSex;
	}
	public void setUsSex(String usSex) {
		this.usSex = usSex;
	}
	public String getUsPhone() {
		return usPhone;
	}
	public void setUsPhone(String usPhone) {
		this.usPhone = usPhone;
	}
	public String getUsMail() {
		return usMail;
	}
	public void setUsMail(String usMail) {
		this.usMail = usMail;
	}
	public String getUsAddress() {
		return usAddress;
	}
	public void setUsAddress(String usAddress) {
		this.usAddress = usAddress;
	}
	public String getUsState() {
		return usState;
	}
	public void setUsState(String usState) {
		this.usState = usState;
	}
	public Date getUsRegistdate() {
		return usRegistdate;
	}
	public void setUsRegistdate(Date usRegistdate) {
		this.usRegistdate = usRegistdate;
	}
	public User(String usLoginname, String usPwd, String usHead, String usName, String usSex, String usPhone,
				String usMail, String usAddress, String usState, Date usRegistdate) {
		super();
		this.usLoginname = usLoginname;
		this.usPwd = usPwd;
		this.usHead = usHead;
		this.usName = usName;
		this.usSex = usSex;
		this.usPhone = usPhone;
		this.usMail = usMail;
		this.usAddress = usAddress;
		this.usState = usState;
		this.usRegistdate = usRegistdate;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [usId=" + usId + ", usLoginname=" + usLoginname + ", usPwd=" + usPwd + ", usHead=" + usHead
				+ ", usName=" + usName + ", usSex=" + usSex + ", usPhone=" + usPhone + ", usMail=" + usMail
				+ ", usAddress=" + usAddress + ", usState=" + usState + ", usRegistdate=" + usRegistdate + "]";
	}

}