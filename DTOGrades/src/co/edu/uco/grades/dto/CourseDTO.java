package co.edu.uco.grades.dto;

import java.sql.Date;

import co.edu.uco.crosscutting.util.object.UtilObject;



public class CourseDTO {
	
	private int id;
	private SubjectDTO subject;
	private Date initialDate;
	private Date finallDate;
	
	
	
	
	public CourseDTO() {
		super();
		setSubject(new SubjectDTO());
	}
	public CourseDTO(int id, SubjectDTO subject, Date initialDate, Date finallDate) {
		super();
		setId(id);
		setSubject(new SubjectDTO());
		setInitialDate(initialDate);
		setFinallDate(finallDate);
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public SubjectDTO getSubject() {
		return subject;
	}
	public void setSubject(SubjectDTO subject) {
		this.subject = UtilObject.getUtilObject().getDefault(subject, new SubjectDTO());
	}
	public Date getInitialDate() {
		return initialDate;
	}
	public void setInitialDate(Date initialDate) {
		this.initialDate = initialDate;
	}
	public Date getFinallDate() {
		return finallDate;
	}
	public void setFinallDate(Date finallDate) {
		this.finallDate = finallDate;
	}
	
	
	
	
	

}
