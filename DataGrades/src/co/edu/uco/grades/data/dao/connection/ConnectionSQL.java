package co.edu.uco.grades.data.dao.connection;

import java.sql.Connection;

import co.edu.uco.crosscutting.util.sql.UtilConnection;
import co.edu.uco.grades.crosscutting.exception.GradesException;
import co.edu.uco.grades.crosscutting.exception.enumeration.ExceptionLocation;
import co.edu.uco.grades.crosscutting.exception.enumeration.ExceptionType;
import co.edu.uco.grades.dto.StudentDTO;

public class ConnectionSQL {
	private Connection connection;
	
	protected ConnectionSQL(Connection connection) {
		if(UtilConnection.isClosed(connection)) {
			throw GradesException.buildTechnicalDataException("it's not possible to create the specifi DAO because connection is closed" );

		}
		
		setConnection(connection);
		
		
	}

	protected Connection getConnection() {
		return connection;
	}

	private  void setConnection(Connection connection) {
		this.connection = connection;
	}

	public void build(StudentDTO student) {
		// TODO Auto-generated method stub
		
	}

}
