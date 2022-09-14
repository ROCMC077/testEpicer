package tw.epicer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity@Table(name = "Course")
@Component
public class Course {

	
	@Id
	@Column(name = "course_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int courseId;
	
	@Column(name = "course_name")
	private String courseName;
	
	@Column(name = "course_price")
	private int coursePrice;
	
	@Column(name = "course_description")
	private String courseDescription;
	
	@Column(name = "course_date")
	private String courseDate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_teacher_id")
	private Teachers teachers;
	
	@Column(name = "classroom_id")
	private int classroomId;
	
	@Column(name = "cuisine_style")
	private String cuisineStyle;
	
	@Column(name = "other")
	private String other;
	
	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public Course(String courseName, int coursePrice, String courseDescription, String courseDate, Teachers teachers,
			int classroomId, String cuisineStyle, String other) {
		super();
		this.courseName = courseName;
		this.coursePrice = coursePrice;
		this.courseDescription = courseDescription;
		this.courseDate = courseDate;
		this.teachers = teachers;
		this.classroomId = classroomId;
		this.cuisineStyle = cuisineStyle;
		this.other = other;
	}
	
	
	

	public Course(int courseId, String courseName, int coursePrice, String courseDescription, String courseDate,
			Teachers teachers, int classroomId, String cuisineStyle, String other) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.coursePrice = coursePrice;
		this.courseDescription = courseDescription;
		this.courseDate = courseDate;
		this.teachers = teachers;
		this.classroomId = classroomId;
		this.cuisineStyle = cuisineStyle;
		this.other = other;
	}

	public Course() {
		super();
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getCoursePrice() {
		return coursePrice;
	}

	public void setCoursePrice(int coursePrice) {
		this.coursePrice = coursePrice;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

	public String getCourseDate() {
		return courseDate;
	}

	public void setCourseDate(String courseDate) {
		this.courseDate = courseDate;
	}

	public Teachers getTeacher() {
		return teachers;
	}

	public void setTeacher(Teachers teacher) {
		this.teachers = teacher;
	}

	public int getClassroomId() {
		return classroomId;
	}

	public void setClassroomId(int classroomId) {
		this.classroomId = classroomId;
	}

	public String getCuisineStyle() {
		return cuisineStyle;
	}

	public void setCuisineStyle(String cuisineStyle) {
		this.cuisineStyle = cuisineStyle;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	
}
