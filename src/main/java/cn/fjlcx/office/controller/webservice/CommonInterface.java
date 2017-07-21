package cn.fjlcx.office.controller.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

import cn.fjlcx.office.bean.HttpResult;
import cn.fjlcx.office.bean.User;
import cn.fjlcx.office.service.UserService;
import cn.fjlcx.office.utils.MD5Util;
import cn.fjlcx.office.utils.StringUtil;
import redis.clients.jedis.Jedis;

/**
 * Created by lcx on 2017/7/2 0002.
 */
@Controller
@RequestMapping("webservice/common")
public class CommonInterface {
	@Autowired
	HttpSession session;
	@Autowired
	UserService mUserService;

	@ResponseBody
	@RequestMapping(value = "login" , method = {RequestMethod.POST } )
	public HttpResult common_login(@RequestParam(value = "usLoginname", required=true)String usLoginname,@RequestParam(value = "usPwd", required=true)String usPwd){
		HttpResult result;
		if(StringUtil.isNullOrEmpty(usLoginname)||StringUtil.isNullOrEmpty(usPwd)){
			result = HttpResult.setReturnCode(105);
		}else{
			User user = new User();
			user.setUsLoginname(usLoginname);
			user.setUsPwd(usPwd);
			user.setUsPwd(MD5Util.MD5(MD5Util.MD5(MD5Util.MD5(user.getUsPwd()))));
			User loginUser = mUserService.userLogin(user);
			if(loginUser!=null){
				String originalTicket = loginUser.getUsId()+loginUser.getUsLoginname()+System.currentTimeMillis();
				String ticket = MD5Util.MD5(MD5Util.MD5(MD5Util.MD5(originalTicket)));
				Jedis jedis = new Jedis("localhost");
				jedis.set(ticket,loginUser.getUsId()+loginUser.getUsLoginname());
				jedis.expire(ticket,60 * 60);
				result = HttpResult.loginSuccess(ticket);
			}else {
				result = HttpResult.setReturnCode(101);
			}
		}
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "checkJWT" , method = {RequestMethod.GET } )
	public HttpResult common_checkJWT(@RequestParam(value = "ticket", required=true)String ticket){
		HttpResult result;
		boolean isValid = false;
		Jedis jedis = new Jedis("localhost");
		String val = jedis.get(ticket);
		if(val!=null){
			result = HttpResult.setReturnCode(100);
		}else{
			result = HttpResult.setReturnCode(107);
		}
		return result;
	}


}
