package tw.epicer.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import tw.epicer.model.ArticleBean;
import tw.epicer.model.ArticleReplyBean;
import tw.epicer.model.ArticleUserBean;
import tw.epicer.model.WangEditorResponse;
import tw.epicer.service.ArticleReplyService;
import tw.epicer.service.ArticleService;
import tw.epicer.service.ArticleUserRecService;
import tw.epicer.util.TimeTest;
import tw.epicer.util.fileUtils;


@Controller
public class ArticleController {
	
	@Autowired
	private ArticleService article;
	
	@Autowired
	private ArticleReplyService reply;
	
	@Autowired
	private ArticleUserRecService aurs;
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private SessionFactory factory;
	


	
	
	
	

	@GetMapping("/QueryAll")
	public String QueryAll(HttpSession session) {
		List<ArticleBean> selectAll = article.selectAll();
		session.setAttribute("selectAll", selectAll);
		return "forumIndex";
	}

	@PostMapping("/QueryName")
	public String QueryName(String title ,HttpSession session) {
		List<ArticleBean> selectTitle = article.selectTitle(title);
		session.setAttribute("selectTitle", selectTitle);
		return "forumName";
	}

	@PostMapping("/QueryCategory")
	public String QueryCategory(int categoryId,HttpSession session) {
		List<ArticleBean> selectCategory = article.selectCategory(categoryId);
		session.setAttribute("selectCategory", selectCategory);
		return "forumCategory";
	}
	
	
	
	@PostMapping("/forumAdd")
	public String forumAddPage() {
		return "forumAdd";
	}
	

	@PostMapping("/articleAdd")
	public String articleAdd(int category,String articleTitle,String articleContent) {

		Long time= TimeTest.getTime();
		int userId = (int) session.getAttribute("userId");
		Session s = factory.openSession();
		ArticleUserBean userID = s.get(ArticleUserBean.class,userId);
		s.close();
		ArticleBean articleBean = new ArticleBean(category,articleTitle,articleContent,time,userID);
		article.insert(articleBean);
		return "redirect:/QueryAll";
	}

	
	@PostMapping("/forumUpdatePage")
	public String forumUpdatePage(int articleId) {
		ArticleBean updateDetail = article.select(articleId);
		session.setAttribute("updateDetail", updateDetail);

		return "forumUpdate";
	}
	
	@PostMapping("/articleUpdate")
	public String articleUpdate(int articleId,String aTitle,String aContent) {
		article.updateOne(articleId, aTitle, aContent);
		return "redirect:/QueryAll";
	}

	@PostMapping("/articleDetail")
	public String articleDetail(int articleId) {
		ArticleBean selectDetail = article.select(articleId);
		List<ArticleReplyBean> selectReplyAll = reply.selectAll(articleId);
		session.setAttribute("selectDetail", selectDetail);
		session.setAttribute("selectReplyAll", selectReplyAll);
		return "forumDetail";
	}
	@PostMapping("/articleDelete")
	public String articleDelete(int number) {
		article.deleteOne(number);
		return "redirect:/QueryAll";
	}

	@PostMapping("/replyAddPage")
	public String replyAddPage() {
		return "forumReplyAdd";
	}
	
	@PostMapping("/replyAdd")
	public String replyAdd(int articleId,String replyContent) {
    	Long time= TimeTest.getTime();
    	int userId = (int) session.getAttribute("userId");
    	Session s = factory.openSession();
    	ArticleUserBean userID = s.get(ArticleUserBean.class,userId);
    	ArticleBean articleID = s.get(ArticleBean.class,articleId);
    	s.close();
    	ArticleReplyBean articleReplyBean = new ArticleReplyBean(articleID, userID,replyContent, time);
    	reply.insert(articleReplyBean);
		return "forward:/articleDetail";
	}

	@PostMapping("/replyDelete")
	public String replyDelete(int replyId,int articleId) {
		reply.deleteOne(replyId);
		ArticleBean selectDetail = article.select(articleId);
		List<ArticleReplyBean> selectReplyAll = reply.selectAll(articleId);
		session.setAttribute("selectDetail", selectDetail);
		session.setAttribute("selectReplyAll", selectReplyAll);
		return "forumDetail";
	}
	
	
	
	@PostMapping("/replyUpdatePage")
	public String replyUpdatePage(int replyId) {
		ArticleReplyBean replyUpdateDetail = reply.select(replyId);
		session.setAttribute("replyUpdateDetail", replyUpdateDetail);
		return "forumReplyUpdate";
	}
	
