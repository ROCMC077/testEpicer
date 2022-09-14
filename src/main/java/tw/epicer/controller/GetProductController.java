package tw.epicer.controller;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import tw.epicer.model.CartProduct;
import tw.epicer.service.GetCartProductService;

@Controller
public class GetProductController {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	private GetCartProductService getProductService;
	
	//進入商品頁網址: http://localhost:8080/SpringShoppingCart/productlistcart
	@GetMapping("/productlistcart")
	private String QueryAll(Model m) {
		List<CartProduct> beans=getProductService.selectAll();
		m.addAttribute("queryall",beans);
		return "ShopProduct";
	}
	

}
