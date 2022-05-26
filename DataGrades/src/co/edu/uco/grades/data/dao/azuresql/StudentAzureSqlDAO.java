package co.edu.uco.grades.data.dao.azuresql;

import static co.edu.uco.crosscutting.util.text.UtilText.SPACE;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.uco.crosscutting.util.numeric.UtilNumeric;
import co.edu.uco.crosscutting.util.object.UtilObject;
import co.edu.uco.crosscutting.util.text.UtilText;
import co.edu.uco.grades.crosscutting.exception.GradesException;
import co.edu.uco.grades.data.dao.StudentDAO;
import co.edu.uco.grades.data.dao.connection.ConnectionSQL;

import co.edu.uco.grades.dto.StudentDTO;

public class StudentAzureSqlDAO extends ConnectionSQL implements StudentDAO {

	private StudentAzureSqlDAO(Connection connection) {
		super(connection);
	}

	public static StudentDAO build(Connection connection) {
		return new StudentAzureSqlDAO(connection);
	}

	@Override
	public void create(StudentDTO student) {
		String sql = "INSERT INTO Student(name) VALUES (?)";
		try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setString(1, student.getName());

			preparedStatement.executeUpdate();

		} catch (SQLException exception) {
			throw GradesException.buildTechnicalDataException("There was a problem trying to create the new StudentDTO on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataException("An unexpected problem has ocurred trying to create the new StudentDTO on Azure SQL Server", exception);
		}
	}

	@Override
	public void update(StudentDTO student) {
		
		String sql = "UPDATE Student SET name = ? WHERE id = ?";

		try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setString(1, student.getName());
			preparedStatement.setInt(2, student.getId());

			preparedStatement.executeUpdate();

		} catch (SQLException exception) {
			throw GradesException.buildTechnicalDataException("There was a problem trying to update the Student on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataException("An unexpected problem has ocurred trying to update the Student on Azure SQL Server", exception);
		}

	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM Student WHERE id = ?";

		try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setInt(1, id);

			preparedStatement.executeUpdate();

		} catch (SQLException exception) {
			throw GradesException.buildTechnicalDataException("There was a problem trying to delete the Student on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataException("An unexpected problem has ocurred trying to delete the Student on Azure SQL Server", exception);
		}
	}

	
	@Override
	public List<StudentDTO> find (StudentDTO student) {
		boolean setWhere = true;
		List<Object> parameters = new ArrayList<>();
		List<StudentDTO> results = new ArrayList<>();

		StringBuilder sb = new StringBuilder();
		sb.append("SELECT	id, name ");
		sb.append("FROM		Student ").append(SPACE);

		if (!UtilObject.getUtilObject().isNull(student)) {

			if (UtilNumeric.getUtilNumeric().isGreaterThan(student.getId(), 0)) {
				sb.append("WHERE id = ? ");
				parameters.add(student.getId());
				setWhere = false;
			}

			if (!UtilText.isEmpty(student.getName())) {
				sb.append(setWhere ? "WHERE " : "AND ");
				sb.append("name = ? ");
				parameters.add(UtilText.trim(student.getName()));
			}
		}

		sb.append("ORDER BY	name ASC");

		try (PreparedStatement preparedStatement = getConnection().prepareStatement(sb.toString())) {

			for (int index = 0; index < parameters.size(); index++) {
				preparedStatement.setObject(index + 1, parameters.get(index));
			}

			results = executeQuery(preparedStatement);

		} catch (GradesException exception) {
			throw exception;
		} catch (SQLException exception) {
			throw GradesException.buildTechnicalDataException("There was a problem trying to retrive the StudentDTO on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataException("An unexpected problem has ocurred trying to retrieve the StudentDTO on Azure SQL Server", exception);
		}

		return results;
	}
	

	
	private List<StudentDTO> executeQuery(PreparedStatement preparedStatement) {

		List<StudentDTO> results = new ArrayList<>();

		try (ResultSet resultSet = preparedStatement.executeQuery()) {
			results = assembleResults(resultSet);
		} catch (GradesException exception) {
			throw exception;
		} catch (SQLException exception) {
			throw GradesException.buildTechnicalDataException("There was a problem trying to execute the query for recovery the StudentDTO on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataException("An unexpected problem has ocurred trying to execute the query for recovery the StudentDTO on Azure SQL Server", exception);
		}

		return results;
	}
	private List<StudentDTO> assembleResults(ResultSet resultSet) {
		List<StudentDTO> results = new ArrayList<>();

		try {
			while (resultSet.next()) {
				results.add(assembleDTO(resultSet));
			}
		} catch (GradesException exception) {
			throw exception;
		} catch (SQLException exception) {
			throw GradesException.buildTechnicalDataException("There was a problem trying to recover the StudentDTO on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataException("An unexpected problem has ocurred trying to recover the StudentDTO on Azure SQL Server", exception);
		}

		return results;
	}
	private StudentDTO assembleDTO(ResultSet resultSet) {

		StudentDTO dto = new StudentDTO();

		try {
			dto.setId(resultSet.getInt("id"));
			dto.setName(resultSet.getString("name"));
		} catch (SQLException exception) {
			throw GradesException.buildTechnicalDataException("There was a problem trying to assemble the IdType on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataException("An unexpected problem has ocurred trying to assemble the IdType on Azure SQL Server", exception);
		}

		return dto;
	}
	
	

}
