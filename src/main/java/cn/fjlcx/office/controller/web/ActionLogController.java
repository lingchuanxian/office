package cn.fjlcx.office.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.fjlcx.office.bean.ActionLog;
import cn.fjlcx.office.bean.PageBean;
import cn.fjlcx.office.service.ActionLogService;

/**
 * Created by lcx on 2017/7/13.
 */
@Controller
@RequestMapping("admin/actionlog")
public class ActionLogController {
	@Autowired
	ActionLogService mActionLogService;

	@RequestMapping(value = "getActionLog",method= RequestMethod.GET)
	public String getActionLog(@RequestParam(value = "currentPage", required=true,defaultValue="1")Integer currentPage , Model model){
		Map<String,Object> map = new HashMap<>();
		int count = mActionLogService.countActionLog(map);
		PageBean<ActionLog> pageBean =new PageBean(count,10,currentPage);
		map.put("start",pageBean.getStart());
		map.put("pageLine",pageBean.getPageLine());
		List<ActionLog> list = mActionLogService.selectActionLogByPager(map);
		pageBean.setList(list);
		model.addAttribute("page",pageBean);
		return "admin/actionlog/actionlog_list";
	}
}
