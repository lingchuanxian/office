package cn.fjlcx.office.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import cn.fjlcx.office.bean.Admin;
import cn.fjlcx.office.bean.Result;
import cn.fjlcx.office.bean.User;
import cn.fjlcx.office.global.MemoryData;
import cn.fjlcx.office.service.AdminService;
import cn.fjlcx.office.service.UserService;
import cn.fjlcx.office.utils.MD5Util;
import cn.fjlcx.office.utils.StringRandom;
import io.swagger.annotations.ApiOperation;

/**
 * Created by lcx on 2017/6/28.
 */
@Controller
class CommonController {
	@Autowired
	HttpSession session;
	@Autowired
	AdminService mAdminService;
	@Autowired
	UserService mUserService;

	/**
	 * 跳转至登陆页面
	 * @param model
	 * @return
	 * @throws IOException
	 */

	@RequestMapping(value = "login", method = {RequestMethod.GET })
	public String login(Model model,String msg) throws IOException {
		String code = StringRandom.getInstance().getStringRandom(4);
		session.setAttribute("admin_login_code",code);
		model.addAttribute("code",code);
		System.out.println("msg:"+msg);
		model.addAttribute("msg",msg);
		return "login";
	}

/**
	 * 管理员登录
	 * @param
	 * @return
	 */

	@ResponseBody
	@RequestMapping(value = "admin/admin_login" , method = {RequestMethod.POST } )
	public Object admin_login(@RequestBody Admin admin){//使用adName暂时存登录验证码
		System.out.println("admin:"+admin.toString());
		Result result;
		String ss_code = session.getAttribute("admin_login_code").toString().toLowerCase();
		if (ss_code.equals("")){
			result = Result.fail();
		}else if(!ss_code.equals(admin.getAdName().toLowerCase())){
			result = Result.fail();
		}else{
			admin.setAdPwd(MD5Util.MD5(MD5Util.MD5(MD5Util.MD5(admin.getAdPwd()))));
			Admin loginAdmin = mAdminService.adminLogin(admin);
			if(loginAdmin!=null){
				session.setAttribute("admin_login_account",loginAdmin);

				String sessionID = session.getId();
				if (!MemoryData.getSessionIDMap().containsKey(loginAdmin.getAdId())) { //不存在，首次登陆，放入Map
					MemoryData.getSessionIDMap().put(loginAdmin.getAdId(),sessionID);
				}else if(MemoryData.getSessionIDMap().containsKey(loginAdmin.getAdId())&&!MemoryData.getSessionIDMap().get(loginAdmin.getAdId()).equals(sessionID)){
					MemoryData.getSessionIDMap().remove(loginAdmin.getAdId());
					MemoryData.getSessionIDMap().put(loginAdmin.getAdId(), sessionID);
				}

				result = Result.success().add("loginAdmin",loginAdmin);
			}else{
				result = Result.fail();
			}
		}
		System.out.println("result:"+result.toString());
		return result;
	}

	@RequestMapping(value = "index")
	public String index(){
		return "admin/main";
	}

	@RequestMapping(value = "logout")
	public String logout(){
		Admin admin = (Admin) session.getAttribute("admin_login_account");
		session.invalidate();
		if(MemoryData.getSessionIDMap().containsKey(admin.getAdId())){
			MemoryData.getSessionIDMap().remove(admin.getAdId());
		}
		return "redirect:login.shtml";
	}

	@RequestMapping(value = "home")
	public String home(){
		return "admin/home";
	}

	/**
	 * 用户列表
	 * @param pn
	 * @param model
	 * @return
	 */
	@ApiOperation(value="获取用户列表", notes="")
	@RequestMapping(value = "userlist",method=RequestMethod.GET)
	@ResponseBody
	public Object userList(@RequestParam(value = "pn",defaultValue = "1")Integer pn,Model model){
		PageHelper.startPage(pn,5);
		List<User> list = mUserService.selectAllUser();
		PageInfo page = new PageInfo(list,5);
		return Result.success().add("list",page);
	}
}
