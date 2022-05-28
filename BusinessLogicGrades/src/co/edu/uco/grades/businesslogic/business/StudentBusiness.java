package co.edu.uco.grades.businesslogic.business;

import java.util.List;

import co.edu.uco.grades.dto.StudentDTO;

public interface StudentBusiness {
	void create(StudentDTO dto);

	void update(StudentDTO dto);

	void delete(int id);

	List<StudentDTO> find(StudentDTO dto);

}
