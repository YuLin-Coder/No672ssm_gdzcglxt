package com.dao;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.entity.Applyx;

@Repository("applyxDAO") // Repository标签定义数据库连接的访问 Spring中直接
@Mapper
public interface ApplyxDAO {

	/**
* ApplyxDAO 接口 可以按名称直接调用applyx.xml配置文件的SQL语句
 */

	// 插入数据 调用entity包applyx.xml里的insertApplyx配置 返回值0(失败),1(成功)
	public int insertApplyx(Applyx applyx);

	// 更新数据 调用entity包applyx.xml里的updateApplyx配置 返回值0(失败),1(成功)
	public int updateApplyx(Applyx applyx);

	// 删除数据 调用entity包applyx.xml里的deleteApplyx配置 返回值0(失败),1(成功)
	public int deleteApplyx(String applyxid);

	// 查询全部数据 调用entity包applyx.xml里的getAllApplyx配置 返回List类型的数据
	public List<Applyx> getAllApplyx();

	// 按照Applyx类里面的值精确查询 调用entity包applyx.xml里的getApplyxByCond配置 返回List类型的数据
	public List<Applyx> getApplyxByCond(Applyx applyx);

	// 按照Applyx类里面的值模糊查询 调用entity包applyx.xml里的getApplyxByLike配置 返回List类型的数据
	public List<Applyx> getApplyxByLike(Applyx applyx);

	// 按主键查询表返回单一的Applyx实例 调用entity包applyx.xml里的getApplyxById配置
	public Applyx getApplyxById(String applyxid);

}


