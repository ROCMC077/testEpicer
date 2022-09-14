package tw.epicer.service;

import java.util.List;
import java.util.Set;

import tw.epicer.model.IngredientsBean;
import tw.epicer.model.RecipeBean;
import tw.epicer.model.Step;


public interface ReciepeServiceInterface {

	public void addRecipe(RecipeBean recipeBean,Set<IngredientsBean> set, Set<Step> stepSet);
	
	public RecipeBean updateRecipe(Integer id, RecipeBean recipeBean);
	
	public IngredientsBean updateIngredient(Integer id, IngredientsBean ingredientsBean);
	
	public Step updateStep(Integer id , Step step);
	
	public boolean deleteRecipe(Integer id);
	
	public List<RecipeBean> queryAll();
	
	public List<RecipeBean> queryForName(String name);
	
	public RecipeBean queryRecipeForId(Integer id);
	
	public List<IngredientsBean> queryIngredientsForId( Integer id);
	
	public List<Step> queryStepsForId(Integer id);
	
	
}
