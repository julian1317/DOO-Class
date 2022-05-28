package co.edu.uco.grades.businesslogic.business;

import java.util.List;

import co.edu.uco.grades.dto.SessionDTO;

public interface SessionBusiness {
	void create(SessionDTO dto);

	void update(SessionDTO dto);

	void delete(int id); 
 
	List<SessionDTO> find(SessionDTO dto);

}
