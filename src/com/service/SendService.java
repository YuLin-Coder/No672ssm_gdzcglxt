package com.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Send;
@Service("sendService")
public interface SendService {
	// 插入数据 调用sendDAO里的insertSend配置
	public int insertSend(Send send);

	// 更新数据 调用sendDAO里的updateSend配置
	public int updateSend(Send send);

	// 删除数据 调用sendDAO里的deleteSend配置
	public int deleteSend(String sendid);

	// 查询全部数据 调用sendDAO里的getAllSend配置
	public List<Send> getAllSend();

	// 按照Send类里面的字段名称精确查询 调用sendDAO里的getSendByCond配置
	public List<Send> getSendByCond(Send send);

	// 按照Send类里面的字段名称模糊查询 调用sendDAO里的getSendByLike配置
	public List<Send> getSendByLike(Send send);

	// 按主键查询表返回单一的Send实例 调用sendDAO里的getSendById配置
	public Send getSendById(String sendid);

}

