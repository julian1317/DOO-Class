package co.edu.uco.grades.data.dao;

import java.util.List;

import co.edu.uco.grades.dto.SessionDTO;

public interface SessionDAO {

	void create(SessionDTO student);

	void update(SessionDTO student);

	void delete(int id);


	List<SessionDTO> find (SessionDTO student);

}
