package cn.fjlcx.office.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by lcx on 2017/6/28.
 */

public class Admin implements Serializable {
	private int adId;
	private String adLoginname;
	private String adPwd;
	private String adName;
	private String adMail;
	private int adType;
	private int adState;
	private Date adLastlogindate;
	private String adLastloginip;
	private Date adAdddate;

	public int getAdId() {
		return adId;
	}

	public void setAdId(int adId) {
		this.adId = adId;
	}

	public String getAdLoginname() {
		return adLoginname;
	}

	public void setAdLoginname(String adLoginname) {
		this.adLoginname = adLoginname;
	}

	public String getAdMail() {
		return adMail;
	}

	public void setAdMail(String adMail) {
		this.adMail = adMail;
	}

	public String getAdPwd() {
		return adPwd;
	}

	public void setAdPwd(String adPwd) {
		this.adPwd = adPwd;
	}

	public String getAdName() {
		return adName;
	}

	public void setAdName(String adName) {
		this.adName = adName;
	}

	public int getAdType() {
		return adType;
	}

	public void setAdType(int adType) {
		this.adType = adType;
	}

	public int getAdState() {
		return adState;
	}

	public void setAdState(int adState) {
		this.adState = adState;
	}

	public Date getAdLastlogindate() {
		return adLastlogindate;
	}

	public void setAdLastlogindate(Date adLastlogindate) {
		this.adLastlogindate = adLastlogindate;
	}

	public String getAdLastloginip() {
		return adLastloginip;
	}

	public void setAdLastloginip(String adLastloginip) {
		this.adLastloginip = adLastloginip;
	}

	public Date getAdAdddate() {
		return adAdddate;
	}

	public void setAdAdddate(Date adAdddate) {
		this.adAdddate = adAdddate;
	}

	public Admin() {
	}

	public Admin(int adId, String adLoginname, String adPwd, String adName, String adMail, int adType, int adState, Date adLastlogindate, String adLastloginip, Date adAdddate) {
		this.adId = adId;
		this.adLoginname = adLoginname;
		this.adPwd = adPwd;
		this.adName = adName;
		this.adMail = adMail;
		this.adType = adType;
		this.adState = adState;
		this.adLastlogindate = adLastlogindate;
		this.adLastloginip = adLastloginip;
		this.adAdddate = adAdddate;
	}

	public Admin(String adLoginname, String adPwd) {
		this.adLoginname = adLoginname;
		this.adPwd = adPwd;
	}

	@Override
	public String toString() {
		return "Admin{" +
				"adId=" + adId +
				", adLoginname='" + adLoginname + '\'' +
				", adPwd='" + adPwd + '\'' +
				", adName='" + adName + '\'' +
				", adType=" + adType +
				", adState=" + adState +
				", adLastlogindate=" + adLastlogindate +
				", adLastloginip='" + adLastloginip + '\'' +
				", adAdddate=" + adAdddate +
				'}';
	}
}