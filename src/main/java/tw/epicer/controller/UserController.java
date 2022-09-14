package tw.epicer.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import tw.epicer.model.Message;
import tw.epicer.model.User;
import tw.epicer.service.LoginService;
import tw.epicer.service.ManagementService;
import tw.epicer.service.RegisterService;
import tw.epicer.util.Tools;

//@RequestMapping(path = "/user" , method = RequestMethod.GET)
@Controller
@SessionAttributes(names= {"user","sgender","scity","sbirth","list"})
public class UserController {
	@Autowired
	private RegisterService register;
	@Autowired
	private LoginService login;
	@Autowired
	private ManagementService management;
	
	private static final String localpath = "C:/Users/User/Desktop/第二組專題/Epicer/src/main/webapp/WEB-INF/resources/images/";
	private Tools tools=new Tools();
	
//測試用
	@GetMapping(path="/exc")
	public void processExceptionAction() throws Exception {
		throw new Exception() ;
	}
	
	
	
	//查詢使用者資料
	@PostMapping(path="/user")
	public String getAllUsers(@RequestParam("status") String status,Model m) {
			List<User> list = management.doSearch(status);
			m.addAttribute("list",list);
			return "usersdata";			
	}
	
	//刪使用者資料
	@PostMapping(path="/delete")
	public String doDelete(@RequestParam("password") String password,@RequestParam("userid") String id,Model m) {
		User user = (User)m.getAttribute("user");
		if(user.getStatus()==0 && password.equals(user.getPassword())) {
			Message msg = management.dodelete(id);
			m.addAttribute("msg",msg);
			return "usersdata";			
		}else {
			Message msg =new Message();
			msg.setMessage("密碼錯誤，請重新嘗試");
			m.addAttribute("msg",msg);
			return "usersdata";	
		}
	}
	
	
	//返回
	@PostMapping(path = "/back")
		public String backToIndex() {
			return "empindex";
		}
	
	
	//使用者管理
	@PostMapping(path="/usersdata")
	public String getAllUsersform(){
		return "usersdata";
	}
	
	//新進員工註冊
	@PostMapping(path="empregister")
	public String getEmpregister(){
		return "empregister";
	}
	
	
	//登出
	@RequestMapping(path="logout", method=RequestMethod.POST)
	public String doLogout(Model m,SessionStatus status) {
		status.setComplete();
		return "index";
	}
	
	
	//myprofile
	@RequestMapping(path = "/management" ,method=RequestMethod.POST )
	public String showInform(Model m) {
		User user = (User)m.getAttribute("user");
		User admin = management.showInform(user.getAccount());
		String sgender = admin.getGenderName(admin.getGender());
		String scity = tools.getCityName(admin.getCity());
		String sbirth = tools.getStringDate(admin.getBirth());
		m.addAttribute("user",admin);
		m.addAttribute("sgender",sgender);
		m.addAttribute("sbirth",sbirth);
		m.addAttribute("scity",scity);
		return "Manegement";
	}
	
