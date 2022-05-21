package co.edu.uco.grades.data.factory;

import java.sql.Connection;

import co.edu.uco.grades.data.dao.IdTypeDAO;
import co.edu.uco.grades.data.dao.StudentDAO;
import co.edu.uco.grades.data.factory.azuresql.AzureSqlDAOFactory;

public abstract class DAOFactory {

	public static DAOFactory getDaoFactory() {
		return AzureSqlDAOFactory.create();
	}

	protected abstract void openConnection();

	protected abstract Connection getConnection();

	public abstract void initTransaction();

	public abstract void closeConnection();

	public abstract void commitTransaction();

	public abstract void rollbackTransaction();

	public abstract StudentDAO getStudentDAO();

	public abstract IdTypeDAO getIdTypeDAO();
}
