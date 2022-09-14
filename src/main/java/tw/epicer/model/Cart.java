package tw.epicer.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "six_cart_product")
@Component
public class Cart implements Serializable {

	@Id @Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
//	@Column(name = "fk_user_id")
//	private Integer userId;
	
//	@Column(name = "fk_product_id")
//	private Integer productId;
	
	@Column(name = "quantity")
	private Integer quantity;
	
	@ManyToOne
	@JoinColumn(name = "fk_user_id")
	//@Column(name = "fk_user_id")
	private CartUser cartUser;
	
	@ManyToOne
	@JoinColumn(name = "fk_product_id")
	//@Column(name = "fk_product_id")
	private CartProduct cartProduct;
	
//	private Integer totalCartQuantity;
//	private Integer totalCartPrice;
	
	public Cart() {
	}
	
	public Cart(Integer id, Integer quantity, CartUser cartUser, CartProduct cartProduct) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.cartUser = cartUser;
		this.cartProduct = cartProduct;
	}

	public Cart(CartUser cartUser, CartProduct cartProduct, Integer quantity) {
		super();
		this.quantity = quantity;
		this.cartUser = cartUser;
		this.cartProduct = cartProduct;
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

//	public Integer getUserId() {
//		return userId;
//	}
//
//	public void setUserId(Integer userId) {
//		this.userId = userId;
//	}
//
//	public Integer getProductId() {
//		return productId;
//	}
//
//	public void setProductId(Integer productId) {
//		this.productId = productId;
//	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	@Override
	public String toString() {
		return "Cart [id=" + id + ", quantity=" + quantity + ", cartUser=" + cartUser + ", cartProduct=" + cartProduct
				+ "]";
	}

	public CartUser getCartUser() {
		return cartUser;
	}

	public void setCartUser(CartUser cartUser) {
		this.cartUser = cartUser;
	}

	public CartProduct getCartProduct() {
		return cartProduct;
	}

	public void setCartProduct(CartProduct cartProduct) {
		this.cartProduct = cartProduct;
	}
}
