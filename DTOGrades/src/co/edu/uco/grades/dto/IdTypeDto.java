package co.edu.uco.grades.dto;

import co.edu.uco.crosscutting.util.text.UtilText;

public class IdTypeDto {
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	
	private IdTypeDto() {
		super();
		setName(UtilText.EMPTY);
		
	}
	
	
	private IdTypeDto(int id, String name) {
		super();
		setId(id);
		setName(name);
	}


	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = UtilText;
	}
	
	
	

}
