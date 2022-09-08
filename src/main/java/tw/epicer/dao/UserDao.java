package tw.epicer.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tw.epicer.model.User;

@Repository
@Transactional //與資料庫相關都需要加上
public class UserDao {
	
@Autowired
private SessionFactory sessionfactory;
	
	public UserDao(SessionFactory sessionfactory) {
		this.sessionfactory=sessionfactory;
	}
	
	public User updateImage(String usepath) {
		Session session = sessionfactory.getCurrentSession();
		try {
			User user = session.get(User.class,2);
			user.setAvatar(usepath);
			session.update(user);
			return user;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.print("出示了阿北");
			return null;
		}
	}

	public User checkAccount(String account) {
		String hql = "from User where account=:a";
		Session session = sessionfactory.getCurrentSession();
		try {
			User admin = session.createQuery(hql, User.class).setParameter("a", account).getSingleResult();
			return admin;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.print("出示了阿北");
			return null;
		}
	}

	public User selectPassword(String account) {
		String hql = "from User where account = :a";
		Session session = sessionfactory.getCurrentSession();
		try {
			User admin = session.createQuery(hql, User.class).setParameter("a", account).getSingleResult();
			return admin;
		} catch (Exception e) { // 0筆
			System.out.print("出示了阿北");
			e.printStackTrace();
			return null;
		}
	}

	public User updateDate(User user) {
		User admin = this.selectInform(user.getAccount());
		Session session = sessionfactory.getCurrentSession();
		long longdate = new Date().getTime();
		try {
		User target = session.get(User.class,admin.getId());
		target.setLogindate(longdate);
		session.update(target);
		return target;
		}catch(Exception e ){
			e.printStackTrace();
			System.out.println("出示了阿北");
		   return null;
		}
	}

	public User selectInform(String account) {
		String hql = "from User where account = :a";
		Session session = sessionfactory.getCurrentSession();
		try {
			User admin = session.createQuery(hql, User.class).setParameter("a", account).getSingleResult();
			return admin;
		} catch (Exception e) {
			System.out.print("出事了阿北");
			e.printStackTrace();
			return null;
		}
	}

	public User InsertCilent(User user) {
		Session session = sessionfactory.getCurrentSession();
		try {
			session.save(user);
			return user;
		} catch (Exception e) {
			System.out.print("出示了阿北");
			return null;
		}
	}

	public User updateUser(User user) {
//		String hql ="update User set nickname=:n,password =:p,phone=:ph,city=:c,township=:t,road=:r,avatar =:av where account =:a";
		Session session = sessionfactory.getCurrentSession();
		try {
			User admin = session.get(User.class, user.getId());
			admin.setPassword(user.getPassword());
			admin.setNickname(user.getNickname());
			admin.setPhone(user.getPhone());
			admin.setCity(user.getCity());
			admin.setTownship(user.getTownship());
			admin.setRoad(user.getRoad());
			admin.setAvatar(user.getAvatar());
			session.update(admin);
			return admin;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	

	public List<User> doSearch(String status) {
		int intstatus =Integer.parseInt(status);
		String hql = "from User where status=:s ";
		Session session = sessionfactory.getCurrentSession();
		try {
			List<User> list = session.createQuery(hql, User.class).setParameter("s", intstatus).getResultList();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean dodelete(String id) {
		int intid =Integer.parseInt(id);
		Session session = sessionfactory.getCurrentSession();
		try {
			User user = session.get(User.class,intid);
			session.delete(user);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
