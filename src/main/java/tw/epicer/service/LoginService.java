package tw.epicer.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.epicer.model.Message;
import tw.epicer.model.User;
import tw.epicer.dao.UserDao;

@Service
@Transactional
public class LoginService {
	@Autowired
private UserDao dao;
	
	public LoginService(UserDao dao) {
		super();
		this.dao = dao;
	}

	public Message checkAccount(String account) {
		Message msg = new Message();
		if(dao.checkAccount(account) == null) {
			msg.setCode(1);
			msg.setMessage("帳號不存在");
		}else {
			msg.setCode(0);
			msg.setMessage("ok");
		}
		return msg;
	}
	
	public Message cheackPassword(String account,String password) {
	Message msg = new Message();
	   User admin = dao.selectPassword(account);
	   if(admin == null) {
		   msg.setCode(1);
		   msg.setMessage("密碼不正確");
	   }else {
		   if(password.equals(admin.getPassword())){
			   msg.setCode(0);
			   msg.setMessage("ok");
		   }else {
			   msg.setCode(1);
			   msg.setMessage("密碼不正確");
		   }
	   }
	   return msg;
	}
	
	public User showIndex(String account) {
		User user = dao.selectInform(account);
		return user;
	}
	
	public User updateDate(User user) {
		 User admin = dao.updateDate(user);
		return admin;
	}
	
}
