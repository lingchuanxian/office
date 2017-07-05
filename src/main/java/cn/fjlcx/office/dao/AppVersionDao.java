package cn.fjlcx.office.dao;

import java.util.List;

import cn.fjlcx.office.bean.AppVersion;
import cn.fjlcx.office.bean.PageBean;


/**
 * Created by lcx on 2017/6/27.
 */

public interface AppVersionDao {
	int insertAppVersion(AppVersion appVersion);
	int countAllAppVersion();
	List<AppVersion> selectAppVersionByPager(PageBean pageBean);
	AppVersion selectAppVersionById(int avId);
	int deleteAppVersionById(int avId);
	int updateAppVersion(AppVersion appVersion);
	AppVersion selectAppVersionIdMax();
}
