package co.edu.uco.grades.data.dao.azuresql;

import java.sql.Connection;

import co.edu.uco.grades.data.dao.StudentDAO;
import co.edu.uco.grades.data.dao.connection.ConnectionSQL;
import co.edu.uco.grades.dto.StudentDTO;

public class StudentAzureSqlDAO extends ConnectionSQL implements StudentDAO {

	protected StudentAzureSqlDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}
	
	public static StudentDAO create(Connection connection) {
		return new StudentAzureSqlDAO(connection);
		
	}
	@Override
	public void build(StudentDTO student) {
		return new StudentAzureSqlDAO(Connection);
		
	}

	@Override
	public void create(StudentDTO student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(StudentDTO student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
	

}
