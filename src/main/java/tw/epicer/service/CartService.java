package tw.epicer.service;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.epicer.dao.CartDao;
import tw.epicer.model.Cart;
import tw.epicer.model.CartProduct;

@Service
@Transactional
public class CartService {

	@Autowired
	private CartDao cDao;

	// 查詢購物車內容
	public Cart checkItemList(Integer userId, Integer productId) {
		System.out.println("Service checkItem:" + userId + "and" + productId);
		return cDao.checkItemList(userId, productId);
	}

	// 新增商品到購物車
	public Cart insertCart(Cart cBean) {
		return cDao.insertCart(cBean);
	}

	// 新增商品到購物車後，查詢Cart Id
	public Integer selectCartId(Integer userId, Integer productId) {
		System.out.println("Service selectCartID-userId:" + userId + "and productId" + productId);
		return cDao.selectCartId(userId, productId);
	}

	// 更新(Update)
	public void updateCart(Integer id, Integer userId, Integer productId, Integer quantity) {
		cDao.updateCart(id, userId, productId, quantity);
	}

	// 查購物車資訊
	public List<Cart> selectById(Integer userId) {
		return cDao.selectById(userId);
	}

	// 刪除購物車品項(by cartId)
	public boolean deleteByCartId(Integer cartId) {
		return cDao.deleteByCartId(cartId);
	}

	// 計算購物車商品總數量(變動)
	public Integer totalCartQuantity(Integer userId) {
		List<Cart> list = cDao.selectById(userId);
		int totalCartQuant=0;
		for(Cart cart: list) {
			Integer amount = cart.getQuantity();
			totalCartQuant += amount;
		}
		System.out.println(totalCartQuant);
		return totalCartQuant;
	}

	// 計算購物車商品總金額(變動)
	public Integer totalCartPrice(Integer userId) {
		List<Cart> list = cDao.selectById(userId);
		int totalCartPrice=0;
		for(Cart cart: list) {
			Integer amount = cart.getQuantity();
			Integer price = cart.getCartProduct().getPrice();
			totalCartPrice += (amount*price);
		}
		System.out.println(totalCartPrice);
		return totalCartPrice;
	}
}
