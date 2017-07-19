package cn.fjlcx.office.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import cn.fjlcx.office.bean.NotePad;
import cn.fjlcx.office.bean.PageBean;
import cn.fjlcx.office.service.NotePadService;
import cn.fjlcx.office.utils.PageBeanUtil;

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
		PageBean<NotePad> pageBean = PageBeanUtil.setPageBean(count,10,currentPage);
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

	@RequestMapping(value = "toAddNotePad",method= RequestMethod.GET)
	public String toAddNotePad(){
		return "admin/notepad/notepad_add";
	}

	@RequestMapping(value = "updateNotePads",method= RequestMethod.POST)
	public String updateNotePads(@RequestBody NotePad notePad,Model model){
		notePad.setNpUpdatedate(System.currentTimeMillis());
		notePad.setNpAdddate(System.currentTimeMillis());
		notePad.setNpState(0);
		int val = mNotePadService.insertNotePad(notePad);
		return "redirect:getNotePads.shtml";
	}

}
