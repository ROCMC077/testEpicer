package tw.epicer.service;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.epicer.dao.ArticleReplyDao;
import tw.epicer.model.ArticleBean;
import tw.epicer.model.ArticleReplyBean;


@Service
@Transactional
public class ArticleReplyService{
	
	@Autowired
	private ArticleReplyDao arDao;
	
	public ArticleReplyBean select(int replyId) {
		return arDao.select(replyId);
	}

	public List<ArticleReplyBean> selectAll(int articleId) {
		return arDao.selectAll(articleId);
	}

	public ArticleReplyBean insert(ArticleReplyBean articleReplyBean) {

		return arDao.insert(articleReplyBean);
	}


	public ArticleReplyBean updateOne(int id, String article_content) {
		return arDao.updateOne(id, article_content);
	}


	public boolean deleteOne(int id) {
		// TODO Auto-generated method stub
		return  arDao.deleteOne(id);
	}
	

	

}
