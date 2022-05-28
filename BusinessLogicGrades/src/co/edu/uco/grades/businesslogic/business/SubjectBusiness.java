package co.edu.uco.grades.businesslogic.business;

import java.util.List;

import co.edu.uco.grades.dto.SubjectDTO;

public interface SubjectBusiness {
	void create(SubjectDTO dto);

	void update(SubjectDTO dto);

	void delete(int id);

	List<SubjectDTO> find(SubjectDTO dto);

}
