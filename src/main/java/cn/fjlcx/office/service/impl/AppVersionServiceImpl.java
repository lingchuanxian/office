package cn.fjlcx.office.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import cn.fjlcx.office.bean.AppVersion;
import cn.fjlcx.office.bean.PageBean;
import cn.fjlcx.office.dao.AppVersionDao;
import cn.fjlcx.office.service.AppVersionService;

/**
 * Created by lcx on 2017/7/5 0005.
 */
@Service("AppVersionService")
class AppVersionServiceImpl implements AppVersionService {
    @Autowired
    AppVersionDao mAppVersionDao;
    @Override
    public int insertAppVersion(AppVersion appVersion) {
        return mAppVersionDao.insertAppVersion(appVersion);
    }

    @Override
    public int countAllAppVersion() {
        return mAppVersionDao.countAllAppVersion();
    }

    @Override
    public List<AppVersion> selectAppVersionByPager(PageBean pageBean) {
        return mAppVersionDao.selectAppVersionByPager(pageBean);
    }

    @Override
    public AppVersion selectAppVersionById(int avId) {
        return mAppVersionDao.selectAppVersionById(avId);
    }

    @Override
    public int deleteAppVersionById(int avId) {
        return mAppVersionDao.deleteAppVersionById(avId);
    }

    @Override
    public int updateAppVersion(AppVersion appVersion) {
        return mAppVersionDao.updateAppVersion(appVersion);
    }

    @Override
    public AppVersion selectAppVersionIdMax() {
        return mAppVersionDao.selectAppVersionIdMax();
    }
}
