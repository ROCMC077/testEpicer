package tw.epicer.dao;

import java.util.List;

import tw.epicer.model.Step;


public interface StepDao {
	public void addSteps(Step step);

	public int deleteStepsByRicipeId(Integer id);

	public List<Step> queryStepsByRecipeId(Integer id);

	public Step updateStepByRecipeId(Integer id,Step step);
}
