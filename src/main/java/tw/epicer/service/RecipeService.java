package tw.epicer.service;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.epicer.dao.IngredientsDao;
import tw.epicer.dao.RecipeDao;
import tw.epicer.dao.StepDao;
import tw.epicer.model.IngredientsBean;
import tw.epicer.model.RecipeBean;
import tw.epicer.model.Step;

@Service
@Transactional
public class RecipeService implements ReciepeServiceInterface{

	@Autowired
	@Qualifier("recipeDaoImpl")
	private RecipeDao recipeDao  ;
	
	@Autowired
	@Qualifier("ingredientsDaoImpl")
	private IngredientsDao ingredientsDao ;
	
	@Autowired
	@Qualifier("stepDaoImpl")
	private StepDao stepDao ;
	
	
	
	@Override
	public void addRecipe(RecipeBean recipeBean,Set<IngredientsBean> set, Set<Step> stepSet) {
		Iterator<IngredientsBean> iterator = set.iterator();
		while(iterator.hasNext()) {
			IngredientsBean ingredientsBean = iterator.next();
			ingredientsBean.setRecipeBean(recipeBean);
		}
		Iterator<Step> stepIterator = stepSet.iterator();
		while(stepIterator.hasNext()) {
			Step step = stepIterator.next();
			step.setRecipeBean(recipeBean);
		}
		recipeBean.setIngredients(set);
		recipeBean.setSteps(stepSet);
		recipeDao.addRecipe(recipeBean);
	}


	@Override
	public boolean deleteRecipe(Integer id) {
		
		return	recipeDao.deleteRecipeById(id);
	}

	@Override
	public List<RecipeBean> queryAll() {
		
		return recipeDao.queryAllRecipes();
	}

	@Override
	public List<RecipeBean> queryForName(String name) {

		return  recipeDao.queryRecipesByname(name);
	}

	@Override
	public RecipeBean queryRecipeForId(Integer id) {

		return recipeDao.queryRecipeById(id);
	}


	@Override
	public RecipeBean updateRecipe(Integer id, RecipeBean recipeBean) {

		return recipeDao.updateRecipe(recipeBean, id);
	}


	@Override
	public IngredientsBean updateIngredient(Integer id, IngredientsBean ingredientsBean) {

		return ingredientsDao.updateIngredient(id, ingredientsBean);
	}


	@Override
	public Step updateStep(Integer id, Step step) {

		return stepDao.updateStepByRecipeId(id, step);
	}




	@Override
	public List<IngredientsBean> queryIngredientsForId(Integer id) {
		
		
		return ingredientsDao.queryIngredientsByRecipeId(id);
	}


	@Override
	public List<Step> queryStepsForId(Integer id) {
		return stepDao.queryStepsByRecipeId(id);
	}


}
