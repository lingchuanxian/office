package cn.fjlcx.office.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import cn.fjlcx.office.bean.HttpResult;
import cn.fjlcx.office.bean.NotePad;
import cn.fjlcx.office.bean.PageBean;
import cn.fjlcx.office.service.NotePadService;

/**
 * Created by lcx on 2017/7/2 0002.
 */
@Controller
@RequestMapping("notepad")
public class NotePadController {
	@Autowired
	NotePadService mNotePadService;

	@RequestMapping(value = "getNotePad",method= RequestMethod.GET)
	@ResponseBody
	public HttpResult getNotePad(@RequestParam(value = "currentPage", required=true,defaultValue="1")Integer currentPage){
		int count = mNotePadService.countAllNotePad();
		PageBean<NotePad> pageBean =new PageBean(count,10,currentPage);
		List<NotePad> list = mNotePadService.selectNotePadByPager(pageBean);
		pageBean.setList(list);
		return HttpResult.success().addResult(pageBean);
	}
}
