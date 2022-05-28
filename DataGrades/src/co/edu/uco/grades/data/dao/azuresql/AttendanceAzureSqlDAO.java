package co.edu.uco.grades.data.dao.azuresql;

import java.sql.Connection;
import java.util.List;

import co.edu.uco.grades.data.dao.AttendanceDAO;
import co.edu.uco.grades.data.dao.connection.ConnectionSQL;
import co.edu.uco.grades.dto.AttendanceDTO;

public class AttendanceAzureSqlDAO extends ConnectionSQL implements AttendanceDAO{

	protected AttendanceAzureSqlDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(AttendanceDTO student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(AttendanceDTO student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<AttendanceDTO> find(AttendanceDTO student) {
		// TODO Auto-generated method stub
		return null;
	}

}
