package com.dao;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.entity.Plost;

@Repository("plostDAO") // Repository标签定义数据库连接的访问 Spring中直接
@Mapper
public interface PlostDAO {

	/**
* PlostDAO 接口 可以按名称直接调用plost.xml配置文件的SQL语句
 */

	// 插入数据 调用entity包plost.xml里的insertPlost配置 返回值0(失败),1(成功)
	public int insertPlost(Plost plost);

	// 更新数据 调用entity包plost.xml里的updatePlost配置 返回值0(失败),1(成功)
	public int updatePlost(Plost plost);

	// 删除数据 调用entity包plost.xml里的deletePlost配置 返回值0(失败),1(成功)
	public int deletePlost(String plostid);

	// 查询全部数据 调用entity包plost.xml里的getAllPlost配置 返回List类型的数据
	public List<Plost> getAllPlost();

	// 按照Plost类里面的值精确查询 调用entity包plost.xml里的getPlostByCond配置 返回List类型的数据
	public List<Plost> getPlostByCond(Plost plost);

	// 按照Plost类里面的值模糊查询 调用entity包plost.xml里的getPlostByLike配置 返回List类型的数据
	public List<Plost> getPlostByLike(Plost plost);

	// 按主键查询表返回单一的Plost实例 调用entity包plost.xml里的getPlostById配置
	public Plost getPlostById(String plostid);

}


