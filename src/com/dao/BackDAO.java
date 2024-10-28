package com.dao;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.entity.Back;

@Repository("backDAO") // Repository标签定义数据库连接的访问 Spring中直接
@Mapper
public interface BackDAO {

	/**
* BackDAO 接口 可以按名称直接调用back.xml配置文件的SQL语句
 */

	// 插入数据 调用entity包back.xml里的insertBack配置 返回值0(失败),1(成功)
	public int insertBack(Back back);

	// 更新数据 调用entity包back.xml里的updateBack配置 返回值0(失败),1(成功)
	public int updateBack(Back back);

	// 删除数据 调用entity包back.xml里的deleteBack配置 返回值0(失败),1(成功)
	public int deleteBack(String backid);

	// 查询全部数据 调用entity包back.xml里的getAllBack配置 返回List类型的数据
	public List<Back> getAllBack();

	// 按照Back类里面的值精确查询 调用entity包back.xml里的getBackByCond配置 返回List类型的数据
	public List<Back> getBackByCond(Back back);

	// 按照Back类里面的值模糊查询 调用entity包back.xml里的getBackByLike配置 返回List类型的数据
	public List<Back> getBackByLike(Back back);

	// 按主键查询表返回单一的Back实例 调用entity包back.xml里的getBackById配置
	public Back getBackById(String backid);

}


