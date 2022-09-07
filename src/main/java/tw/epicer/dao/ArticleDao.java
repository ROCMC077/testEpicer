package tw.epicer.dao;



import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tw.epicer.model.ArticleBean;
import tw.epicer.util.TimeTest;

@Repository
@Transactional
public class ArticleDao  {

	@Autowired
	private SessionFactory factory;
	

	public ArticleBean insert(ArticleBean arBean) {
		Session session = factory.getCurrentSession();
		
			session.save(arBean);
		
		return arBean;
	}

	public ArticleBean select(int id) {
		Session session = factory.getCurrentSession();
		return session.get(ArticleBean.class, id);
	}

	public List<ArticleBean> selectAll() {
		Session session = factory.getCurrentSession();
		Query<ArticleBean> query = session.createQuery("from ArticleBean", ArticleBean.class);
		return query.list();
	}

	public ArticleBean updateOne(int id, String title,String article_content) {
		Session session = factory.getCurrentSession();
		ArticleBean arBean = session.get(ArticleBean.class, id);
		
		if (arBean != null) {
			arBean.setTitle(title);
			arBean.setArticleContent(article_content);
			arBean.setDate(TimeTest.getTime());
			return arBean;
		}
		return null;
	}

	public boolean deleteOne(int id) {
		Session session = factory.getCurrentSession();
		ArticleBean arBean = session.get(ArticleBean.class, id);
		if(arBean!=null) {
			session.delete(arBean);
			return true;
		}
		
		return false;
	}

	public List<ArticleBean> selectTitle(String title) {
		Session session = factory.getCurrentSession();
	    String strSQL="from ArticleBean as a where title like :title";   
		try {
			Query<ArticleBean> query = session.createQuery(strSQL, ArticleBean.class)
			.setParameter("title","%"+title+"%");
			return query.list();
		} catch (Exception e) {
			return null;
		}
	}

	public List<ArticleBean> selectCategory(int plateformCategoryId) {
		Session session = factory.getCurrentSession();
	    String strSQL="from ArticleBean as a where plateformCategoryId like :id";   
		try {
			Query<ArticleBean> query = session.createQuery(strSQL, ArticleBean.class)
			.setParameter("id",plateformCategoryId);
			return query.list();
		} catch (Exception e) {
			return null;
		}
	}

}
