package tw.epicer.dao;

import java.util.List;

import tw.epicer.model.IngredientsBean;


public interface IngredientsDao {
	
		
		public void addIngredients(IngredientsBean ingredientsBean);
		
		public int deleteIngredientsByRicipeId(Integer id);
		
		public List<IngredientsBean> queryIngredientsByRecipeId(Integer id);
		
		public IngredientsBean updateIngredient(Integer id, IngredientsBean ingredientsBean);
		
		
	}