	@PostMapping("/replyUpdate")
	public String replyUpdate(int articleId,int replyId ,String replyContent,Model model) {
		reply.updateOne(replyId, replyContent);
		
		ArticleBean selectDetail = article.select(articleId);
		List<ArticleReplyBean> selectReplyAll = reply.selectAll(articleId);
		session.setAttribute("selectDetail", selectDetail);
		session.setAttribute("selectReplyAll", selectReplyAll);
		
		return "forumDetail";
	}
	
	
	
	@PostMapping("/forumUser")
	public String forumUser() {
		return "forumUserPage";
	}

	
	@GetMapping("/QueryUserArticle")
	public String QueryUserArticle() {
		int userId = (int) session.getAttribute("userId");
		List<ArticleBean> UserArticle = aurs.selectArticle(userId);
		session.setAttribute("UserArticle", UserArticle);
		return "forumUserPageArticleRec";
	}
	
	@GetMapping("/QueryUserReply")
	public String QueryUserReply() {
		int userId = (int) session.getAttribute("userId");
		List<ArticleReplyBean> UserReply = aurs.selectReply(userId);
		session.setAttribute("UserReply", UserReply);
		return "forumUserPageReplyRec";
	}
	
	
	@PostMapping("/UserUpdateArticlePage")
	public String UserUpdateArticlePage(int articleId) {
		ArticleBean updateDetail = article.select(articleId);
		session.setAttribute("updateDetail", updateDetail);
		return "forumUserArticleUpdate";
	}
	

	@PostMapping("/UserUpdateArticle")
	public String UserUpdateArticle(int articleId,String aTitle,String aContent) {
		article.updateOne(articleId, aTitle, aContent);
		return "redirect:/QueryUserArticle";
	}
	
	
	
	@PostMapping("/UserDeleteArticle")
	public String UserDeleteArticle(int number) {
		article.deleteOne(number);
		return "redirect:/QueryUserArticle";
	}
	
	
	
	
	
	
	@PostMapping("/UserDeleteReply")
	public String UserDeleteReply(int replyId,int articleId) {
		reply.deleteOne(replyId);
		return "redirect:/QueryUserReply";
	}
	
	
	
	@PostMapping("/UserUpdateReplyPage")
	public String UserUpdateReplyPage(int replyId) {
		ArticleReplyBean replyUserUpdateDetail = reply.select(replyId);
		session.setAttribute("replyUserUpdateDetail", replyUserUpdateDetail);
		return "forumUserReplyUpdate";
	}
	
	@PostMapping("/UserUpdateReply")
	public String UserUpdateReply(int replyId ,String replyContent) {
		reply.updateOne(replyId, replyContent);
				
		return "redirect:/QueryUserReply";
	}
	
	@RequestMapping(value="/images",produces={"application/json; charset=UTF-8"})
	@ResponseBody //application/json
	 public Object  test1(@RequestParam("img") MultipartFile file, Map<String, Object> map,HttpServletRequest request) throws IOException {
        System.out.println("file.getOriginalFilename() "+file.getOriginalFilename());
        //使用uuid解决文件重名
        String outpath = "C:\\Users\\smile\\Desktop\\第二組Epicer\\Epicer\\src\\main\\webapp\\WEB-INF\\resources\\images\\"+UUID.randomUUID().toString().replaceAll("-","");
        byte[] bytes = file.getBytes();
        //读取文件路径
        String path = request.getServletContext().getRealPath("/images/");
        //如果不存在则新建
        File imgFile = new File(path);
        if (!imgFile.exists()) {
            imgFile.mkdirs();
        }
        String fileName = file.getOriginalFilename();// 文件名称
        System.out.println(path + fileName);
        //对文件进行写入
        try (FileOutputStream fos = new FileOutputStream(new File(path + fileName))) {
            int len = 0;
            fos.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
 //這方法照片要重新刷新才能顯示    //  String value = "images/" +outpath.substring(outpath.lastIndexOf("\\")+1)+ fileName;
        String value = "images/"+ fileName;
        //保存到服务器目录，记录名称地址
        fileUtils.upload(file, outpath, file.getOriginalFilename());
        map.put("imgName",fileName);
        map.put("imgUrl",outpath+fileName);
        System.out.println(map);
        //返回信息上传
        return  new WangEditorResponse("1", Arrays.asList(value));
		
		
		
		

    }
	
	
	
	
}
	
	

