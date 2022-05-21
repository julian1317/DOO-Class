package co.edu.uco.grades.dto;

import co.edu.uco.crosscutting.util.object.UtilObject;
import co.edu.uco.crosscutting.util.text.UtilText;

public class StudentDTO {

	private int id;
	private String idNumber;
	private IdTypeDTO idType;
	private String name;
	private String email;

	public StudentDTO() {
		super();
		setIdNumber(UtilText.EMPTY);
		setIdType(new IdTypeDTO());
		setName(UtilText.EMPTY);
		setEmail(UtilText.EMPTY);
	}

	public StudentDTO(int id, String idNumber, IdTypeDTO idType, String name, String email) {
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
		this.idNumber = UtilText.getDefault(idNumber);
		;
	}

	public IdTypeDTO getIdType() {
		return idType;
	}

	public void setIdType(IdTypeDTO idType) {
		this.idType = UtilObject.getUtilObject().getDefault(idType, new IdTypeDTO());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = UtilText.getDefault(name);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = UtilText.getDefault(email);
	}
}
