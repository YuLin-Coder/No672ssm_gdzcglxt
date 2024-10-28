package com.dao;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.entity.Scarp;

@Repository("scarpDAO") // Repository标签定义数据库连接的访问 Spring中直接
@Mapper
public interface ScarpDAO {

	/**
* ScarpDAO 接口 可以按名称直接调用scarp.xml配置文件的SQL语句
 */

	// 插入数据 调用entity包scarp.xml里的insertScarp配置 返回值0(失败),1(成功)
	public int insertScarp(Scarp scarp);

	// 更新数据 调用entity包scarp.xml里的updateScarp配置 返回值0(失败),1(成功)
	public int updateScarp(Scarp scarp);

	// 删除数据 调用entity包scarp.xml里的deleteScarp配置 返回值0(失败),1(成功)
	public int deleteScarp(String scarpid);

	// 查询全部数据 调用entity包scarp.xml里的getAllScarp配置 返回List类型的数据
	public List<Scarp> getAllScarp();

	// 按照Scarp类里面的值精确查询 调用entity包scarp.xml里的getScarpByCond配置 返回List类型的数据
	public List<Scarp> getScarpByCond(Scarp scarp);

	// 按照Scarp类里面的值模糊查询 调用entity包scarp.xml里的getScarpByLike配置 返回List类型的数据
	public List<Scarp> getScarpByLike(Scarp scarp);

	// 按主键查询表返回单一的Scarp实例 调用entity包scarp.xml里的getScarpById配置
	public Scarp getScarpById(String scarpid);

}


