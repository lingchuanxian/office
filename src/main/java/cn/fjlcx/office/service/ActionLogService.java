package cn.fjlcx.office.service;

import java.util.List;
import java.util.Map;

import cn.fjlcx.office.bean.ActionLog;

/**
 * Created by lcx on 2017/6/27.
 */
public interface ActionLogService {
	int insertActionLog(ActionLog actionLog);
	int deleteActionLog(int alId);
	int countActionLog(Map<String,Object> map);
	List<ActionLog> selectActionLogByPager(Map<String,Object> map);
}
