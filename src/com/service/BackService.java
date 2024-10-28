package com.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Back;
@Service("backService")
public interface BackService {
	// 插入数据 调用backDAO里的insertBack配置
	public int insertBack(Back back);

	// 更新数据 调用backDAO里的updateBack配置
	public int updateBack(Back back);

	// 删除数据 调用backDAO里的deleteBack配置
	public int deleteBack(String backid);

	// 查询全部数据 调用backDAO里的getAllBack配置
	public List<Back> getAllBack();

	// 按照Back类里面的字段名称精确查询 调用backDAO里的getBackByCond配置
	public List<Back> getBackByCond(Back back);

	// 按照Back类里面的字段名称模糊查询 调用backDAO里的getBackByLike配置
	public List<Back> getBackByLike(Back back);

	// 按主键查询表返回单一的Back实例 调用backDAO里的getBackById配置
	public Back getBackById(String backid);

}

