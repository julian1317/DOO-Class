package co.edu.uco.grades.businesslogic.business;

import java.util.List;

import co.edu.uco.grades.dto.StudentCourseDTO;

public interface StudentCourseBusiness {
	void create(StudentCourseDTO dto);

	void update(StudentCourseDTO dto);

	void delete(int id);

	List<StudentCourseDTO> find(StudentCourseDTO dto);

}
