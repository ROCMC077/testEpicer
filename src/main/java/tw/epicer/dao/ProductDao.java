package tw.epicer.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tw.epicer.model.ProductBean;

@Repository
@Transactional
public class ProductDao   {

	@Autowired
	private SessionFactory sessionFactory;


	public List<ProductBean> selectProductAll() {
		Session session = sessionFactory.openSession();
//		Session session = sessionFactory.getCurrentSession();
		Query<ProductBean> query = session.createQuery("from ProductBean", ProductBean.class);
		List<ProductBean> beans=query.list();
		session.close();
		return beans;
	}

	public ProductBean insertProduct(ProductBean productData) {
		Session session = sessionFactory.openSession();

		if (productData != null) {
			session.save(productData);
			System.out.println("新增成功");
			session.close();
			return productData;
		}
		session.close();
		return null;
	}

	public ProductBean updateProduct(Integer id,ProductBean productData) {
		Session session = sessionFactory.openSession();
		ProductBean productBean = session.get(ProductBean.class, id);

		if (productBean != null) {
			productBean.setName(productData.getName());
			productBean.setDescription(productData.getDescription());
			productBean.setCategory(productData.getCategory());
			productBean.setUnit(productData.getUnit());
			productBean.setPrice(productData.getPrice());
			productBean.setOrigin(productData.getOrigin());
			System.out.println("修改成功");
			session.flush();
			session.close();
			return productData;
		}
		session.close();
		return null;
	}

	public boolean deleteProduct(Integer id) {
		Session session = sessionFactory.openSession();
//		Session session = sessionFactory.getCurrentSession();
		
		ProductBean productBean = session.get(ProductBean.class, id);

		if (productBean != null) {
			System.out.println(productBean.getId());
			session.delete(productBean);
			System.out.println("刪除成功");
			session.flush();
			session.close();
			return true;
		}
		session.close();
		return false;
	}

	public List<ProductBean> searchCategory(String category) {
		Session session = sessionFactory.openSession();

		String hql = "from ProductBean p where p.category = :category ";

		List<ProductBean> result = session.createQuery(hql, ProductBean.class).setParameter("category", category)
				.getResultList();
		List<ProductBean> beans=result;
		session.close();
		return beans;
	}



}
