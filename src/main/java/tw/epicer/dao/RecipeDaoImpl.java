package tw.epicer.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tw.epicer.model.RecipeBean;

@Repository
@Transactional
public class RecipeDaoImpl implements RecipeDao{
	@Autowired
	private SessionFactory factory;
	
	@Override
	public RecipeBean addRecipe(RecipeBean recipeBean) {
		Session session = factory.openSession();
//		Session session = factory.getCurrentSession();
			session.save(recipeBean);
			session.close();
			return recipeBean;
		
	}

	@Override
	public boolean deleteRecipeById(Integer id) {
		Session session = factory.openSession();
//		Session session = factory.getCurrentSession();
		RecipeBean recipeBean = session.get(RecipeBean.class, id);
		if (recipeBean!=null) {
			session.delete(recipeBean);
			session.flush();
			session.close();
			return true;
		}
		session.close();
		return false;
	}

	@Override
	public RecipeBean updateRecipe(RecipeBean recipeBean, Integer id) {
		
		Session session = factory.openSession();
//		Session session = factory.getCurrentSession();
		RecipeBean recipeBean2 = session.get(RecipeBean.class, id);
		if (recipeBean2!=null) {
			recipeBean2.setRecipeName(recipeBean.getRecipeName());
			recipeBean2.setImgPath(recipeBean.getImgPath());
			recipeBean2.setRecipeDescription(recipeBean.getRecipeDescription());
			recipeBean2.setCookTime(recipeBean.getCookTime());
			recipeBean2.setHowManyPeople(recipeBean.getHowManyPeople());
			recipeBean2.setIngredients(recipeBean.getIngredients());
			recipeBean2.setSteps(recipeBean.getSteps());
			recipeBean2.setIngredients(recipeBean.getIngredients());
			recipeBean2.setSteps(recipeBean.getSteps());
			session.flush();
			session.close();
			return recipeBean2;
		}
		session.close();
		return null;
	}

	@Override
	public RecipeBean queryRecipeById(Integer id) {
		Session session = factory.openSession();
//		Session session = factory.getCurrentSession();
		RecipeBean recipeBean = session.get(RecipeBean.class, id);
		session.close();
		return recipeBean;
	}

	@Override
	public List<RecipeBean> queryAllRecipes() {
		Session session = factory.openSession();
//		Session session = factory.getCurrentSession();
		Query<RecipeBean> query=session.createQuery("from RecipeBean",RecipeBean.class);
		List<RecipeBean> resultList = query.getResultList();
		session.close();
		return resultList;
	}

	@Override
	public List<RecipeBean> queryRecipesByname(String name) {
		Session session = factory.openSession();
//		Session session = factory.getCurrentSession();
		String hql = "from RecipeBean where name like '%"+name+"%'";
		Query<RecipeBean> query= session.createQuery(hql, RecipeBean.class);
		List<RecipeBean> resultList = query.getResultList();
		session.close();
		return resultList;
	}
	

}
