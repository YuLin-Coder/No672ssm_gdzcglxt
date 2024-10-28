package com.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Plost;
@Service("plostService")
public interface PlostService {
	// 插入数据 调用plostDAO里的insertPlost配置
	public int insertPlost(Plost plost);

	// 更新数据 调用plostDAO里的updatePlost配置
	public int updatePlost(Plost plost);

	// 删除数据 调用plostDAO里的deletePlost配置
	public int deletePlost(String plostid);

	// 查询全部数据 调用plostDAO里的getAllPlost配置
	public List<Plost> getAllPlost();

	// 按照Plost类里面的字段名称精确查询 调用plostDAO里的getPlostByCond配置
	public List<Plost> getPlostByCond(Plost plost);

	// 按照Plost类里面的字段名称模糊查询 调用plostDAO里的getPlostByLike配置
	public List<Plost> getPlostByLike(Plost plost);

	// 按主键查询表返回单一的Plost实例 调用plostDAO里的getPlostById配置
	public Plost getPlostById(String plostid);

}

