package cn.fjlcx.office.service;

import java.util.List;

import cn.fjlcx.office.bean.User;


/**
 * Created by lcx on 2017/6/27.
 */
public interface UserService {
	List<User> selectAllUser();
	User selectUserById(int us_id);
}
