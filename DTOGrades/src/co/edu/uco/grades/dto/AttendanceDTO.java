package co.edu.uco.grades.dto;

import co.edu.uco.crosscutting.util.object.UtilObject;

public class AttendanceDTO {
	private int id;
	private StudentDTO student;
	private SessionDTO session;
	private boolean attended;
	
	public AttendanceDTO() {
		super();
		setAttended(false);
		
	}
	
	
	
	public AttendanceDTO(int id, StudentDTO student, SessionDTO session, boolean attended) {
		super();
		setId(id);
		setStudent(student);
		setSession(session);
		setAttended(attended);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public StudentDTO getStudent() {
		return student;
	}
	public void setStudent(StudentDTO student) {
		this.student = UtilObject.getUtilObject().getDefault(student, new StudentDTO());
	}
	public SessionDTO getSession() {
		return session;
	}
	public void setSession(SessionDTO session) {
		this.session = UtilObject.getUtilObject().getDefault(session, new SessionDTO());
	}
	public boolean isAttended() {
		return attended;
	}
	public void setAttended(boolean attended) {
		this.attended = attended;
	}
	

}
