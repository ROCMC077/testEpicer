package tw.epicer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "five_product")
@Component
public class ProductBean {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "product_name")
	private String name;

	@Column(name = "product_description")
	private String description;
	
	@Column(name = "product_category_id")
	private String category;
	
	@Column(name = "unit")
	private String unit;
	
	@Column(name = "price")
	private String price;
	
	@Column(name = "origin")
	private String origin;

	public ProductBean() {
	}
	

	public ProductBean(Integer id) {
		super();
		this.id = id;
	}



	public ProductBean(Integer id, String name, String description, String category, String unit, String price,
			String origin) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.category = category;
		this.unit = unit;
		this.price = price;
		this.origin = origin;
	}




	public ProductBean( String name, String description, String category, String unit, String price,
			String origin) {
		super();
		this.name = name;
		this.description = description;
		this.category = category;
		this.unit = unit;
		this.price = price;
		this.origin = origin;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	

	
	
}
