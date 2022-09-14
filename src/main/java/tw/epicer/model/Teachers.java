package tw.epicer.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;



@Entity@Table(name = "Teachers")
@Component
public class Teachers {

	@Id
	@Column(name = "teacher_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int teacherId;
	
	
	@Column(name = "teacher_name")
	private String teacherName;
	
	
	@Column(name = "teacher_description")
	private String teacherDescription;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "teachers",cascade = CascadeType.ALL)
	private Set<Course> course = new LinkedHashSet<Course>();

	public int getTeacherId() {
		return teacherId;
	}
	
	public Teachers(String teacherName, String teacherDescription) {
		super();
		this.teacherName = teacherName;
		this.teacherDescription = teacherDescription;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getTeacherDescription() {
		return teacherDescription;
	}

	public void setTeacherDescription(String teacherDescription) {
		this.teacherDescription = teacherDescription;
	}

	public Set<Course> getCourse() {
		return course;
	}

	public void setCourse(Set<Course> course) {
		this.course = course;
	}

	public Teachers() {
		super();
	}
	

}
