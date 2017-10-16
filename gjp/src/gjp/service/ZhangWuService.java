package gjp.service;

import java.util.List;

import gip.domain.ZhangWu;
import gjp.dao.ZhangWuDao;

/*
 * hangWuService类添加一个类型为ZhangWuDao的成员变量，
 * 因为service依赖dao
 */

public class ZhangWuService {
	private ZhangWuDao dao = new ZhangWuDao();

	public List<ZhangWu> selectAll() {
		return dao.selectAll();
	}

	public List<ZhangWu> select(String start, String end) {
		return dao.select(start, end);
	}

	public void addZhangWu(ZhangWu zw) {
		dao.addZhangWu(zw);
	}

	public void editZhangWu(ZhangWu zw) {
		dao.editZhangWu(zw);
	}

	public void deleteZhangWu(int zwid) {
		dao.deleteZhangWu(zwid);
	}
}
