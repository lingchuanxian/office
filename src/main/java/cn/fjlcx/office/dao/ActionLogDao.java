package cn.fjlcx.office.dao;

import java.util.List;
import java.util.Map;

import cn.fjlcx.office.bean.ActionLog;

/**
 * Created by lcx on 2017/7/13.
 */

public interface ActionLogDao {
	int insertActionLog(ActionLog actionLog);
	int deleteActionLog(int alId);
	int countActionLog(Map<String,Object> map);
	List<ActionLog> selectActionLogByPager(Map<String,Object> map);
}
