package co.edu.uco.grades.data.dao.azuresql;

import java.sql.Connection;
import java.util.List;

import co.edu.uco.grades.data.dao.SubjectDAO;
import co.edu.uco.grades.data.dao.connection.ConnectionSQL;
import co.edu.uco.grades.dto.SubjectDTO;

public class SubjectAzureSqlDAO extends ConnectionSQL implements SubjectDAO{

	protected SubjectAzureSqlDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}
	public static SubjectAzureSqlDAO build(Connection connection) {
		return new SubjectAzureSqlDAO(connection);
	}

	@Override
	public void create(SubjectDTO idType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(SubjectDTO idType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<SubjectDTO> find(SubjectDTO subject) {
		// TODO Auto-generated method stub
		return null;
	}

}
