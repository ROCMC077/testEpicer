package tw.epicer.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.epicer.dao.ProductDao;
import tw.epicer.model.ProductBean;

@Service
@Transactional
public class ProductService  {
	
	@Autowired
	private ProductDao productDao;


	public List<ProductBean> selectProductAll() {
		return productDao.selectProductAll();
	}

	public ProductBean insertProduct(ProductBean productData) {
		return productDao.insertProduct(productData);
	}

	public ProductBean updateProduct(Integer id,ProductBean productData) {
		return productDao.updateProduct(id,productData);
	}

	public boolean deleteProduct(Integer id) {
		return productDao.deleteProduct(id);
	}

	public List<ProductBean> searchCategory(String category) {
		return productDao.searchCategory(category);
	}


}
