package co.edu.uco.grades.dto;

import co.edu.uco.crosscutting.util.object.UtilObject;

public class StudentCourseDTO {
	private int id;
	private StudentDTO student;
	private CourseDTO course;
	private StudentCourseStateDTO studentCourseState;
	
	
	
	
	public StudentCourseDTO(int id, StudentDTO setudent, CourseDTO course, StudentCourseStateDTO studentCourseState) {
		super();
		setId(id);
		setStudent(setudent);
		setCourse(course);
		setStudentCourseState(studentCourseState);
		
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public StudentDTO getSetudent() {
		return student;
	}
	public void setStudent(StudentDTO student) {
		this.student = UtilObject.getUtilObject().getDefault(student, new StudentDTO());
	}
	public CourseDTO getCourse() {
		return course;
	}
	public void setCourse(CourseDTO course) {
		this.course = UtilObject.getUtilObject().getDefault(course, new CourseDTO());
	}
	public StudentCourseStateDTO getStudentCourseState() {
		return studentCourseState;
	}
	public void setStudentCourseState(StudentCourseStateDTO studentCourseState) {
		this.studentCourseState = UtilObject.getUtilObject().getDefault(studentCourseState, new StudentCourseStateDTO());
	}
	
	
	
	

}
