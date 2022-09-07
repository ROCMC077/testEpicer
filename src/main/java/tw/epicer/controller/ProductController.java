package tw.epicer.controller;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tw.epicer.model.ProductBean;
import tw.epicer.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	ProductService productService;


	@GetMapping("/productlist")
	private String QueryAll(Model m) {
		List<ProductBean> beans=productService.selectProductAll();
		m.addAttribute("queryall",beans);
		return "DisplayProduct";
	}

	@GetMapping("/DisplayProduct_searchCategory")
	private String QueryProductCategory(Model m,@RequestParam ("category_id") String category ) {
			List<ProductBean> beans=productService.searchCategory(category);
			m.addAttribute("searchCategory",beans);
			return "DisplayProduct_searchCategory";
		
	}
	
	@GetMapping("/ProductManager")
	public String insertProduct() {
		return "ProductManager";
	}

	
	@PostMapping("/insertProductAction")
	public String insertProductAction(ProductBean bean) {
		productService.insertProduct(bean);
		return "ProductManager_insertConfirm";
	}
	

	@PostMapping("/updateProduct")
	public String updateProduct(ProductBean bean) {
		return "ProductManager_updateConfirm";
	}
	
	@PostMapping("/updateProductAction")
	public String updateProductAction(ProductBean bean) {
		productService.updateProduct(bean.getId(), bean);
		return "redirect:productlist";
	}
	
	@PostMapping("/deleteProduct")
	public String deleteProduct(ProductBean bean) {
		return"ProductManager_deleteConfirm";
	}
	
	@PostMapping("/deleteProductAction")
	public String deleteProductAction(ProductBean bean) {
		System.out.println(bean);
		productService.deleteProduct(bean.getId());
		return "redirect:productlist";
	}
	

}
