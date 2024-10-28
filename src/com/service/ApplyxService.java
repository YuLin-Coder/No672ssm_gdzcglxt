package com.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Applyx;
@Service("applyxService")
public interface ApplyxService {
	// 插入数据 调用applyxDAO里的insertApplyx配置
	public int insertApplyx(Applyx applyx);

	// 更新数据 调用applyxDAO里的updateApplyx配置
	public int updateApplyx(Applyx applyx);

	// 删除数据 调用applyxDAO里的deleteApplyx配置
	public int deleteApplyx(String applyxid);

	// 查询全部数据 调用applyxDAO里的getAllApplyx配置
	public List<Applyx> getAllApplyx();

	// 按照Applyx类里面的字段名称精确查询 调用applyxDAO里的getApplyxByCond配置
	public List<Applyx> getApplyxByCond(Applyx applyx);

	// 按照Applyx类里面的字段名称模糊查询 调用applyxDAO里的getApplyxByLike配置
	public List<Applyx> getApplyxByLike(Applyx applyx);

	// 按主键查询表返回单一的Applyx实例 调用applyxDAO里的getApplyxById配置
	public Applyx getApplyxById(String applyxid);

}

