package co.edu.uco.grades.dto;

import java.sql.Date;

public class SesionDTO {
	private int id;
	private CourseDTO course;
	private Date date;
	
	
	
	
	
	
	public SesionDTO(int id, CourseDTO course, Date date) {
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
		this.course = course;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	

}
