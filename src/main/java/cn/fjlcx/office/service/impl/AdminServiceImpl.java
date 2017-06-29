package cn.fjlcx.office.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.fjlcx.office.bean.Admin;
import cn.fjlcx.office.dao.AdminDao;
import cn.fjlcx.office.service.AdminService;

/**
 * Created by lcx on 2017/6/28.
 */
@Service("AdminService")
class AdminServiceImpl implements AdminService {
	@Autowired
	AdminDao mAdminDao;
	public Admin adminLogin(Admin admin) {
		return mAdminDao.adminLogin(admin);
	}
}
