package com.dao;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.entity.Lend;

@Repository("lendDAO") // Repository标签定义数据库连接的访问 Spring中直接
@Mapper
public interface LendDAO {

	/**
* LendDAO 接口 可以按名称直接调用lend.xml配置文件的SQL语句
 */

	// 插入数据 调用entity包lend.xml里的insertLend配置 返回值0(失败),1(成功)
	public int insertLend(Lend lend);

	// 更新数据 调用entity包lend.xml里的updateLend配置 返回值0(失败),1(成功)
	public int updateLend(Lend lend);

	// 删除数据 调用entity包lend.xml里的deleteLend配置 返回值0(失败),1(成功)
	public int deleteLend(String lendid);

	// 查询全部数据 调用entity包lend.xml里的getAllLend配置 返回List类型的数据
	public List<Lend> getAllLend();

	// 按照Lend类里面的值精确查询 调用entity包lend.xml里的getLendByCond配置 返回List类型的数据
	public List<Lend> getLendByCond(Lend lend);

	// 按照Lend类里面的值模糊查询 调用entity包lend.xml里的getLendByLike配置 返回List类型的数据
	public List<Lend> getLendByLike(Lend lend);

	// 按主键查询表返回单一的Lend实例 调用entity包lend.xml里的getLendById配置
	public Lend getLendById(String lendid);

}


