package tw.epicer.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tw.epicer.model.ArticleBean;
import tw.epicer.model.ArticleReplyBean;
import tw.epicer.model.ArticleUserBean;

@Repository
@Transactional
public class ArticleUserRecDao {
	
	@Autowired
	private SessionFactory factory;
	
	public List<ArticleBean> selectArticleRec(int id) {
		Session session = factory.getCurrentSession();
		ArticleUserBean userId = session.get(ArticleUserBean.class, id);
		String strSQL="from ArticleBean where user like :id"; 
		try {
			Query<ArticleBean> query = session.createQuery(strSQL, ArticleBean.class)
			.setParameter("id",userId);
			return query.list();
		} catch (Exception e) {
			System.out.println("失敗");
			return null;
		}
		
	}
	
	public List<ArticleReplyBean> selectReplyRec(int id) {
		Session session = factory.getCurrentSession();
		ArticleUserBean userId = session.get(ArticleUserBean.class, id);
		String strSQL="from ArticleReplyBean where user like :id"; 
		try {
			Query<ArticleReplyBean> query = session.createQuery(strSQL, ArticleReplyBean.class)
			.setParameter("id",userId);
			return query.list();
		} catch (Exception e) {
			System.out.println("失敗");
			return null;
		}
		
	}

}
