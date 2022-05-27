package co.edu.uco.grades.data.dao;

import java.util.List;

import co.edu.uco.grades.dto.AttendanceDTO;


public interface AttendanceDAO {

	void create(AttendanceDTO student);

	void update(AttendanceDTO student);

	void delete(int id);


	List<AttendanceDTO> find (AttendanceDTO student);

}
