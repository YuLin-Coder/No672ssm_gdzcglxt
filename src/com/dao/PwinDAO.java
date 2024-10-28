package com.dao;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.entity.Pwin;

@Repository("pwinDAO") // Repository标签定义数据库连接的访问 Spring中直接
@Mapper
public interface PwinDAO {

	/**
* PwinDAO 接口 可以按名称直接调用pwin.xml配置文件的SQL语句
 */

	// 插入数据 调用entity包pwin.xml里的insertPwin配置 返回值0(失败),1(成功)
	public int insertPwin(Pwin pwin);

	// 更新数据 调用entity包pwin.xml里的updatePwin配置 返回值0(失败),1(成功)
	public int updatePwin(Pwin pwin);

	// 删除数据 调用entity包pwin.xml里的deletePwin配置 返回值0(失败),1(成功)
	public int deletePwin(String pwinid);

	// 查询全部数据 调用entity包pwin.xml里的getAllPwin配置 返回List类型的数据
	public List<Pwin> getAllPwin();

	// 按照Pwin类里面的值精确查询 调用entity包pwin.xml里的getPwinByCond配置 返回List类型的数据
	public List<Pwin> getPwinByCond(Pwin pwin);

	// 按照Pwin类里面的值模糊查询 调用entity包pwin.xml里的getPwinByLike配置 返回List类型的数据
	public List<Pwin> getPwinByLike(Pwin pwin);

	// 按主键查询表返回单一的Pwin实例 调用entity包pwin.xml里的getPwinById配置
	public Pwin getPwinById(String pwinid);

}


