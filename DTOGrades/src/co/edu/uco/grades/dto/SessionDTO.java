package co.edu.uco.grades.dto;

import java.sql.Date;

import co.edu.uco.crosscutting.util.object.UtilObject;

public class SessionDTO {
	private int id;
	private CourseDTO course;
	private Date date;
	
	
	public SessionDTO() {
		super();
		
	}
	
	
	public SessionDTO(int id, CourseDTO course, Date date) {
		super();
		setId(id);
		setCourse(course);
		setDate(date);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public CourseDTO getCourse() {
		return course;
	}
	public void setCourse(CourseDTO course) {
		this.course = UtilObject.getUtilObject().getDefault(course, new CourseDTO());

	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	

}
