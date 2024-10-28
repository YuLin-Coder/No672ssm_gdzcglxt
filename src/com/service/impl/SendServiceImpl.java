package com.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.SendDAO;
import com.entity.Send;
import com.service.SendService;

@Service("sendService")
public class SendServiceImpl implements SendService {
	@Autowired
	private SendDAO sendDAO;
	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertSend(Send send) {
		return this.sendDAO.insertSend(send);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updateSend(Send send) {
		return this.sendDAO.updateSend(send);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deleteSend(String sendid) {
		return this.sendDAO.deleteSend(sendid);
	}

	@Override // 继承接口的查询全部
	public List<Send> getAllSend() {
		return this.sendDAO.getAllSend();
	}

	@Override // 继承接口的按条件精确查询
	public List<Send> getSendByCond(Send send) {
		return this.sendDAO.getSendByCond(send);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Send> getSendByLike(Send send) {
		return this.sendDAO.getSendByLike(send);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Send getSendById(String sendid) {
		return this.sendDAO.getSendById(sendid);
	}

}

