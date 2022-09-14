package tw.epicer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tw.epicer.model.IngredientsBean;
import tw.epicer.model.RecipeBean;
import tw.epicer.service.ReciepeServiceInterface;


@Controller
public class QueryController {
	@Autowired
	@Qualifier("recipeService")
	private ReciepeServiceInterface recipeService;
	
	
	@GetMapping(path = "/queryall.controller" )
	public String queryAll(Model model) {
		List<RecipeBean> queryAll = recipeService.queryAll();
		model.addAttribute("searchAll", queryAll);
		return "NewSearch";
	}
	
	@PostMapping(path = "/queryforlist.controller" )
	public String queryList(@RequestParam("searchByRecipe")String name ,Model model) {
		List<RecipeBean> queryList = recipeService.queryForName(name);
		model.addAttribute("searchResult",queryList);
		return "NewResult";
	}
	
	@GetMapping(path = "/queryforid.controller")
	public String queryForId(@RequestParam("id") Integer id,Model model) {
		RecipeBean recipe = recipeService.queryRecipeForId(id);
		List<IngredientsBean> ingredients = recipeService.queryIngredientsForId(id);
		List<tw.epicer.model.Step> steps=recipeService.queryStepsForId(id);
		model.addAttribute("recipe",recipe);
		model.addAttribute("ingredients", ingredients);
		model.addAttribute("step", steps);
		
		return "NewRecipeResult";
	}
	
}
