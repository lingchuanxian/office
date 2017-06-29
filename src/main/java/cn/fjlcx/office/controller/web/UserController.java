package cn.fjlcx.office.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import cn.fjlcx.office.service.UserService;

/**
 * Created by lcx on 2017/6/27.
 */
@Controller
class UserController {
	@Autowired
	UserService mUserService;

	/*@RequestMapping(value = "getAllUser", method = RequestMethod.GET)
	public Object user() {
		List<User> list = mUserService.selectAllUser();
		return new Result("200","请求成功",list);
	}*/
}
