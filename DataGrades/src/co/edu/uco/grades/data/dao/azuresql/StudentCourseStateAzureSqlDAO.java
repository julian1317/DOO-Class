package co.edu.uco.grades.data.dao.azuresql;

import java.sql.Connection;
import java.util.List;

import co.edu.uco.grades.data.dao.StudentCourseStateDAO;
import co.edu.uco.grades.data.dao.connection.ConnectionSQL;
import co.edu.uco.grades.dto.StudentCourseStateDTO;

public class StudentCourseStateAzureSqlDAO extends ConnectionSQL implements StudentCourseStateDAO {

	protected StudentCourseStateAzureSqlDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(StudentCourseStateDTO student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(StudentCourseStateDTO student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<StudentCourseStateDTO> find(StudentCourseStateDTO student) {
		// TODO Auto-generated method stub
		return null;
	}

}
