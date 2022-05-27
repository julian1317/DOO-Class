package co.edu.uco.grades.data.dao;

import java.util.List;

import co.edu.uco.grades.dto.SubjectDTO;

public interface SubjectDAO {
	
	void create(SubjectDTO idType);

	void update(SubjectDTO idType);

	void delete(int id);

	List<SubjectDTO> find(SubjectDTO subject);

}
