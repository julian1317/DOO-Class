package co.edu.uco.grades.data.dao.azuresql;

import java.sql.Connection;
import java.util.List;

import co.edu.uco.grades.data.dao.SessionDAO;
import co.edu.uco.grades.data.dao.connection.ConnectionSQL;
import co.edu.uco.grades.dto.SessionDTO;

public class SessionAzureSqlDAO extends ConnectionSQL implements SessionDAO {

	protected SessionAzureSqlDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(SessionDTO student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(SessionDTO student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<SessionDTO> find(SessionDTO student) {
		// TODO Auto-generated method stub
		return null;
	}

}
