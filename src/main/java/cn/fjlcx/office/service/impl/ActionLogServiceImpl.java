package cn.fjlcx.office.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import cn.fjlcx.office.bean.ActionLog;
import cn.fjlcx.office.dao.ActionLogDao;
import cn.fjlcx.office.service.ActionLogService;

/**
 * Created by lcx on 2017/7/13.
 */
@Service("ActionLogService")
class ActionLogServiceImpl implements ActionLogService {
	@Autowired
	ActionLogDao mActionLogDao;
	@Override
	public int insertActionLog(ActionLog actionLog) {
		return mActionLogDao.insertActionLog(actionLog);
	}

	@Override
	public int deleteActionLog(int alId) {
		return mActionLogDao.deleteActionLog(alId);
	}

	@Override
	public int countActionLog(Map<String, Object> map) {
		return mActionLogDao.countActionLog(map);
	}

	@Override
	public List<ActionLog> selectActionLogByPager(Map<String, Object> map) {
		return mActionLogDao.selectActionLogByPager(map);
	}
}
