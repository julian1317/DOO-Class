package co.edu.uco.grades.dto;

import co.edu.uco.crosscutting.util.text.UtilText;

public class StudentDTO {
	private int id;
	private String idNumber;
	private IdTypeDto idType; 
	private String name;
	private String email;
	
	
	

	private StudentDTO() {
		super();
		
		setIdNumber(UtilTextl.Empty);
		setIdType(idType);
		setName(name);
		setEmail(email);
		
	}

	private StudentDTO(int id, String idNumber, IdTypeDto idType, String name, String email) {
		super();
		setId(id);
		setIdNumber(idNumber);
		setIdType(idType);
		setName(name);
		setEmail(email);
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public IdTypeDto getIdType() {
		return idType;
	}

	public void setIdType(IdTypeDto idType) {
		this.idType = idType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = UtilText.getDefautl(name);
	}
	
	
	
	

}
