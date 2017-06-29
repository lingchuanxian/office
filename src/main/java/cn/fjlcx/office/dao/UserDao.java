package cn.fjlcx.office.dao;

import java.util.List;

import cn.fjlcx.office.bean.User;


/**
 * Created by lcx on 2017/6/27.
 */

public interface UserDao {
	List<User> selectAllUser();
	User selectUserById(int us_id);
}
