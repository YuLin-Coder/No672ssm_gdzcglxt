package com.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.ApplyxDAO;
import com.entity.Applyx;
import com.service.ApplyxService;

@Service("applyxService")
public class ApplyxServiceImpl implements ApplyxService {
	@Autowired
	private ApplyxDAO applyxDAO;
	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertApplyx(Applyx applyx) {
		return this.applyxDAO.insertApplyx(applyx);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updateApplyx(Applyx applyx) {
		return this.applyxDAO.updateApplyx(applyx);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deleteApplyx(String applyxid) {
		return this.applyxDAO.deleteApplyx(applyxid);
	}

	@Override // 继承接口的查询全部
	public List<Applyx> getAllApplyx() {
		return this.applyxDAO.getAllApplyx();
	}

	@Override // 继承接口的按条件精确查询
	public List<Applyx> getApplyxByCond(Applyx applyx) {
		return this.applyxDAO.getApplyxByCond(applyx);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Applyx> getApplyxByLike(Applyx applyx) {
		return this.applyxDAO.getApplyxByLike(applyx);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Applyx getApplyxById(String applyxid) {
		return this.applyxDAO.getApplyxById(applyxid);
	}

}

