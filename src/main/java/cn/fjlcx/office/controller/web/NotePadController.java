package cn.fjlcx.office.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import cn.fjlcx.office.bean.NotePad;
import cn.fjlcx.office.bean.PageBean;
import cn.fjlcx.office.service.NotePadService;

/**
 * Created by lcx on 2017/7/2 0002.
 */
@Controller
@RequestMapping("admin/notepad")
public class NotePadController {
	@Autowired
	NotePadService mNotePadService;

	@RequestMapping(value = "getNotePads",method= RequestMethod.GET)
	public String getNotePads(@RequestParam(value = "currentPage", required=true,defaultValue="1")Integer currentPage ,Model model){
		int count = mNotePadService.countAllNotePad();
		PageBean<NotePad> pageBean =new PageBean(count,10,currentPage);
		List<NotePad> list = mNotePadService.selectNotePadByPager(pageBean);
		pageBean.setList(list);
		model.addAttribute("page",pageBean);
		return "admin/notepad/notepad_list";
	}

	@RequestMapping(value = "showNotePad",method= RequestMethod.GET)
	public String showNotePad(@RequestParam(value = "npId", required=true)Integer npId ,Model model){
		NotePad np = mNotePadService.selectNotePadById(npId);
		model.addAttribute("notepad",np);
		return "admin/notepad/notepad_show";
	}

}
