package cn.fjlcx.office.dao;

import java.util.List;

import cn.fjlcx.office.bean.NotePad;
import cn.fjlcx.office.bean.PageBean;

/**
 * Created by lcx on 2017/7/2 0002.
 */

public interface NotePadDao {
	int insertNotePad(NotePad notePad);
	int countAllNotePad();
	List<NotePad> selectNotePadByPager(PageBean pageBean);
	NotePad selectNotePadById(int npId);
	int deleteNotePadById(int npId);
	int updateNotePad(NotePad notePad);
	int setNotePadToTop(NotePad notePad);
}
