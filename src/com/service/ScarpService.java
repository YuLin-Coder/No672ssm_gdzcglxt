package com.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Scarp;
@Service("scarpService")
public interface ScarpService {
	// 插入数据 调用scarpDAO里的insertScarp配置
	public int insertScarp(Scarp scarp);

	// 更新数据 调用scarpDAO里的updateScarp配置
	public int updateScarp(Scarp scarp);

	// 删除数据 调用scarpDAO里的deleteScarp配置
	public int deleteScarp(String scarpid);

	// 查询全部数据 调用scarpDAO里的getAllScarp配置
	public List<Scarp> getAllScarp();

	// 按照Scarp类里面的字段名称精确查询 调用scarpDAO里的getScarpByCond配置
	public List<Scarp> getScarpByCond(Scarp scarp);

	// 按照Scarp类里面的字段名称模糊查询 调用scarpDAO里的getScarpByLike配置
	public List<Scarp> getScarpByLike(Scarp scarp);

	// 按主键查询表返回单一的Scarp实例 调用scarpDAO里的getScarpById配置
	public Scarp getScarpById(String scarpid);

}

