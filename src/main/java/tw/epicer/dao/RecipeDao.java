package tw.epicer.dao;

import java.util.List;

import tw.epicer.model.RecipeBean;


public interface RecipeDao {

	public RecipeBean addRecipe(RecipeBean recipeBean);
	
	public boolean deleteRecipeById(Integer id);
	
	public RecipeBean updateRecipe(RecipeBean recipeBean,Integer id);
	
	public RecipeBean queryRecipeById(Integer id);
	
	public List<RecipeBean> queryAllRecipes();
	
	public List<RecipeBean> queryRecipesByname(String name);
	
	
}
