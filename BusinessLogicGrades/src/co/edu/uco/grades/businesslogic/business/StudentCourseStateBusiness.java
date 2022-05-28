package co.edu.uco.grades.businesslogic.business;

import java.util.List;

import co.edu.uco.grades.dto.StudentCourseStateDTO;

public interface StudentCourseStateBusiness {
	void create(StudentCourseStateDTO dto);

	void update(StudentCourseStateDTO dto);

	void delete(int id);

	List<StudentCourseStateDTO> find(StudentCourseStateDTO dto);

}
