package cn.fjlcx.office.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import cn.fjlcx.office.bean.NotePad;
import cn.fjlcx.office.bean.PageBean;
import cn.fjlcx.office.dao.NotePadDao;
import cn.fjlcx.office.service.NotePadService;

/**
 * Created by lcx on 2017/7/2 0002.
 */
@Service("NotePadService")
class NotePadServiceImpl implements NotePadService {
	@Autowired
	NotePadDao mNotePadDao;
	public int insertNotePad(NotePad notePad) {
		return mNotePadDao.insertNotePad(notePad);
	}

	@Override
	public int countAllNotePad() {
		return mNotePadDao.countAllNotePad();
	}

	@Override
	public List<NotePad> selectNotePadByPager(PageBean pageBean) {
		return mNotePadDao.selectNotePadByPager(pageBean);
	}

	public NotePad selectNotePadById(int npId) {
		return mNotePadDao.selectNotePadById(npId);
	}

	public int deleteNotePadById(int npId) {
		return mNotePadDao.deleteNotePadById(npId);
	}

	public int updateNotePad(NotePad notePad) {
		return mNotePadDao.updateNotePad(notePad);
	}

	public int setNotePadToTop(NotePad notePad) {
		return mNotePadDao.setNotePadToTop(notePad);
	}
}
