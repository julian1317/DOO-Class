package co.edu.uco.grades.dto;

import co.edu.uco.crosscutting.util.text.UtilText;

public class StudentCourseStateDTO {
	private int id;
	private String name;
	
	
	
	public StudentCourseStateDTO() {
		super();
		setName(UtilText.EMPTY);
	}
	
	
	public StudentCourseStateDTO(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = UtilText.getDefault(name);
	}
	

}
