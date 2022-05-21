package co.edu.uco.grades.data.dao.connection;

import java.sql.Connection;

import co.edu.uco.crosscutting.util.sql.UtilConnection;
import co.edu.uco.grades.crosscutting.exception.GradesException;

public class ConnectionSQL {

	private Connection connection;

	protected ConnectionSQL(Connection connection) {
		if (UtilConnection.isClosed(connection)) {
			throw GradesException.buildTechnicalDataException("It's not possible to create the specific DAO because connection is closed");
		}

		setConnection(connection);
	}

	protected Connection getConnection() {
		return connection;
	}

	private void setConnection(Connection connection) {
		this.connection = connection;
	}
}