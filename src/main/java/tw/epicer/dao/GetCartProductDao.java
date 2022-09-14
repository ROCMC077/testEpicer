package tw.epicer.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tw.epicer.model.CartProduct;

@Repository
@Transactional
public class GetCartProductDao {
	
	//建立連線
	@Autowired
	private SessionFactory sessionFactory;
	
	
	//查詢單筆
	public CartProduct selectOneProduct(Integer productId) {
		Session session = sessionFactory.openSession();
		
		CartProduct resultBean = session.get(CartProduct.class, productId);
		
		session.close();
		return resultBean;
	}
	
	// 查詢全部
	public List<CartProduct> selectAll() {
		Session session = sessionFactory.openSession();
		boolean open = session.isOpen();
		System.out.println(open);
//		Query<ProductBean> query= session.createQuery("from ProductBean", ProductBean.class);
		Query<CartProduct> query = session.createQuery("from CartProduct", CartProduct.class);
		List<CartProduct> bean = query.list();
		session.close();
		return bean;
	}

}
