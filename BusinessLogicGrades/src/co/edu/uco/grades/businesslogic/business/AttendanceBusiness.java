package co.edu.uco.grades.businesslogic.business;

import java.util.List;

import co.edu.uco.grades.dto.AttendanceDTO;


public interface AttendanceBusiness {
	void create(AttendanceDTO dto);

	void update(AttendanceDTO dto);

	void delete(int id);

	List<AttendanceDTO> find(AttendanceDTO dto);

}
