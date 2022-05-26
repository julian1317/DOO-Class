package co.edu.uco.grades.data.dao;

import java.util.List;


import co.edu.uco.grades.dto.StudentDTO;

public interface StudentDAO {

	void create(StudentDTO student);

	void update(StudentDTO student);

	void delete(int id);


	List<StudentDTO> find (StudentDTO student);
}
