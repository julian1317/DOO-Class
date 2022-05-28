package co.edu.uco.grades.data.factory.azuresql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import co.edu.uco.crosscutting.util.sql.UtilConnection;
import co.edu.uco.grades.crosscutting.exception.GradesException;
import co.edu.uco.grades.crosscutting.exception.enumeration.ExceptionLocation;
import co.edu.uco.grades.data.dao.AttendanceDAO;
import co.edu.uco.grades.data.dao.CourseDAO;
import co.edu.uco.grades.data.dao.IdTypeDAO;
import co.edu.uco.grades.data.dao.ProfessorDAO;
import co.edu.uco.grades.data.dao.SessionDAO;
import co.edu.uco.grades.data.dao.StudentCourseDAO;
import co.edu.uco.grades.data.dao.StudentCourseStateDAO;
import co.edu.uco.grades.data.dao.StudentDAO;
import co.edu.uco.grades.data.dao.SubjectDAO;
import co.edu.uco.grades.data.dao.azuresql.IdTypeAzureSqlDAO;
import co.edu.uco.grades.data.dao.azuresql.ProfessorAzureSqlDAO;
import co.edu.uco.grades.data.dao.azuresql.StudentAzureSqlDAO;
import co.edu.uco.grades.data.dao.azuresql.SubjectAzureSqlDAO;
import co.edu.uco.grades.data.factory.DAOFactory;

public class AzureSqlDAOFactory extends DAOFactory {

	private Connection connection;

	private AzureSqlDAOFactory() {
		openConnection();
	}

	public static DAOFactory create() {
		return new AzureSqlDAOFactory();
	}

	@Override
	protected void openConnection() {

		String stringConnection = "jdbc:sqlserver://academic-database-server.database.windows.net:1433;database=academic-db;user=academicDmlUser;password=4c4d3m1cDmlUs3r;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";

		try {
			connection = DriverManager.getConnection(stringConnection);
		} catch (SQLException exception) {
			throw GradesException.buildTechnicalException("There was a problem trying to get the connection with sql server at jdbc:sqlserver://academic-database-server.database.windows.net:1433;database=academic-db;user=academicDmlUser", exception, ExceptionLocation.DATA);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalException("An unexpected problem has ocurred trying to get the connection with sql server at jdbc:sqlserver://academic-database-server.database.windows.net:1433;database=academic-db;user=academicDmlUser", exception, ExceptionLocation.DATA);
		}
	}

	@Override
	protected Connection getConnection() {
		return connection;
	}

	@Override
	public void closeConnection() {
		if (UtilConnection.isClosed(getConnection())) {
			throw GradesException.buildTechnicalException("It's not possible close a connection because its already is closed");
		}

		try {
			getConnection().close();
		} catch (SQLException exception) {
			throw GradesException.buildTechnicalException("There was a problem trying to close the connection with sql server at jdbc:sqlserver://academic-database-server.database.windows.net:1433;database=academic-db;user=academicDmlUser", exception, ExceptionLocation.DATA);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalException("An unexpected problem has ocurred trying to close the connection with sql server at jdbc:sqlserver://academic-database-server.database.windows.net:1433;database=academic-db;user=academicDmlUser", exception, ExceptionLocation.DATA);
		}
	}

	@Override
	public void initTransaction() {
		if (UtilConnection.isClosed(getConnection())) {
			throw GradesException.buildTechnicalException("It's not possible to init the transaction because the connection is closed");
		}

		try {

			if (!getConnection().getAutoCommit()) {
				throw GradesException.buildTechnicalException("It's not possible to init the transaction because it was already initiated");
			}

			getConnection().setAutoCommit(false);
		} catch (SQLException exception) {
			throw GradesException.buildTechnicalException("There was a problem trying to init the transaction with sql server at jdbc:sqlserver://academic-database-server.database.windows.net:1433;database=academic-db;user=academicDmlUser", exception, ExceptionLocation.DATA);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalException("An unexpected problem has ocurred trying to init the transaction with sql server at jdbc:sqlserver://academic-database-server.database.windows.net:1433;database=academic-db;user=academicDmlUser", exception, ExceptionLocation.DATA);
		}
	}

	@Override
	public void commitTransaction() {
		if (UtilConnection.isClosed(getConnection())) {
			throw GradesException.buildTechnicalException("It's not possible to commit the transaction because the connection is closed");
		}

		try {
			if (getConnection().getAutoCommit()) {
				throw GradesException.buildTechnicalException("It's not possible to commit the transaction because the database is managing the transaction");
			}

			getConnection().commit();
		} catch (GradesException exception) {
			throw exception;
		} catch (SQLException exception) {
			throw GradesException.buildTechnicalException("There was a problem trying to commit the transaction with sql server at jdbc:sqlserver://academic-database-server.database.windows.net:1433;database=academic-db;user=academicDmlUser", exception, ExceptionLocation.DATA);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalException("An unexpected problem has ocurred trying to commit the transaction with sql server at jdbc:sqlserver://academic-database-server.database.windows.net:1433;database=academic-db;user=academicDmlUser", exception, ExceptionLocation.DATA);
		}
	}

	@Override
	public void rollbackTransaction() {
		if (UtilConnection.isClosed(getConnection())) {
			throw GradesException.buildTechnicalException("It's not possible to rollback the transaction because the connection is closed");
		}

		try {

			if (getConnection().getAutoCommit()) {
				throw GradesException.buildTechnicalException("It's not possible to rollback the transaction because the database is managing the transaction");
			}

			getConnection().rollback();
		} catch (GradesException exception) {
			throw exception;
		} catch (SQLException exception) {
			throw GradesException.buildTechnicalException("There was a problem trying to rollback the transaction with sql server at jdbc:sqlserver://academic-database-server.database.windows.net:1433;database=academic-db;user=academicDmlUser", exception, ExceptionLocation.DATA);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalException("An unexpected problem has ocurred trying to rollback the transaction with sql server at jdbc:sqlserver://academic-database-server.database.windows.net:1433;database=academic-db;user=academicDmlUser", exception, ExceptionLocation.DATA);
		}
	}

	@Override
	public StudentDAO getStudentDAO() {
		return StudentAzureSqlDAO.build(getConnection());
	}

	@Override
	public IdTypeDAO getIdTypeDAO() {
		return IdTypeAzureSqlDAO.build(getConnection());
	}

	@Override
	public ProfessorDAO getProfessorDAO() {
		return ProfessorAzureSqlDAO.build(getConnection());
	}

	@Override
	public SubjectDAO getSubjectDAO() {
		return SubjectAzureSqlDAO.build(getConnection());
	}

	@Override
	public AttendanceDAO getAttendanceDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CourseDAO geCourseDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SessionDAO getSessionDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentCourseDAO getCourseDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentCourseStateDAO getStudentCourseStateDAO() {
		// TODO Auto-generated method stub
		return null;
	}
	
}