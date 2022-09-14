package tw.epicer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tw.epicer.dao.CourseDao;
import tw.epicer.model.Course;
import tw.epicer.model.Teachers;


@Controller
public class CourseController {

	@Autowired
	private CourseDao cDao;


	// listAll
	@GetMapping(path = "/666")
	public String processMainAction(Model m) {
		List<Course> list = cDao.selectAll();
		m.addAttribute("listAll", list);
		return "coursePage";
	};

	// insert form:form
//	@PostMapping(path = "/addCourse")
//	public String insertCourse(@ModelAttribute("Course") Course course, BindingResult result, Model m ) {	
//		
//		if(result.hasErrors()) {
//			return "courseError";
//		}		
//		cDao.insert(course);	
//		return "coursePage";		
//	};

	@PostMapping(path = "/addCourse")
	public String insertCourse(@RequestParam("courseName") String courseName,
			@RequestParam("coursePrice") int coursePrice, @RequestParam("courseDescription") String courseDescription,
			@RequestParam("courseDate") String courseDate, @RequestParam("teacherId") int teacherId,
			@RequestParam("classroomId") int classroomId, @RequestParam("cuisineStyle") String cuisineStyle,
			@RequestParam("other") String other

	) {
		Teachers theTeacher = cDao.selectTeacherById(teacherId);
		Course newCourse = new Course(courseName,coursePrice,courseDescription,courseDate,theTeacher,classroomId,cuisineStyle,other);
		cDao.insert(newCourse);
		return  "redirect:/666";
	};

	// update
	@PostMapping(path = "/beforeUpdateCourse")
	public String beforeUpdateCourse(@RequestParam("courseId") int courseId, Model m) {

		Course course = cDao.select(courseId);
		m.addAttribute("Course", course);
		return "courseEditor";
	}

	@PostMapping(path = "/UpdateCourse")
	public String UpdateCourse(@RequestParam("courseId") int courseId,@RequestParam("courseName") String courseName,
			@RequestParam("coursePrice") int coursePrice, @RequestParam("courseDescription") String courseDescription,
			@RequestParam("courseDate") String courseDate, @RequestParam("teacherId") int teacherId,
			@RequestParam("classroomId") int classroomId, @RequestParam("cuisineStyle") String cuisineStyle,
			@RequestParam("other") String other

	) {
		Teachers theTeacher = cDao.selectTeacherById(teacherId);
		Course newCourse = new Course(courseName,coursePrice,courseDescription,courseDate,theTeacher,classroomId,cuisineStyle,other);
		cDao.updateOne(courseId, newCourse);
		return "redirect:/666";
	}

	// delete
	@PostMapping(path = "/deleteCourse")
	public String deleteCourse(@RequestParam("courseId") int courseId) {
		cDao.deleteOne(courseId);
		return "redirect:/666";

	}

//	@PostMapping(path = "/tocourseInsert")
//	public ModelAndView tocourseInsert(Model m) {
//		 Course Course = new Course();
//		 m.addAttribute(Course);
//		//return "courseInsert";
//		return new ModelAndView("courseInsert").addObject(Course);
//		
//	}

	@PostMapping(path = "/tocourseInsert")
	public String tocourseInsert() {

		return "courseInsert";

	}

}
