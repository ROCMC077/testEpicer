package tw.epicer.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Table(name = "forum_article_user")
@Component
public class ArticleUserBean {
	
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;

	@Column(name = "user_status")
	private Integer userStatus;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user",cascade = CascadeType.ALL)
	private List<ArticleBean> articleBean = new ArrayList<ArticleBean>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user",cascade = CascadeType.ALL)
	private List<ArticleCollectRecBean> collectArticleRec = new ArrayList<ArticleCollectRecBean>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user",cascade = CascadeType.ALL)
	private List<ArticleReplyBean> articleReplyBean = new ArrayList<ArticleReplyBean>();
	
	

	public ArticleUserBean() {
		super();
	}



	public ArticleUserBean(Integer userId, Integer userStatus, List<ArticleBean> articleBean,
			List<ArticleCollectRecBean> collectArticleRec, List<ArticleReplyBean> articleReplyBean) {
		super();
		this.userId = userId;
		this.userStatus = userStatus;
		this.articleBean = articleBean;
		this.collectArticleRec = collectArticleRec;
		this.articleReplyBean = articleReplyBean;
	}



	public Integer getUserId() {
		return userId;
	}



	public void setUserId(Integer userId) {
		this.userId = userId;
	}



	public Integer getUserStatus() {
		return userStatus;
	}



	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}



	public List<ArticleBean> getArticleBean() {
		return articleBean;
	}



	public void setArticleBean(List<ArticleBean> articleBean) {
		this.articleBean = articleBean;
	}



	public List<ArticleCollectRecBean> getCollectArticleRec() {
		return collectArticleRec;
	}



	public void setCollectArticleRec(List<ArticleCollectRecBean> collectArticleRec) {
		this.collectArticleRec = collectArticleRec;
	}



	public List<ArticleReplyBean> getArticleReplyBean() {
		return articleReplyBean;
	}



	public void setArticleReplyBean(List<ArticleReplyBean> articleReplyBean) {
		this.articleReplyBean = articleReplyBean;
	}

	



}
