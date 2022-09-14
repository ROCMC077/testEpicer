package tw.epicer.controller;

import java.util.List;

import org.hibernate.type.IntegerType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tw.epicer.model.RecipeBean;
import tw.epicer.service.ReciepeServiceInterface;

@Controller
public class RemoveController {
	@Autowired
	@Qualifier("recipeService")
	private ReciepeServiceInterface recipeService;
	@PostMapping("/delete.controller")
	public String remove(@RequestParam("id") Integer id,Model model) {
		
		recipeService.deleteRecipe(id);
		return "redirect:/queryall.controller";
	}
	
	
}
