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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "Recipe")
@Component
public class RecipeBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer recipeId;
	@Column(name = "name")
	private String recipeName;
	@Column(name = "image")
	private String imgPath;
	@Column(name = "description")
	private String recipeDescription;
	@Column(name = "cookTime")
	private String cookTime;
	@Column(name = "howManyPeople")
	private String howManyPeople;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "recipeBean", cascade = CascadeType.ALL)
	private Set<IngredientsBean> ingredients = new LinkedHashSet<IngredientsBean>();
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "recipeBean", cascade = CascadeType.ALL)
	private Set<Step> steps = new LinkedHashSet<Step>();


	public RecipeBean(String recipeName, String imgPath, String recipeDescription, String cookTime,
			String howManyPeople) {
		super();
		this.recipeName = recipeName;
		this.imgPath = imgPath;
		this.recipeDescription = recipeDescription;
		this.cookTime = cookTime;
		this.howManyPeople = howManyPeople;
	}

	public RecipeBean(String recipeName, String imgPath, String recipeDescription, String cookTime,
			String howManyPeople, Set<IngredientsBean> ingredients) {
		super();

		this.recipeName = recipeName;
		this.imgPath = imgPath;
		this.recipeDescription = recipeDescription;
		this.cookTime = cookTime;
		this.howManyPeople = howManyPeople;
		this.ingredients = ingredients;
	}

	public RecipeBean() {
		super();
	}

	public Integer getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(Integer recipeId) {
		this.recipeId = recipeId;
	}

	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public String getRecipeDescription() {
		return recipeDescription;
	}

	public void setRecipeDescription(String recipeDescription) {
		this.recipeDescription = recipeDescription;
	}

	public String getCookTime() {
		return cookTime;
	}

	public void setCookTime(String cookTime) {
		this.cookTime = cookTime;
	}

	public String getHowManyPeople() {
		return howManyPeople;
	}

	public void setHowManyPeople(String howManyPeople) {
		this.howManyPeople = howManyPeople;
	}

	public Set<IngredientsBean> getIngredients() {
		return ingredients;
	}

	public void setIngredients(Set<IngredientsBean> ingredients) {
		this.ingredients = ingredients;
	}

	public Set<Step> getSteps() {
		return steps;
	}

	public void setSteps(Set<Step> steps) {
		this.steps = steps;
	}

	@Override
	public String toString() {
		return "RecipeBean [recipeId=" + recipeId + ", recipeName=" + recipeName + ", imgPath=" + imgPath
				+ ", recipeDescription=" + recipeDescription + ", cookTime=" + cookTime + ", howManyPeople="
				+ howManyPeople + ", steps=" + steps + "]";
	}

}