	//editprofile
	@RequestMapping(path = "/modify" ,method=RequestMethod.POST )
	public String showModify(@RequestParam("submit") String chose,Model m) {
		if(chose.equals("修改")){
			User user = (User)m.getAttribute("user");
			User admin = management.showInform(user.getAccount());
			String sgender = admin.getGenderName(admin.getGender());
			String scity = tools.getCityName(admin.getCity());
			String sbirth = tools.getStringDate(admin.getBirth());
			m.addAttribute("user",admin);
			m.addAttribute("sgender",sgender);
			m.addAttribute("sbirth",sbirth);
			m.addAttribute("scity",scity);
			return "ManagementForm";			
		}else{ //返回
			User user = (User)m.getAttribute("user");
			if(user.getStatus()==0) {
				return "empindex";
			}
//			User user = (User)m.getAttribute("user");
			return "userindex";
		}
	}
	
	
	//doeditprofile
	@RequestMapping(path = "/domodify" ,method=RequestMethod.POST )
	public String doModify(@RequestParam("submit") String chose,@RequestParam("nickname") String nickname,
			@RequestParam("password") String password,@RequestParam("id") int id,
			@RequestParam("phone") String phone,@RequestParam("county") String city,
			@RequestParam("district") String township,@RequestParam("road") String road,
			@RequestParam("myfile") MultipartFile file,Model m) throws IllegalStateException, IOException {
		if(chose.equals("確認")) {
			int numcity = tools.getCityNum(city);
			User user = new User(id,password,nickname,phone,numcity,township,road);
			HashMap<String, Message> show = management.checkAll(user);
			if(show.get("result").getCode()==1) {
				m.addAttribute("show",show); //request scope
				return "ManagementForm";
			}else { //驗證通過開始修改
				String filename = file.getOriginalFilename();
				File fullpath = new File(localpath,filename);
				byte[] b = file.getBytes();
				file.transferTo(fullpath);
				if(file.getName()!=null && file.getName().length() !=0) {
					User admin = management.updateUser(user,filename);   		
					//最後一步
//					m.addAttribute("user",admin);
					String path = this.showInform(m);
					return path;
				}
			}
		}
		return "Manegement";
	}
	
	
	//checkdata
	@RequestMapping (path="/check" , method =RequestMethod.POST) // Register.jsp
   public String checkAll(
		   @RequestParam("name") String name,@RequestParam("gender") String gender,
		   @RequestParam("birth") String birth,@RequestParam("account") String account,
		   @RequestParam("password") String password,@RequestParam("phone") String phone,
		   @RequestParam("county") String city,@RequestParam("district") String township,
		   @RequestParam("road") String road,Model m) {
			HashMap<String, Message> show = new HashMap<String, Message>();
			int numgender = tools.getGenderNum(gender);
			Long longbirth = tools.getLongFromString(birth);
			int numcity = tools.getCityNum(city);
			User user = new User(name,numgender, longbirth, account, password, phone, numcity, township, road);
			Message msg = register.checkAccount(user);
			show = register.checkAll(user);
			Message result = show.get("result");
			Message passwordd = show.get("password");
			if(result.getCode() == 0 && msg.getCode() == 0) { //驗證通過
				m.addAttribute("user",user);
				String sgender = tools.getGenderName(user.getGender());
				String scity = tools.getCityName(user.getCity());
				String sbirth = tools.getStringDate(user.getBirth());
				m.addAttribute("sgender",sgender);
				m.addAttribute("scity",scity);
				m.addAttribute("sbirth",sbirth);
				return "DisplayForm";
			}else { //驗證有誤
			    m.addAttribute("show",show);
			    m.addAttribute("account",msg);
			    m.addAttribute("user",user);
				return "RegisterReset";
			}
		}
	
	
	
//insertdata
@RequestMapping (path="/insert" , method =RequestMethod.POST) // DisplayForm.jsp
public String InertCilent(Model m) {
	User user = (User)m.getAttribute("user");
	user.setStatus(1);
	long time = new Date().getTime();
	user.setLogindate(time);
	user.setNickname("尼還沒有設定唷");
	user.setAvatar("images/default.jpg");
	boolean result = register.InsertClient(user);
	if(result) {
		String sgender = tools.getGenderName(user.getGender());
		String scity = tools.getCityName(user.getCity());
		String sbirth = tools.getStringDate(user.getBirth());
		m.addAttribute("sgender",sgender);
		m.addAttribute("scity",scity);
		m.addAttribute("sbirth",sbirth);
		return "userindex";
	}else {
		return "error";
	}
}

@PostMapping(path="checkloginstatus")
public String checkLoginStatus(Model m) {
	User user = (User)m.getAttribute("user");
	if(user != null) {
       if(user.getStatus()==1) {
    	   return "userindex";
       }else {
    	   return "empindex";
       }
	}
	return "login";
}

//login
@RequestMapping (path="/login" , method =RequestMethod.POST) // DisplayForm.jsp
public String Login(@RequestParam("account") String account,@RequestParam String password,Model m) {
	 Message msga = login.checkAccount(account);
	if(msga.getCode()==1) { //帳號不存在
		m.addAttribute("account",account);
		m.addAttribute("password",password);
		m.addAttribute("msga",msga);
		return "LoginReset";
	}else {//帳號存在
		Message msgp = login.cheackPassword(account, password);
		if(msgp.getCode()==1) { //密碼輸入錯誤
			m.addAttribute("account",account);
			m.addAttribute("password",password);
			m.addAttribute("msgp",msgp);
			return "LoginReset";
		}else { //驗證通過
			User admin = new User();
			admin.setAccount(account);
			login.updateDate(admin);
			User user = login.showIndex(account);
			String sgender = user.getGenderName(user.getGender());
			String sbirth = tools.getStringDate(user.getBirth());
			String scity = tools.getCityName(user.getCity());
			m.addAttribute("user",user);
			m.addAttribute("sgender",sgender);
			m.addAttribute("scity",scity);
			m.addAttribute("sbirth",sbirth);
			if(user.getStatus()==0) {
				return "empindex";
			}
			return "userindex";
		}
	}
}

//udatedata
@RequestMapping(path = "/upload",method=RequestMethod.POST)
@ResponseBody
public String uploadImage(@RequestParam("myfile") MultipartFile file) throws IOException {
	String filename = file.getOriginalFilename();
//	String temppath = "C:\\Action\\worksapce\\MySpringMvcProject\\src\\main\\webapp\\WEB-INF\\resources\\images";
	File fullpath = new File(localpath,filename);
	byte[] b = file.getBytes();
	file.transferTo(fullpath); //檔案上傳指定路徑
	System.out.println("fullpath = " + fullpath);
	if(filename !=null && filename.length() !=0) {
		this.savePicture(filename);
	}
		return "savefilepath" + fullpath;		
}

public boolean savePicture(String filename) {
	String usepath="images/"+filename;
	System.out.println(usepath);
	boolean result = management.updateImage(usepath);
	if(result) {
		return true;
	}else {
		return false;
	}
	
}




//checkempdata
@RequestMapping (path="/empcheck" , method =RequestMethod.POST) // empregister.jsp
public String checkEmpAll(
		   @RequestParam("name") String name,@RequestParam("gender") String gender,
		   @RequestParam("birth") String birth,@RequestParam("account") String account,
		   @RequestParam("password") String password,@RequestParam("phone") String phone,
		   @RequestParam("county") String city,@RequestParam("district") String township,
		   @RequestParam("road") String road,Model m) {
			HashMap<String, Message> show = new HashMap<String, Message>();
			int numgender = tools.getGenderNum(gender);
			Long longbirth = tools.getLongFromString(birth);
			int numcity = tools.getCityNum(city);
			User user = new User(name,numgender, longbirth, account, password, phone, numcity, township, road);
			Message msg = register.checkAccount(user);
			show = register.checkAll(user);
			Message result = show.get("result");
			Message passwordd = show.get("password");
			if(result.getCode() == 0 && msg.getCode() == 0) { //驗證通過
				m.addAttribute("user",user);
				String sgender = tools.getGenderName(user.getGender());
				String scity = tools.getCityName(user.getCity());
				String sbirth = tools.getStringDate(user.getBirth());
				m.addAttribute("sgender",sgender);
				m.addAttribute("scity",scity);
				m.addAttribute("sbirth",sbirth);
				return "EmpDisplayForm";
			}else { //驗證有誤
			    m.addAttribute("show",show);
			    m.addAttribute("account",msg);
			    m.addAttribute("user",user);
				return "empRegisterReset";
			}
		}

//insertemp
@RequestMapping (path="/empinsert" , method =RequestMethod.POST) // DisplayForm.jsp
public String InertEmp(Model m) {
	User user = (User)m.getAttribute("user");
	user.setStatus(0); //狀態碼
	long time = new Date().getTime();
	user.setLogindate(time);
	user.setNickname("尼還沒有設定唷");
	user.setAvatar("images/default.jpg");
	boolean result = register.InsertClient(user);
	if(result) {
		String sgender = tools.getGenderName(user.getGender());
		String scity = tools.getCityName(user.getCity());
		String sbirth = tools.getStringDate(user.getBirth());
		m.addAttribute("sgender",sgender);
		m.addAttribute("scity",scity);
		m.addAttribute("sbirth",sbirth);
		return "empindex";
	}else {
		return "error";
	}
}


}
	


