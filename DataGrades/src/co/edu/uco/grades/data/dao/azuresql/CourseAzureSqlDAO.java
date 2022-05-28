package co.edu.uco.grades.data.dao.azuresql;

import java.sql.Connection;
import java.util.List;

import co.edu.uco.grades.data.dao.CourseDAO;
import co.edu.uco.grades.data.dao.connection.ConnectionSQL;
import co.edu.uco.grades.dto.CourseDTO;

public class CourseAzureSqlDAO extends ConnectionSQL implements CourseDAO {

	protected CourseAzureSqlDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(CourseDTO student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(CourseDTO student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CourseDTO> find(CourseDTO student) {
		// TODO Auto-generated method stub
		return null;
	}

}
