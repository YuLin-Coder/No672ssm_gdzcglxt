package com.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Lend;
@Service("lendService")
public interface LendService {
	// 插入数据 调用lendDAO里的insertLend配置
	public int insertLend(Lend lend);

	// 更新数据 调用lendDAO里的updateLend配置
	public int updateLend(Lend lend);

	// 删除数据 调用lendDAO里的deleteLend配置
	public int deleteLend(String lendid);

	// 查询全部数据 调用lendDAO里的getAllLend配置
	public List<Lend> getAllLend();

	// 按照Lend类里面的字段名称精确查询 调用lendDAO里的getLendByCond配置
	public List<Lend> getLendByCond(Lend lend);

	// 按照Lend类里面的字段名称模糊查询 调用lendDAO里的getLendByLike配置
	public List<Lend> getLendByLike(Lend lend);

	// 按主键查询表返回单一的Lend实例 调用lendDAO里的getLendById配置
	public Lend getLendById(String lendid);

}

