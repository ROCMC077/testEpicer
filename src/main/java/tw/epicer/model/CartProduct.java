package tw.epicer.model;

import java.io.Serializable;
import java.util.LinkedHashSet;
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
@Table(name = "product")
@Component
public class CartProduct implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "product_description")
	private String productDiscription;

	// product_category_id 先跳過(FK)
	@Column(name = "product_category_id")
	private String productCategory;
	
	@Column(name = "unit")
	private String unit;

	@Column(name = "price")
	private Integer price;

	@Column(name = "origin")
	private String origin;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cartProduct", cascade = CascadeType.ALL)
	private Set<Cart> carts =new LinkedHashSet<Cart>();
	
//	@OneToMany(mappedBy = "cartProduct", cascade = CascadeType.ALL)
//	private List<Cart> cartsList;

	public CartProduct() {
	}

	public CartProduct(Integer id, String productName, String productDiscription, String productCategory, String unit,
		Integer price, String origin) {
	super();
	this.id = id;
	this.productName = productName;
	this.productDiscription = productDiscription;
	this.productCategory = productCategory;
	this.unit = unit;
	this.price = price;
	this.origin = origin;
}

	public CartProduct(Integer id, String productName, String unit, Integer price) {
		super();
		this.id = id;
		this.productName = productName;
		this.unit = unit;
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDiscription() {
		return productDiscription;
	}

	public void setProductDiscription(String productDiscription) {
		this.productDiscription = productDiscription;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public Set<Cart> getCarts() {
		return carts;
	}

	public void setCarts(Set<Cart> carts) {
		this.carts = carts;
	}

//	public List<Cart> getCartsList() {
//		return cartsList;
//	}
//
//	public void setCartsList(List<Cart> cartsList) {
//		this.cartsList = cartsList;
//	}

}
