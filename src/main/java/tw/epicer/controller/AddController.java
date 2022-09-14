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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import tw.epicer.model.IngredientsBean;
import tw.epicer.model.RecipeBean;
import tw.epicer.model.Step;
import tw.epicer.service.ReciepeServiceInterface;

@Controller
public class AddController {
	@Autowired
	@Qualifier("recipeService")
	private ReciepeServiceInterface recipeService;
	
	@PostMapping(path = "/addrecipe.controller")
	public String addRecipe(@RequestParam("title") String name,
			@RequestParam("file1") MultipartFile mf,@RequestParam("howmanypeople") String howMany,
			@RequestParam("description") String description,@RequestParam("time") String time,
			@RequestParam("ingredient") String[] ingredients,@RequestParam("amount") String[]amounts
			,@RequestParam("step")String[] steps,Model model) throws IllegalStateException, IOException {
		String filenameString = mf.getOriginalFilename();
		String saveFileDir="D:/projectws/ProjectForSpring/src/main/webapp/WEB-INF/resources/images";
//		String fileLocalPathString = saveFileDir+"/"+filenameString;
		String fileLocalPathString = "images/"+filenameString;
		File filePath = new File(saveFileDir, filenameString);
		mf.transferTo(filePath);
		RecipeBean recipeBean = new RecipeBean(name, fileLocalPathString, description, time, howMany);
		Set<IngredientsBean> ingredientsSet = new LinkedHashSet<IngredientsBean>();
		for(int i=0;i<ingredients.length;i++) {
			IngredientsBean ingredientsBean = new IngredientsBean();
			ingredientsBean.setIngredient(ingredients[i]);
			ingredientsBean.setAmount(amounts[i]);
			ingredientsSet.add(ingredientsBean);
		}
		Set<Step> stepSet=new LinkedHashSet<Step>();
		for(int i=0;i<steps.length;i++) {
			Step step = new Step();
			step.setStep(steps[i]);
			stepSet.add(step);
		}
		recipeService.addRecipe(recipeBean, ingredientsSet, stepSet);
		
		return "redirect:/queryall.controller";
	}
@GetMapping(path="/add")
	public String goToAdd() {
		return "AddPage";
	}
}
