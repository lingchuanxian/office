package cn.fjlcx.office.bean;

/**
 * Created by lcx on 2017/7/3.
 */

import java.util.ArrayList;
import java.util.List;

public class PageBean<T> {
	private Integer totalCount;//总记录数
	private Integer pageLine;//每页查询记录数
	private Integer currentPage;//当前页码
	private Integer pageNum;//总页数
	private Integer start;//查询起始点
	private Integer end;//查询结束点

	private List<T> list;//查询的结果封装集合
	public PageBean(){
	}

	public PageBean(Integer totalCount, Integer pageLine, Integer currentPage, Integer pageNum, Integer start, Integer end, List<T> list) {
		this.totalCount = totalCount;
		this.pageLine = pageLine;
		this.currentPage = currentPage;
		this.pageNum = pageNum;
		this.start = start;
		this.end = end;
		this.list = list;
	}


	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getPageLine() {
		return pageLine;
	}
	public void setPageLine(Integer pageLine) {
		this.pageLine = pageLine;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public Integer getEnd() {
		return end;
	}
	public void setEnd(Integer end) {
		this.end = end;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		String rn = "\r\n";
		String sp = ":";
		String sp1 = " ";
		//打印结果
		String info = "记录如下"+sp+rn;
		if(null == list){
			this.setList(new ArrayList<T>());
		}
		for(int x = 0;x<list.size();x++){
			info += "记录"+x + sp + list.get(x).toString() + rn;
		}
		info += "总记录数："+this.getTotalCount()+ sp1;
		info += "总页数："+this.getPageNum()+ rn;
		info += "当前页："+this.getCurrentPage()+ sp1;
		info += "每页数："+this.getPageLine()+ rn;
		info += "start:"+this.getStart()+ sp1;
		info += "end:"+this.getEnd();
		return info;
	}

}