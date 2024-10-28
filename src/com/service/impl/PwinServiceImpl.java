package com.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.PwinDAO;
import com.entity.Pwin;
import com.service.PwinService;

@Service("pwinService")
public class PwinServiceImpl implements PwinService {
	@Autowired
	private PwinDAO pwinDAO;
	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertPwin(Pwin pwin) {
		return this.pwinDAO.insertPwin(pwin);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updatePwin(Pwin pwin) {
		return this.pwinDAO.updatePwin(pwin);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deletePwin(String pwinid) {
		return this.pwinDAO.deletePwin(pwinid);
	}

	@Override // 继承接口的查询全部
	public List<Pwin> getAllPwin() {
		return this.pwinDAO.getAllPwin();
	}

	@Override // 继承接口的按条件精确查询
	public List<Pwin> getPwinByCond(Pwin pwin) {
		return this.pwinDAO.getPwinByCond(pwin);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Pwin> getPwinByLike(Pwin pwin) {
		return this.pwinDAO.getPwinByLike(pwin);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Pwin getPwinById(String pwinid) {
		return this.pwinDAO.getPwinById(pwinid);
	}

}

