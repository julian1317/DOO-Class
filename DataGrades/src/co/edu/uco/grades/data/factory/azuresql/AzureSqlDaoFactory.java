package co.edu.uco.grades.data.factory.azuresql;

import java.sql.Connection;

import co.edu.uco.crosscutting.ultil.sql.UtilConnection;
import co.edu.uco.crosscutting.util.object.UtilObject;
import co.edu.uco.grades.crosscutting.exception.GradesException;
import co.edu.uco.grades.data.dao.StudentDAO;
import co.edu.uco.grades.data.factory.DAOFactory;

public class AzureSqlDaoFactory extends DAOFactory {
	private Connection connection;
	
	private AzureSqlDaoFactory() {
		openConnection();
	}

	@Override
	protected void openConnection() {
		// TODO Auto-generated method stub
		if(!UtilObject.getUtilObject().isNull(connection)&&
				 UtilConnection.isClosed(connection)) {
			throw GradesException.buildTechnicalException("it's no possible open a connectio because it's alredy is open");
		}
		//podemos abrir una conexión
	}

	@Override
	public void getCoonection() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeConnectio() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void commit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rollback() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public StudentDAO getStudentDAO() {
		// TODO Auto-generated method stub
		return null;
	}

}
