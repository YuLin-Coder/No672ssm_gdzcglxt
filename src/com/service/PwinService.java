package com.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Pwin;
@Service("pwinService")
public interface PwinService {
	// 插入数据 调用pwinDAO里的insertPwin配置
	public int insertPwin(Pwin pwin);

	// 更新数据 调用pwinDAO里的updatePwin配置
	public int updatePwin(Pwin pwin);

	// 删除数据 调用pwinDAO里的deletePwin配置
	public int deletePwin(String pwinid);

	// 查询全部数据 调用pwinDAO里的getAllPwin配置
	public List<Pwin> getAllPwin();

	// 按照Pwin类里面的字段名称精确查询 调用pwinDAO里的getPwinByCond配置
	public List<Pwin> getPwinByCond(Pwin pwin);

	// 按照Pwin类里面的字段名称模糊查询 调用pwinDAO里的getPwinByLike配置
	public List<Pwin> getPwinByLike(Pwin pwin);

	// 按主键查询表返回单一的Pwin实例 调用pwinDAO里的getPwinById配置
	public Pwin getPwinById(String pwinid);

}

