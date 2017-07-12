package cn.fjlcx.office.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import cn.fjlcx.office.bean.AppVersion;
import cn.fjlcx.office.bean.PageBean;
import cn.fjlcx.office.service.AppVersionService;

/**
 * Created by lcx on 2017/7/2 0002.
 */
@Controller
@RequestMapping("admin/appversion")
public class AppVersionController {
	@Autowired
	AppVersionService mAppVersionService;

    @RequestMapping(value = "getAppVersionAll", method= RequestMethod.GET)
    public String getAppVersionAll(@RequestParam(value = "currentPage", required=true,defaultValue="1")Integer currentPage , Model model){
		int count = mAppVersionService.countAllAppVersion();
    	PageBean<AppVersion> pageBean =new PageBean(count,10,currentPage);
        List<AppVersion> list = mAppVersionService.selectAppVersionByPager(pageBean);
        pageBean.setList(list);
        model.addAttribute("page",pageBean);
        return "admin/appversion/appversion_list";
    }

}
