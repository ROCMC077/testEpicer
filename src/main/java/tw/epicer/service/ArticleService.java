package tw.epicer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.epicer.dao.ArticleDao;
import tw.epicer.model.ArticleBean;


@Service
@Transactional
public class ArticleService {

	@Autowired
	private ArticleDao aDao;
	
	
	public ArticleBean insert(ArticleBean arBean) {
		return aDao.insert(arBean);
	}

	public ArticleBean select(int id) {
		return aDao.select(id);
	}

	public List<ArticleBean> selectAll() {
		return aDao.selectAll();
	}

	public List<ArticleBean> selectTitle(String title) {
		return aDao.selectTitle(title);
	}

	public List<ArticleBean> selectCategory(int id) {
		return aDao.selectCategory(id);
	}

	public ArticleBean updateOne(int id, String title, String article_content) {
		return aDao.updateOne(id, title, article_content);
	}

	public boolean deleteOne(int id) {
		return aDao.deleteOne(id);
	}

}
