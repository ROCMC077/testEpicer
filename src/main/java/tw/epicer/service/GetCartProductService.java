package tw.epicer.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.epicer.dao.GetCartProductDao;
import tw.epicer.model.CartProduct;

@Service
@Transactional
public class GetCartProductService {

	
	@Autowired
	private GetCartProductDao getProductDao;
	
	public List<CartProduct> selectAll() {
		return getProductDao.selectAll();
	}
}
