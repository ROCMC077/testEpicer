package tw.epicer.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tw.epicer.model.Cart;
import tw.epicer.model.CartProduct;
import tw.epicer.model.CartUser;

@Repository
@Transactional
public class CartDao {

	// 建立連線
	@Autowired
	private SessionFactory sessionFactory;

	//查詢購物車內容 - 是否有重複物件 (hibernate正規寫法)
	public Cart checkItemList(Integer userId, Integer productId) {
		System.out.println("checkInDao:userID" + userId + "and productID: " + productId);
		Session session = sessionFactory.openSession();

		String hql = "from Cart where cartUser = :uId and cartProduct = :pId ";
		CartUser cu = new CartUser();
		cu.setId(userId);
		CartProduct cp = new CartProduct();
		cp.setId(productId);
		Query<Cart> query = session.createQuery(hql, Cart.class);
		query.setParameter("uId", cu);
		query.setParameter("pId", cp);
		Cart result = query.uniqueResult();
		
		session.close();
		if(result != null) {
			return result;
		}
		return null;
		
	}
	
	//新增商品到購物車
	public Cart insertCart(Cart cBean) {
		Session session = sessionFactory.openSession();
		
		if(cBean != null) {
			session.save(cBean);
		}
		session.close();
		return cBean;
	}
	
	//新增商品到購物車後，查詢Cart Id
	public Integer selectCartId(Integer userId, Integer productId) {
		Session session = sessionFactory.openSession();

		CartUser cu = new CartUser();
		cu.setId(userId);
		CartProduct cp = new CartProduct();
		cp.setId(productId);
		
		String hql = " from Cart where cartUser = :uId and cartProduct = :pId ";
		 Cart cart = session.createQuery(hql, Cart.class)
		.setParameter("uId", cu)
	    .setParameter("pId", cp)
	    .uniqueResult();
		 Integer id = cart.getId();
		System.out.println("CartId: "+ id);
		
		session.close();
		return id;
	}

	//更新(Update)
		public void updateCart(Integer id, Integer userId, Integer productId, Integer quantity) {
			Session session = sessionFactory.openSession();
			
			Cart cart = session.get(Cart.class, id);
			Integer oldqua = cart.getQuantity();
			Integer q1 = oldqua+1;
			
			cart.setQuantity(q1);
			
			session.update(cart);
			session.flush();
			session.close();
		}
	
	// 查詢全部購物車內容(在CartPage.jsp)
	public List<Cart> selectById(Integer userId) {
		Session session = sessionFactory.openSession();
//		Cart cart = session.get(Cart.class, userId);
		boolean open = session.isOpen();
		System.out.println(open);
		CartUser cu = new CartUser();
		cu.setId(userId);
		List<Cart> query = session.createQuery("from Cart where cartUser = :uId", Cart.class)
				.setParameter("uId", cu)
				.getResultList();
		session.close();
		return query;
	}
	
	//刪除購物車品項(by cartId)
	public boolean deleteByCartId(Integer cartId) {
		Session session = sessionFactory.openSession();
		
		Cart cart = new Cart();
		cart.setId(cartId);
		
		if(cart != null) {
			session.delete(cart);
			session.flush();
			return true;
		}
		
		System.out.println("delete finished!!");
		session.close();
		return false;
	}
	
	
	

}
