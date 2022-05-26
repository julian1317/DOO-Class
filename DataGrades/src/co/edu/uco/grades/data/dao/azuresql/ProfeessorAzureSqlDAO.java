package co.edu.uco.grades.data.dao.azuresql;

import java.sql.Connection;
import java.util.List;

import co.edu.uco.grades.data.dao.ProfessorDAO;
import co.edu.uco.grades.data.dao.StudentDAO;
import co.edu.uco.grades.data.dao.connection.ConnectionSQL;
import co.edu.uco.grades.dto.ProfessorDTO;

public class ProfeessorAzureSqlDAO extends ConnectionSQL implements ProfessorDAO{

	protected ProfeessorAzureSqlDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}
	public static ProfessorDAO build(Connection connection) {
		return new ProfeessorAzureSqlDAO(connection);
	}
	@Override
	public void create(ProfessorDTO idType) {
		
	}

	@Override
	public void update(ProfessorDTO idType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ProfessorDTO> find(ProfessorDTO professor) {
		// TODO Auto-generated method stub
		return null;
	}

}
