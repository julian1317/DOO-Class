package co.edu.uco.grades.data.factory.azuresql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import co.edu.uco.crosscutting.util.object.UtilObject;
import co.edu.uco.crosscutting.util.sql.UtilConnection;
import co.edu.uco.grades.crosscutting.exception.GradesException;
import co.edu.uco.grades.crosscutting.exception.enumeration.ExceptionLocation;
import co.edu.uco.grades.crosscutting.exception.enumeration.ExceptionType;
import co.edu.uco.grades.data.dao.StudentDAO;
import co.edu.uco.grades.data.dao.azuresql.StudentAzureSqlDAO;
import co.edu.uco.grades.data.factory.DAOFactory;

public class AzureSqlDaoFactory extends DAOFactory {
	private Connection connection;
	
	private AzureSqlDaoFactory() {
		openConnection();
	}

	@Override
	protected void openConnection() {
		// TODO Auto-generated method stub
		
		String stringConnection= "jdbc:sqlserver://academic-database-server.database.windows.net:1433;database=academic-db;user=academicDmlUser;password=4c4d3m1cDmlUs3r;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30";

				try {
					connection= DriverManager.getConnection(stringConnection);

				}catch ( SQLException exception) {
					throw GradesException.buildTechnicalException("there was a problem trying to get the connection with Sql server at jdbc:sqlserver://academic-database-server.database.windows.net:1433;database=academic-db;user=academicDmlUser ", exception, ExceptionType.TECHNICAL, ExceptionLocation.DATA);
					// TODO: handle exception
				}catch(Exception exception) {
					throw GradesException.buildTechnicalException("there was a problem trying to get the connection with Sql server at jdbc:sqlserver://academic-database-server.database.windows.net:1433;database=academic-db;user=academicDmlUser ", exception, ExceptionType.TECHNICAL, ExceptionLocation.DATA);
					
				}
	}

	@Override
	protected Connection getCoonection() {
		return connection;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeConnectio() {
		if(!UtilConnection.isOpen(connection)) {
			throw GradesException.buildTechnicalException("it's no possible open close because it's alredy closed ");
		}
		
		try {
			getCoonection().close();
		}catch ( SQLException exception) {
			throw GradesException.buildTechnicalException("there was a problem trying to close the connection with Sql server at jdbc:sqlserver://academic-database-server.database.windows.net:1433;database=academic-db;user=academicDmlUser ", exception, ExceptionType.TECHNICAL, ExceptionLocation.DATA);
			
		}catch(Exception exception) {
			throw GradesException.buildTechnicalException("an unexpected problem trying to close the connection with Sql server at jdbc:sqlserver://academic-database-server.database.windows.net:1433;database=academic-db;user=academicDmlUser ", exception, ExceptionType.TECHNICAL, ExceptionLocation.DATA);
			
		}
		
	}
	
	@Override
	public void initTransaction() {
		if(UtilConnection.isClosed(connection))
		{
			throw GradesException.buildTechnicalException("it's no possible open close because it's alredy closed or is null");
		}
		try {
			if (!getCoonection().getAutoCommit()) {
				
	throw GradesException.buildTechnicalException("it's no possible to commit because the data ");
				
			}
			getCoonection().commit();
			getCoonection().setAutoCommit(false);
		}catch ( SQLException exception) {
			throw GradesException.buildTechnicalException("there was a problem trying to rollback the transaction with Sql server at jdbc:sqlserver://academic-database-server.database.windows.net:1433;database=academic-db;user=academicDmlUser ", exception, ExceptionType.TECHNICAL, ExceptionLocation.DATA);
			
		}catch(Exception exception) {
			throw GradesException.buildTechnicalException("an unexpected problem trying to close the transaction with Sql server at jdbc:sqlserver://academic-database-server.database.windows.net:1433;database=academic-db;user=academicDmlUser ", exception, ExceptionType.TECHNICAL, ExceptionLocation.DATA);
			
		}
		
	}

	@Override
	public void commitTransaction() {
		if(UtilConnection.isClosed(connection)) {
			throw GradesException.buildTechnicalException("it's no possible to commit the transation because de connection is closed");
		}
		
		try {
			if (getCoonection().getAutoCommit()) {
				
				throw GradesException.buildTechnicalException("it's no possible to commit because the data ");
				
			}
			getCoonection().commit();
			
		}catch(GradesException exception) {
			throw exception;
		}
		catch ( SQLException exception) {
			throw GradesException.buildTechnicalException("there was a problem trying to commit the connection with Sql server at jdbc:sqlserver://academic-database-server.database.windows.net:1433;database=academic-db;user=academicDmlUser ", exception, ExceptionType.TECHNICAL, ExceptionLocation.DATA);
			
		}catch(Exception exception) {
			throw GradesException.buildTechnicalException("an unexpected problem trying to close the connection with Sql server at jdbc:sqlserver://academic-database-server.database.windows.net:1433;database=academic-db;user=academicDmlUser ", exception, ExceptionType.TECHNICAL, ExceptionLocation.DATA);
			
		}
		
		
		
	}

	@Override
	public void rollbackTransaction() {
		if(UtilConnection.isClosed(connection))
		{
			throw GradesException.buildTechnicalException("it's no possible open close because it's alredy closed or is null");
		}
		
		
		try {
			try {
				if (getCoonection().getAutoCommit()) {
					
					throw GradesException.buildTechnicalException("it's no possible to commit because the data ");
					
				}
				getCoonection().commit();
				
			}catch(GradesException exception) {
				throw exception;
			}
			getCoonection().rollback();
		}catch ( SQLException exception) {
			throw GradesException.buildTechnicalException("there was a problem trying to rollback the transaction with Sql server at jdbc:sqlserver://academic-database-server.database.windows.net:1433;database=academic-db;user=academicDmlUser ", exception, ExceptionType.TECHNICAL, ExceptionLocation.DATA);
			
		}catch(Exception exception) {
			throw GradesException.buildTechnicalException("an unexpected problem trying to close the transaction with Sql server at jdbc:sqlserver://academic-database-server.database.windows.net:1433;database=academic-db;user=academicDmlUser ", exception, ExceptionType.TECHNICAL, ExceptionLocation.DATA);
			
		}
		
	}
	

	@Override
	public StudentDAO getStudentDAO() {
	
		return StudentAzureSqlDAO.create(getCoonection());
	}
	

}
