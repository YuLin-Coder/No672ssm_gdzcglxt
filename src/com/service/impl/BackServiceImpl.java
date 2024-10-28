package com.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.BackDAO;
import com.entity.Back;
import com.service.BackService;

@Service("backService")
public class BackServiceImpl implements BackService {
	@Autowired
	private BackDAO backDAO;
	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertBack(Back back) {
		return this.backDAO.insertBack(back);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updateBack(Back back) {
		return this.backDAO.updateBack(back);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deleteBack(String backid) {
		return this.backDAO.deleteBack(backid);
	}

	@Override // 继承接口的查询全部
	public List<Back> getAllBack() {
		return this.backDAO.getAllBack();
	}

	@Override // 继承接口的按条件精确查询
	public List<Back> getBackByCond(Back back) {
		return this.backDAO.getBackByCond(back);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Back> getBackByLike(Back back) {
		return this.backDAO.getBackByLike(back);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Back getBackById(String backid) {
		return this.backDAO.getBackById(backid);
	}

}

