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
import co.edu.uco.grades.data.dao.IdTypeDAO;
import co.edu.uco.grades.data.dao.connection.ConnectionSQL;
import co.edu.uco.grades.dto.IdTypeDTO;

public class IdTypeAzureSqlDAO extends ConnectionSQL implements IdTypeDAO {

	private IdTypeAzureSqlDAO(Connection connection) {
		super(connection);
	}

	public static IdTypeDAO build(Connection connection) {
		return new IdTypeAzureSqlDAO(connection);
	}

	@Override
	public void create(IdTypeDTO idType) {
		String sql = "INSERT INTO IdType(name) VALUES (?)";

		try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setString(1, idType.getName());

			preparedStatement.executeUpdate();

		} catch (SQLException exception) {
			throw GradesException.buildTechnicalDataException(
					"There was a problem trying to create the new IdType on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataException(
					"An unexpected problem has ocurred trying to create the new IdType on Azure SQL Server", exception);
		}
	}

	@Override
	public void update(IdTypeDTO idType) {
		String sql = "update  IdTupe SET name ? where";

		try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setString(1, idType.getName());

			preparedStatement.executeUpdate();

		} catch (SQLException exception) {
			throw GradesException.buildTechnicalDataException(
					"There was a problem trying to update the new IdType on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataException(
					"An unexpected problem has ocurred trying to create the new IdType on Azure SQL Server", exception);
		}
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE  FROM idType WHERE id = ?";

		try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setInt(1, id);

			preparedStatement.executeUpdate();

		} catch (SQLException exception) {
			throw GradesException.buildTechnicalDataException(
					"There was a problem trying to update the new IdType on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataException(
					"An unexpected problem has ocurred trying to create the new IdType on Azure SQL Server", exception);
		}
	}

	@Override
	public List<IdTypeDTO> find(IdTypeDTO idType) {
		boolean setWhere = true;

		List<Object> parameters = new ArrayList<>();
		List<IdTypeDTO> results = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT id, name").append(SPACE);
		sb.append("FROM IdType").append(SPACE);

		if (!UtilObject.getUtilObject().isNull(idType)) {
			if (UtilNumeric.getUtilNumeric().isGreaterThan(idType.getId(), 0)) {

				sb.append("where id = ? ");
				parameters.add(idType.getId());
				setWhere = false;
			}
			if (!UtilText.isEmpty(idType.getName())) {
				sb.append(setWhere ? "WHERE " : "AND ");
				sb.append("name= ? ");
				parameters.add(UtilText.trim(idType.getName()));

			}
			sb.append(" ORDER BY name ASC ");
		

		try (PreparedStatement preparedStatement = getConnection().prepareStatement(sb.toString())) {

			for (int index = 0; index < parameters.size(); index++) {
				preparedStatement.setObject(index + 1, parameters.get(index));
			}

			try (ResultSet resultSet = preparedStatement.executeQuery()) {

			}

		} catch (SQLException exception) {
			throw GradesException.buildTechnicalDataException(
					"There was a problem trying to find  the  IdType on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataException(
					"An unexpected problem has ocurred trying to create the new IdType on Azure SQL Server", exception);
		}
		return results;

	}

	private List<IdTypeDTO> assemblerResults(ResultSet resultSet){
		List<IdTypeDTO> results = new ArrayList<>();
		try {
		while(resultSet.next()) {
			results.add(assemblerDto(resultSet))
			
		}
		catch (GradesException exception) {
			throw exception;
		}
	 catch (SQLException exception) {
		throw GradesException.buildTechnicalDataException("There was a triying to recover the idTypes on Azure SQL Server", exception);
	} catch (Exception exception) {
		throw GradesException.buildTechnicalDataException("An unexpected problem has ocurred trying ttriying to recover the idTypes new IdType on Azure SQL Server", exception);
	}
		return results;
	

	}

	private List<IdTypeDTO> executeQuery(PreparedStatement preparedStatement){
			List<IdTypeDTO> results = new ArrayList<>();
			try(ResultSet resultSet= preparedStatement.executeQuery()) {
				results=assemblerResults(ResultSet);
				catch (GradesException exception) {
					throw exception;
				}
			 catch (SQLException exception) {
				throw GradesException.buildTechnicalDataException("There was a triying to recover the idTypes on Azure SQL Server", exception);
			} catch (Exception exception) {
				throw GradesException.buildTechnicalDataException("An unexpected problem has ocurred trying ttriying to recover the idTypes new IdType on Azure SQL Server", exception);
			}
				return results;
			
			
		}

	private IdTypeDTO assemblerDto(ResultSet resultSet) {
		IdTypeDTO dto= new IdTypeDTO();
		try {
			dto.setId(resultSet.getInt("id"));
			dto.setName(resultSet.getString("name"));
			
			while(resultSet.next()) {
				results.add(assemblerDto(resultSet))
				
			}
		} catch (SQLException exception) {
			throw GradesException.buildTechnicalDataException("There was a triying to assembler the idTypes on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataException("An unexpected problem has ocurred trying ttriying to assambler the idTypes new IdType on Azure SQL Server", exception);
		}
		
		return dto;
	}

}
