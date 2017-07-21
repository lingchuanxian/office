package cn.fjlcx.office.controller.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.fjlcx.office.bean.AppVersion;
import cn.fjlcx.office.bean.HttpResult;
import cn.fjlcx.office.service.AppVersionService;

/**
 * Created by lcx on 2017/7/2 0002.
 */
@Controller
@RequestMapping("webservice/appversion")
public class AppVersionInterface {
	@Autowired
	AppVersionService mAppVersionService;

	@RequestMapping(value = "getLastVersion", method= RequestMethod.GET)
	@ResponseBody
	public HttpResult getLastVersion(){
		AppVersion appVersion = mAppVersionService.selectAppVersionIdMax();
		return HttpResult.setReturnCode(100).addResult(appVersion);
	}
}
