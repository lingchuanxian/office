package cn.fjlcx.office.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import cn.fjlcx.office.bean.User;
import cn.fjlcx.office.dao.UserDao;
import cn.fjlcx.office.service.UserService;

/**
 * Created by lcx on 2017/6/27.
 */
@Service("UserService")
class UserServiceImpl implements UserService {
	@Autowired
	UserDao mUserDao;
	public List<User> selectAllUser() {
		return mUserDao.selectAllUser();
	}

	public User selectUserById(int us_id) {
		return mUserDao.selectUserById(us_id);
	}
}
