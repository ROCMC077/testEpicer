package tw.epicer.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "Ingredient")
@Component
public class IngredientsBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer IngredientsId;
	@Column(name = "ingredient")
	private String ingredient;
	@Column(name = "amount")
	private String Amount;
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_recipe_id")
	private RecipeBean recipeBean;
	
	
	public IngredientsBean(Integer ingredientsId, String ingredient, String amount, RecipeBean recipeBean) {
		super();
		IngredientsId = ingredientsId;
		this.ingredient = ingredient;
		Amount = amount;
		this.recipeBean = recipeBean;
	}
	public IngredientsBean() {
		super();
	}
	public IngredientsBean(String ingredient, String amount) {
		super();
		this.ingredient = ingredient;
		Amount = amount;
	}
	public IngredientsBean(String ingredient, String amount, RecipeBean recipeBean) {
		super();
		this.ingredient = ingredient;
		Amount = amount;
		this.recipeBean = recipeBean;
	}
	public Integer getIngredientsId() {
		return IngredientsId;
	}
	public void setIngredientsId(Integer ingredientsId) {
		IngredientsId = ingredientsId;
	}
	public String getIngredient() {
		return ingredient;
	}
	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}
	public String getAmount() {
		return Amount;
	}
	public void setAmount(String amount) {
		Amount = amount;
	}
	public RecipeBean getRecipeBean() {
		return recipeBean;
	}
	public void setRecipeBean(RecipeBean recipeBean) {
		this.recipeBean = recipeBean;
	}
	@Override
	public String toString() {
		return "IngredientsBean [IngredientsId=" + IngredientsId + ", ingredient=" + ingredient + ", Amount=" + Amount
				+ "]";
	}

}
