package tw.epicer.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tw.epicer.model.IngredientsBean;

@Repository
@Transactional
public class IngredientsDaoImpl  implements IngredientsDao{
	@Autowired
	private SessionFactory factory;
	@Override
	public void addIngredients(IngredientsBean ingredientsBean) {
		Session session = factory.openSession();
//		Session session = factory.getCurrentSession();
		session.save(ingredientsBean);
		session.close();
	}

	@Override
	public int deleteIngredientsByRicipeId(Integer id) {
		Session session = factory.openSession();
//		Session session = factory.getCurrentSession();
		IngredientsBean ingredientsBean = session.get(IngredientsBean.class, id);
		if(ingredientsBean!=null) {
			session.delete(ingredientsBean);
			session.flush();
			session.close();
			return 1;
		}
		session.close();
		return 0;
	}

	@Override
	public List<IngredientsBean> queryIngredientsByRecipeId(Integer id) {
//		Session session = factory.getCurrentSession();
		Session session = factory.openSession();
		String hql = "from IngredientsBean where fk_recipe_id  = :id";
		Query<IngredientsBean> query= session.createQuery(hql, IngredientsBean.class)
				.setParameter("id",	id);
		
		List<IngredientsBean> resultList = query.getResultList();
		session.close();
		return resultList ;
	}
	@Override
	public IngredientsBean updateIngredient(Integer id, IngredientsBean ingredientsBean) {
		Session session = factory.openSession();
//		Session session = factory.getCurrentSession();
		IngredientsBean ingredientsBean2 = session.get(IngredientsBean.class, id);
		if (ingredientsBean2!=null) {
			ingredientsBean2.setIngredient(ingredientsBean.getIngredient());
			ingredientsBean2.setAmount(ingredientsBean.getAmount());
			session.flush();
			session.close();
			return ingredientsBean2;
		}
		session.close();
		return null;
		
	}

	
}
