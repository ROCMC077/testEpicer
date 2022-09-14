package tw.epicer.controller;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import tw.epicer.model.IngredientsBean;
import tw.epicer.model.RecipeBean;
import tw.epicer.model.Step;
import tw.epicer.service.ReciepeServiceInterface;

@Controller
public class UpdateController {
	@Autowired
	@Qualifier("recipeService")
	private ReciepeServiceInterface recipeService;

	@GetMapping(path = "/beforeupdate.controller")
	public String beforeUpdate(@RequestParam("id") Integer id, Model model) {
		RecipeBean recipe = recipeService.queryRecipeForId(id);
		List<IngredientsBean> ingredients = recipeService.queryIngredientsForId(id);
		List<tw.epicer.model.Step> steps = recipeService.queryStepsForId(id);
		model.addAttribute("recipe", recipe);
		model.addAttribute("ingredients", ingredients);
		model.addAttribute("step", steps);

		return "Update";
	}
	@PostMapping(path = "/update.controller")
	public String update(@RequestParam("id") Integer id, @RequestParam("title") String name,
			@RequestParam("file1") MultipartFile mf, @RequestParam("howmanypeople") String howMany,
			@RequestParam("description") String description, @RequestParam("time") String time,
			@RequestParam("ingredient") String[] ingredients, @RequestParam("amount") String[]amounts
			,@RequestParam("step") String[] steps, Model model) throws IllegalStateException, IOException {
		String filenameString = mf.getOriginalFilename();
		String saveFileDir = "D:/projectws/ProjectForSpring/src/main/webapp/WEB-INF/resources/images";
		String fileLocalPathString = "images/"+filenameString;
		File filePath = new File(saveFileDir, filenameString);
		mf.transferTo(filePath);
		recipeService.deleteRecipe(id);
		RecipeBean recipeBean = new RecipeBean(name, fileLocalPathString, description, time, howMany);
		Set<IngredientsBean> ingredientsSet = new LinkedHashSet<IngredientsBean>();
		for (int i = 0; i < ingredients.length; i++) {
			IngredientsBean ingredientsBean = new IngredientsBean();
			ingredientsBean.setIngredient(ingredients[i]);
			ingredientsBean.setAmount(amounts[i]);
			ingredientsBean.setRecipeBean(recipeBean);
			ingredientsSet.add(ingredientsBean);
		}
		Set<Step> stepSet = new LinkedHashSet<Step>();
		for (int i = 0; i < steps.length; i++) {
			Step step = new Step();
			step.setStep(steps[i]);
			step.setRecipeBean(recipeBean);
			stepSet.add(step);
		}
		recipeBean.setIngredients(ingredientsSet);
		recipeBean.setSteps(stepSet);
		recipeService.addRecipe(recipeBean, ingredientsSet, stepSet);
		
		return "redirect:/recipe";
	}

}
