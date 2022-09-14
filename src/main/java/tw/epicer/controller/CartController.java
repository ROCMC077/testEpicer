package tw.epicer.controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import tw.epicer.model.Cart;
import tw.epicer.model.CartProduct;
import tw.epicer.model.CartUser;
import tw.epicer.service.CartService;

@Controller
//@SessionAttributes= {userid}
public class CartController {
	
//	@Autowired
//	SessionFactory sessionFactory;
	
	@Autowired
	private CartService cService;
	
	//@PostMapping(path = "/addCart.controller")
	@RequestMapping(path = "/addcart.controller", method = RequestMethod.POST)
	public String processItemCheckAction(@RequestParam("userid") Integer userId, @RequestParam("productid") Integer productId,
			@RequestParam("quantity") Integer quantity,Model m){

		CartUser cu = new CartUser();
		cu.setId(userId);
		CartProduct cp = new CartProduct();
		cp.setId(productId);
		Cart c1 = new Cart(cu, cp, quantity);
		
		
		//先查詢購物車是否有重複userId+productId->if有，則查出cartId然後修改;if無，則新增
		if(cService.checkItemList(userId, productId)!= null) {
			System.out.println("gotoUpdate");
			
			Integer id = cService.selectCartId(userId, productId);
			c1.setId(id);
			m.addAttribute("userid",id);
			System.out.println("Get cart id: "+c1.getId());
			System.out.println(c1);
;			cService.updateCart(c1.getId(), userId, productId, quantity);
		}else {
			System.out.println("gotoAddCart");
			cService.insertCart(c1);
		}
		return "redirect:/productlistcart"; //去新的controller才要用redirect:/
	
	}
	
	//進入購物車網址: http://localhost:8080/SpringShoppingCart/gotocart.controller
	@GetMapping(path = "/gotocart.controller")
	private String gotoCart(Model m) {

		List<Cart> beans= cService.selectById(10);
		
		Integer tQuantity = cService.totalCartQuantity(10);
		Integer tPrice = cService.totalCartPrice(10);
		System.out.println("totalCartQuantity:" +tQuantity +"totalCartPrice:" + tPrice);
		m.addAttribute("queryById",beans);
		m.addAttribute("tQuantity",tQuantity);
		m.addAttribute("tPrice",tPrice);
		return "ShoppingCartPage";
	}
	
	@GetMapping("/deleteCartItem")
	public String deleteCartItem(@RequestParam("cartId") Integer cartId) {
		System.out.println("gotoDelete");
		cService.deleteByCartId(cartId);
		
		return "redirect:/gotocart.controller";
	}
	


}
