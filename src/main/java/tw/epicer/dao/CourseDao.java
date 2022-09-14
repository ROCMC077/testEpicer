package tw.epicer.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tw.epicer.model.Course;
import tw.epicer.model.Teachers;


@Repository
@Transactional
public class CourseDao  {

	
	@Autowired
	private SessionFactory factory;



	// insert
	public Course insert(Course newcourse) {

		Session session = factory.getCurrentSession();
		
		Course theCourse = session.get(Course.class, newcourse.getCourseId());

		if (theCourse == null) {
			session.save(newcourse);
			return newcourse;
		}
		return null;
	}

	public Course select(int courseId) {
		Session session = factory.getCurrentSession();
		return session.get(Course.class, courseId);
	}

	
	public List<Course> selectAll() {
		Session session = factory.getCurrentSession();
		Query<Course> query = session.createQuery("from Course",Course.class);
		System.out.println(query.list());
		return query.list();

	}

//	public Course updateOne(Course newCourse, Course oldCourse) {
//		Session session = factory.getCurrentSession();
//
//		Course oldCourse1 = session.get(Course.class, newCourse.getCourseId());
//
//		if (newCourse != null) {
//			oldCourse1.setCourseName(newCourse.getCourseName());
//			oldCourse1.setCoursePrice(newCourse.getCoursePrice());
//			oldCourse1.setCourseDescription(newCourse.getCourseDescription());
//			oldCourse1.setCourseDate(newCourse.getCourseDate());
//			oldCourse1.setTeacher(newCourse.getTeacher());
//			oldCourse1.setClassroomId(newCourse.getClassroomId());
//			oldCourse1.setCuisineStyle(newCourse.getCuisineStyle());
//			oldCourse1.setOther(newCourse.getOther());
//			session.save(oldCourse1);
//
//			return oldCourse1;
//
//		} else {
//			return null;
//		}
//
//	}
	
	public Course updateOne(int courseId,Course newCourse) {
		Session session = factory.getCurrentSession();

		Course oldCourse1 = session.get(Course.class, courseId);

		if (newCourse != null) {
			oldCourse1.setCourseName(newCourse.getCourseName());
			oldCourse1.setCoursePrice(newCourse.getCoursePrice());
			oldCourse1.setCourseDescription(newCourse.getCourseDescription());
			oldCourse1.setCourseDate(newCourse.getCourseDate());
			oldCourse1.setTeacher(newCourse.getTeacher());
			oldCourse1.setClassroomId(newCourse.getClassroomId());
			oldCourse1.setCuisineStyle(newCourse.getCuisineStyle());
			oldCourse1.setOther(newCourse.getOther());
			session.save(oldCourse1);

			return oldCourse1;

		} else {
			return null;
		}

	}
	
	
	
	

	public boolean deleteOne(int courseId) {
		Session session = factory.getCurrentSession();
		Course course = session.get(Course.class, courseId);

		if (course != null) {
			session.delete(course);
			return true;
		}
		return false;
	}
	
	public Teachers selectTeacherById( int teacherId) {
		
		Session session = factory.getCurrentSession();
		return session.get(Teachers.class, teacherId);
	}

}
