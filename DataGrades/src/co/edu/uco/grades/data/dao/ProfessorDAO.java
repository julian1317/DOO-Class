package co.edu.uco.grades.data.dao;

import java.util.List;


import co.edu.uco.grades.dto.ProfessorDTO;

public interface ProfessorDAO {
	void create(ProfessorDTO idType);

	void update(ProfessorDTO idType);

	void delete(int id);

	List<ProfessorDTO> find(ProfessorDTO professor);

}
