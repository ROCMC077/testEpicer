package tw.epicer.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tw.epicer.model.Step;

@Repository
@Transactional
public class StepDaoImpl implements StepDao{
	@Autowired
	private SessionFactory factory;
	@Override
	public void addSteps(Step step) {
		Session session = factory.openSession();
//		Session session = factory.getCurrentSession();
		session.save(step);
		session.close();
	}
	@Override
	public int deleteStepsByRicipeId(Integer id) {
		Session session = factory.openSession();
//		Session session = factory.getCurrentSession();
		Step step = session.get(Step.class, id);
		if (step!=null) {
			session.delete(step);
			session.flush();
			session.close();
			return 1;
		}
		session.close();
		return 0;
	}
	@Override
	public List<Step> queryStepsByRecipeId(Integer id) {
		Session session = factory.openSession();
//		Session session = factory.getCurrentSession();
		String hql = "from Step  where fk_recipe_id  = :id";
		Query<Step> query = session.createQuery(hql, Step.class).setParameter("id", id);
		List<Step> resultList = query.getResultList();
		session.close();
		return resultList;
	}
	@Override
	public Step updateStepByRecipeId(Integer id,Step step) {
		Session session = factory.openSession();
//		Session session = factory.getCurrentSession();
		Step step2 = session.get(Step.class,id);
		if (step2!=null) {
			step2.setStep(step.getStep());
			session.flush();
			session.close();
			return step2;
		}
		session.close();
		return null;
	}
	


}


