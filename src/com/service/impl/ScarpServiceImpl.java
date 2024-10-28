package com.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.ScarpDAO;
import com.entity.Scarp;
import com.service.ScarpService;

@Service("scarpService")
public class ScarpServiceImpl implements ScarpService {
	@Autowired
	private ScarpDAO scarpDAO;
	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertScarp(Scarp scarp) {
		return this.scarpDAO.insertScarp(scarp);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updateScarp(Scarp scarp) {
		return this.scarpDAO.updateScarp(scarp);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deleteScarp(String scarpid) {
		return this.scarpDAO.deleteScarp(scarpid);
	}

	@Override // 继承接口的查询全部
	public List<Scarp> getAllScarp() {
		return this.scarpDAO.getAllScarp();
	}

	@Override // 继承接口的按条件精确查询
	public List<Scarp> getScarpByCond(Scarp scarp) {
		return this.scarpDAO.getScarpByCond(scarp);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Scarp> getScarpByLike(Scarp scarp) {
		return this.scarpDAO.getScarpByLike(scarp);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Scarp getScarpById(String scarpid) {
		return this.scarpDAO.getScarpById(scarpid);
	}

}

