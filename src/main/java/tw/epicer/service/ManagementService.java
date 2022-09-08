package tw.epicer.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.epicer.model.Image;
import tw.epicer.model.Message;
import tw.epicer.model.User;
import tw.epicer.dao.UserDao;
import tw.epicer.util.Tools;

@Service
@Transactional
public class ManagementService {
	@Autowired
private UserDao dao;
private Tools tools =new Tools();

	public ManagementService(UserDao dao) {
		super();
		this.dao = dao;
	}
	
	public boolean updateImage(String usepath) {
		User user = dao.updateImage(usepath);
		if(user==null) {
			return false;
		}else {
			return true;
		}
	}
	

	public Message dodelete(String id) {
		Message msg = new Message();
		boolean result = dao.dodelete(id);
		if(result) {
			msg.setCode(0);
			msg.setMessage("刪除完成");
			msg.setObject(id);
		}else {
			msg.setCode(1);
			msg.setMessage("刪除失敗請重新嘗試");
		}
		return msg;
	}
	
	
	//會員管理
	public User showInform(String account) {
		User user = dao.selectInform(account);
		return user;
	}
	
	
	//修改會員資料
	public HashMap<String,Message> checkAll(User user){
		HashMap<String,Message> show =new HashMap<String,Message>();
        Message result = new Message();
		Message nickname = this.checknick(user);
		Message password = this.checkPassword(user);
		Message phone = this.checkPhone(user);
		Message city = this.checkCity(user);
		Message township = this.checkTownship(user);
		Message road = this.checkRoad(user);
		int nickcode = nickname.getCode();
		int pwscode = password.getCode();
		int phcode = phone.getCode();
		int citycode = city.getCode();
		int towncode = township.getCode();
		int roadcode = road.getCode();
		if(nickcode ==0 && pwscode == 0 && phcode == 0 && citycode ==0 && towncode == 0 && roadcode ==0) {
			result.setCode(0);
			show.put("result",result);
			show.put("nickname",nickname);
			show.put("password",password);
			show.put("phone",phone);
			show.put("city",city);
			show.put("township",township);
			show.put("road",road);
		}else {
			result.setCode(1);
			show.put("result",result);
			show.put("nickname",nickname);
			show.put("password",password);
			show.put("phone",phone);
			show.put("city",city);
			show.put("township",township);
			show.put("road",road);
		}
		return show;
	}
	
	
	//修改會員資料
	public User updateUser(User user,String filename) {
		String usepath="images/"+filename;
		user.setAvatar(usepath);
		User result = dao.updateUser(user);
		if(result != null) {
			return result;
		}else {
			return null;
		}
	}
	
	
	//圖片寫入專案 image:cleanname,fullpath(temp) 
//	public void saveInLocalhost(Image image)  {
//		Message msg = new Message();
//		InputStream fis = null;
//		String localpath = "D:\\Hibernate\\workspace\\Hibernate_Web\\src\\main\\webapp\\images\\"+image.getPicname(); //cleanname
//		System.out.print(localpath); 
//		try {
//			fis = new FileInputStream(new File(image.getFulltemppath()));
//			OutputStream fos = new FileOutputStream(new File(localpath)); //內存地址寫死
//			int a = 0;
//			byte[] temp = new byte[1024];
//			while((a = fis.read(temp)) != -1){
//				fos.write(temp,0,a);
//			}
//			fis.close(); //關
//			fos.flush(); //關
//			fos.close(); //關
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
	
	
	//密碼不為空，6~18字以內，是否含中文，是否英文數字
			public Message checkPassword(User user) {
				String password = user.getPassword();
				Message msg = new Message();
				boolean isempty = tools.isEmpty(password);
				if (isempty) { // 為空
					msg.setCode(1);
					msg.setMessage("密碼不能為空");
				} else {// 不為空
					boolean haschinese = tools.hasChinese(password);
					if (haschinese) { // 含中文
						msg.setCode(1);
						msg.setMessage("密碼不能有中文");
					} else { // 不含中文
						boolean hasengnum = tools.hasEngandNum(password);
						if (hasengnum) { // 含英文數字
							int length = password.length();
							if (length < 8 || length > 16) { // 密碼小於8或超過16
								msg.setCode(1);
								msg.setMessage("密碼為8至16個字元");
							} else {
								msg.setCode(0);
								msg.setMessage("ok");
							}
						} else { // 缺少英文或數字
							msg.setCode(1);
							msg.setMessage("密碼需含英文或數字");
						}
					}

				}
				return msg;
			}
			
			// 電話不能為空 不能含中文英文
			public Message checkPhone(User user) {
				String phone = user.getPhone();
				Message msg = new Message();
				boolean isempty = tools.isEmpty(phone);
				if (isempty) { // 電話為空
					msg.setCode(1);
					msg.setMessage("連絡電話必填");
				} else { // 電話不為空
					boolean allnum = tools.allNum(phone);
					if (allnum) { // 全為數字
						int length = phone.length();
						if (length == 10) {
							msg.setCode(0);
							msg.setMessage("ok");
						} else {
							msg.setCode(1);
							msg.setMessage("請輸入有效電話");
						}
					} else { // 含非數字
						msg.setCode(1);
						msg.setMessage("請輸入有效電話");
					}

				}
				return msg;
			}

			// 縣市不能為0 且 必須範圍內
			public Message checkCity(User user) {
				Message msg = new Message();
				int city = user.getCity();
				if (city == 0 || city > 22) { // 縣市為空 或 超出範圍
					msg.setCode(1);
					msg.setMessage("請選擇縣市");
				} else { // 縣市不為空 且 範圍內
					msg.setCode(0);
					msg.setMessage("ok");
				}
				return msg;
			}

			
		//區域不能為空
			public Message checkTownship(User user) {
				Message msg = new Message();
				String township = user.getTownship();
				boolean isempty = tools.isEmpty(township);
				if (isempty) { // 縣市為空 或 超出範圍
					msg.setCode(1);
					msg.setMessage("區域不能為空");
				} else { // 區域不為空
					msg.setCode(0);
					msg.setMessage("ok");
				}
				return msg;
			}

			
		//路段不能為空
			public Message checkRoad(User user) {
				Message msg = new Message();
				String road = user.getRoad();
				boolean isempty = tools.isEmpty(road);
				if (isempty) { // 縣市為空 或 超出範圍
					msg.setCode(1);
					msg.setMessage("路段不能為空");
				} else { // 區域不為空
					msg.setCode(0);
					msg.setMessage("ok");
				}
				return msg;
			}
			
//暱稱
			public Message checknick(User user) {
				int length = user.getNickname().length();
				Message msg2 = new Message();
				if(length > 16) {
					msg2.setCode(1);
					msg2.setMessage("最多可以使用15個字");
					msg2.setObject(user);
				}else {
					msg2.setCode(0);
					msg2.setMessage("暱稱可以使用");
					msg2.setObject(user);
				}
				return msg2;
			}
			
			
			public List<User> doSearch(String status){
				List<User> list = dao.doSearch(status);
				return list;
			}


	
}

	
	
