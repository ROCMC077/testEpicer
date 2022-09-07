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
import tw.epicer.util.TimeTest;


@Repository
@Transactional
public class ArticleReplyDao {

	@Autowired
	private SessionFactory factory;


	public ArticleReplyBean insert(ArticleReplyBean articleReplyBean) {
		Session session = factory.getCurrentSession();

		session.save(articleReplyBean);

		return articleReplyBean;
	}

	public ArticleReplyBean select(int id) {
		Session session = factory.getCurrentSession();
		return session.get(ArticleReplyBean.class, id);
	}

	public List<ArticleReplyBean> selectAll(int articleId) {
		Session session = factory.getCurrentSession();
		ArticleBean arBeanId = session.get(ArticleBean.class, articleId);
		String strSQL="from ArticleReplyBean where articleId like :id"; 
		try {
			Query<ArticleReplyBean> query = session.createQuery(strSQL, ArticleReplyBean.class)
			.setParameter("id",arBeanId);
			return query.list();
		} catch (Exception e) {
			System.out.println("失敗");
			return null;
		}
		
	}

	public List<ArticleReplyBean> selectCategory(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArticleReplyBean updateOne(int id, String article_content) {
		Session session = factory.getCurrentSession();
		ArticleReplyBean arReplyBean = session.get(ArticleReplyBean.class, id);
		
		if (arReplyBean != null) {
			arReplyBean.setArticleReplyContent(article_content);
			arReplyBean.setArticleReplyDate(TimeTest.getTime());
			return arReplyBean;
		}
		return null;
	}

	public boolean deleteOne(int id) {
		Session session = factory.getCurrentSession();
		ArticleReplyBean arReplyBean = session.get(ArticleReplyBean.class, id);
		if(arReplyBean!=null) {
			session.delete(arReplyBean);
			return true;
		}
		return false;
	}

}
