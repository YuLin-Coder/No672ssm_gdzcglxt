package com.dao;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.entity.Send;

@Repository("sendDAO") // Repository标签定义数据库连接的访问 Spring中直接
@Mapper
public interface SendDAO {

	/**
* SendDAO 接口 可以按名称直接调用send.xml配置文件的SQL语句
 */

	// 插入数据 调用entity包send.xml里的insertSend配置 返回值0(失败),1(成功)
	public int insertSend(Send send);

	// 更新数据 调用entity包send.xml里的updateSend配置 返回值0(失败),1(成功)
	public int updateSend(Send send);

	// 删除数据 调用entity包send.xml里的deleteSend配置 返回值0(失败),1(成功)
	public int deleteSend(String sendid);

	// 查询全部数据 调用entity包send.xml里的getAllSend配置 返回List类型的数据
	public List<Send> getAllSend();

	// 按照Send类里面的值精确查询 调用entity包send.xml里的getSendByCond配置 返回List类型的数据
	public List<Send> getSendByCond(Send send);

	// 按照Send类里面的值模糊查询 调用entity包send.xml里的getSendByLike配置 返回List类型的数据
	public List<Send> getSendByLike(Send send);

	// 按主键查询表返回单一的Send实例 调用entity包send.xml里的getSendById配置
	public Send getSendById(String sendid);

}


