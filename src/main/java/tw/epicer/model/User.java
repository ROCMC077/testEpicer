package tw.epicer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="users")
public class User {
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="user_status")
	private int status;
	
	@Column(name="user_account")
	private String account;
	
	@Column(name="user_password")
	private String password;
	
	@Column(name="user_name")
	private String name;
	
	@Column(name="user_nickname")
	private String nickname;
	
	@Column(name="user_gender")
	private int gender;

	@Column(name="user_avatar")
	private String avatar;
	
	@Column(name="user_birth")
	private long birth;
	
	@Column(name="user_phone")
	private String phone;
	
	@Column(name="user_address_city")
	private int city;
	
	@Column(name="user_address_township")
	private String township;
	
	@Column(name="user_address_road")
	private String road;
	
	@Column(name="user_logindate")
	private long logindate;
	
	public User() {
	}

	
	
	
	
	public User(String name,int gender,long birth,String account, String password,  String phone, int city,
			String township, String road) {
		super();
		this.account = account;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.birth = birth;
		this.phone = phone;
		this.city = city;
		this.township = township;
		this.road = road;
	}





	public User(int id,String password, String nickname, String phone, int city, String township, String road) {
		super();
		this.id=id;
		this.password = password;
		this.nickname = nickname;
		this.phone = phone;
		this.city = city;
		this.township = township;
		this.road = road;
	}





	public User(int status, String account, String password, String name, int gender, long birth, String phone,
			int city, String township, String road) {
		super();
		this.status = status;
		this.account = account;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.birth = birth;
		this.phone = phone;
		this.city = city;
		this.township = township;
		this.road = road;
	}

	public User(String account, String password) {
		super();
		this.account = account;
		this.password = password;
	}

	public User(int id, int status, String account, String password, String name, String nickname, int gender,
			String avatar, long birth, String phone, int city, String township, String road, long logindate) {
		super();
		this.id = id;
		this.status = status;
		this.account = account;
		this.password = password;
		this.name = name;
		this.nickname = nickname;
		this.gender = gender;
		this.avatar = avatar;
		this.birth = birth;
		this.phone = phone;
		this.city = city;
		this.township = township;
		this.road = road;
		this.logindate = logindate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public long getBirth() {
		return birth;
	}

	public void setBirth(long birth) {
		this.birth = birth;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getCity() {
		return city;
	}

	public void setCity(int city) {
		this.city = city;
	}

	public String getTownship() {
		return township;
	}

	public void setTownship(String township) {
		this.township = township;
	}

	public String getRoad() {
		return road;
	}

	public void setRoad(String road) {
		this.road = road;
	}

	public long getLogindate() {
		return logindate;
	}

	public void setLogindate(long logindate) {
		this.logindate = logindate;
	}
	
	public String getGenderName(int gender) {
	    String gendername =" ";
		if(gender == 1) {
			gendername="女性";
			return gendername;
		}else {
			gendername="男性";
			return gendername;
		}
	}


	public int getGenderNum(String gendername) {
		int gendernum =3; // 男0 女1 預設性別編碼3，不存在
		if(gendername.equals("男性")) {
			gendernum = 0;
			return gendernum;
		}else {
			gendernum = 1;
			return gendernum;
		}
	}


		public String getCityName(int city) {
			String cityname=" ";
	        String[]  allcities = {"基隆市","臺北市","新北市",
	        		"桃園市","新竹市","新竹縣","苗栗縣","臺中市","彰化縣","南投縣",
	        		"雲林縣","嘉義市","嘉義縣","臺南市","高雄市","屏東縣","臺東縣","花蓮縣","宜蘭縣","澎湖縣","金門縣","連江縣"};
	        cityname += allcities[(city-1)];
	        String ncityname = cityname.trim();
	        return ncityname;
	}
	
	
	

	
	
}
