package co.edu.uco.grades.data.factory;
import java.sql.Connection;

import co.edu.uco.grades.data.dao.StudentDAO;
public abstract class DAOFactory {
	public static DAOFactory getDaoFActory()
	{
		return null;
	}	
	protected abstract void openConnection();
	protected abstract Connection getCoonection();
	public abstract void initTransaction();
	public abstract void closeConnectio();
	public abstract void  commitTransaction();
	public abstract void rollbackTransaction();
	public abstract StudentDAO getStudentDAO();
	

}
