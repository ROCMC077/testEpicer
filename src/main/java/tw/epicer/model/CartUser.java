package tw.epicer.model;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

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
@Table(name = "AllUsers")
@Component
public class CartUser {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "user_account")
	private String userAccount;

	@Column(name = "user_password")
	private String userPwd;

	@Column(name = "user_name")
	private String userName;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cartUser", cascade = CascadeType.ALL)
	private Set<Cart> carts =new LinkedHashSet<Cart>();
	
	//一個用戶對多個購物車內容
//	@OneToMany(mappedBy = "cartUser", cascade = CascadeType.ALL)
//	private List<Cart> cartItems;
	

	public CartUser() {
	}

	public CartUser(Integer id, String userAccount, String userPwd, String userName) {
		super();
		this.id = id;
		this.userAccount = userAccount;
		this.userPwd = userPwd;
		this.userName = userName;
	}

	public CartUser(String userAccount, String userPwd, String userName) {
		super();
		this.userAccount = userAccount;
		this.userPwd = userPwd;
		this.userName = userName;
	}

	public CartUser(String userAccount, String userPwd) {
		super();
		this.userAccount = userAccount;
		this.userPwd = userPwd;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Set<Cart> getCarts() {
		return carts;
	}

	public void setCarts(Set<Cart> carts) {
		this.carts = carts;
	}

//	public List<Cart> getCartItems() {
//		return cartItems;
//	}
//
//	public void setCartItems(List<Cart> cartItems) {
//		this.cartItems = cartItems;
//	}

}
