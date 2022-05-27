package co.edu.uco.grades.data.dao;

import java.util.List;

import co.edu.uco.grades.dto.CourseDTO;

public interface CourseDAO {

	void create(CourseDTO student);

	void update(CourseDTO student);

	void delete(int id);


	List<CourseDTO> find (CourseDTO student);

}
