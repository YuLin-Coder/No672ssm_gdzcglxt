package com.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.LendDAO;
import com.entity.Lend;
import com.service.LendService;

@Service("lendService")
public class LendServiceImpl implements LendService {
	@Autowired
	private LendDAO lendDAO;
	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertLend(Lend lend) {
		return this.lendDAO.insertLend(lend);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updateLend(Lend lend) {
		return this.lendDAO.updateLend(lend);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deleteLend(String lendid) {
		return this.lendDAO.deleteLend(lendid);
	}

	@Override // 继承接口的查询全部
	public List<Lend> getAllLend() {
		return this.lendDAO.getAllLend();
	}

	@Override // 继承接口的按条件精确查询
	public List<Lend> getLendByCond(Lend lend) {
		return this.lendDAO.getLendByCond(lend);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Lend> getLendByLike(Lend lend) {
		return this.lendDAO.getLendByLike(lend);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Lend getLendById(String lendid) {
		return this.lendDAO.getLendById(lendid);
	}

}

