package com.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.PlostDAO;
import com.entity.Plost;
import com.service.PlostService;

@Service("plostService")
public class PlostServiceImpl implements PlostService {
	@Autowired
	private PlostDAO plostDAO;
	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertPlost(Plost plost) {
		return this.plostDAO.insertPlost(plost);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updatePlost(Plost plost) {
		return this.plostDAO.updatePlost(plost);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deletePlost(String plostid) {
		return this.plostDAO.deletePlost(plostid);
	}

	@Override // 继承接口的查询全部
	public List<Plost> getAllPlost() {
		return this.plostDAO.getAllPlost();
	}

	@Override // 继承接口的按条件精确查询
	public List<Plost> getPlostByCond(Plost plost) {
		return this.plostDAO.getPlostByCond(plost);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Plost> getPlostByLike(Plost plost) {
		return this.plostDAO.getPlostByLike(plost);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Plost getPlostById(String plostid) {
		return this.plostDAO.getPlostById(plostid);
	}

}

