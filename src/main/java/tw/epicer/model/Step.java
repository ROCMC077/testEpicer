package tw.epicer.model;

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
@Table(name = "step")
@Component
public class Step {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "step")
	private String step;
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_recipe_id")
	private RecipeBean recipeBean;
	public Step(String step, RecipeBean recipeBean) {
		super();
		this.step = step;
		this.recipeBean = recipeBean;
	}
	public Step(String step) {
		super();
		this.step = step;
	}
	public Step() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStep() {
		return step;
	}
	public void setStep(String step) {
		this.step = step;
	}
	public RecipeBean getRecipeBean() {
		return recipeBean;
	}
	public void setRecipeBean(RecipeBean recipeBean) {
		this.recipeBean = recipeBean;
	}
	@Override
	public String toString() {
		return "Step [step=" + step + ", recipeBean=" + recipeBean + "]";
	}
}
