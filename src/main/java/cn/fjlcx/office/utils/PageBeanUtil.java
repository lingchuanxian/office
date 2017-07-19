package cn.fjlcx.office.utils;

import cn.fjlcx.office.bean.PageBean;

/**
 * Created by lcx on 2017/7/18.
 */

public class PageBeanUtil {
	public static PageBean setPageBean(Integer totalCount, Integer pageLine, Integer currentPage){
		PageBean pageBean = new PageBean();
		pageBean.setTotalCount(totalCount);
		pageBean.setPageLine(pageLine);
		pageBean.setPageNum((totalCount-1)/pageBean.getPageLine()+1);
		pageBean.setCurrentPage((currentPage<=0 ? 1: (currentPage > pageBean.getPageNum())?pageBean.getPageNum():currentPage));
		pageBean.setStart((pageBean.getCurrentPage()-1)*pageBean.getPageLine());
		return pageBean;
	}
}
