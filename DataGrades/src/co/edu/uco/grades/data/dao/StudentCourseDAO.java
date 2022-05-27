package co.edu.uco.grades.data.dao;

import java.util.List;

import co.edu.uco.grades.dto.StudentCourseDTO;

public interface StudentCourseDAO {

	void create(StudentCourseDTO student);

	void update(StudentCourseDTO student);

	void delete(int id);


	List<StudentCourseDTO> find (StudentCourseDTO student);

}
