package cn.fjlcx.office.controller.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import cn.fjlcx.office.bean.Result;
import cn.fjlcx.office.bean.User;
import cn.fjlcx.office.service.UserService;
import io.swagger.annotations.ApiOperation;

/**
 * Created by lcx on 2017/6/28.
 */
@RestController
public class UserInterface {
	@Autowired
	UserService mUserService;

	@RequestMapping(value = "getAllUser", method = RequestMethod.GET)
	@ApiOperation(value = "获取用户列表", notes = "获取用户列表")
	@ResponseBody
	public Object getAllUser() {
		List<User> list = mUserService.selectAllUser();
		return new Result("200","请求成功",list);
	}
}
