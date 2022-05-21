package co.edu.uco.grades.data.dao;

import java.util.List;

import co.edu.uco.grades.dto.IdTypeDTO;

public interface IdTypeDAO {

	void create(IdTypeDTO idType);

	void update(IdTypeDTO idType);

	void delete(int id);

	List<IdTypeDTO> find(IdTypeDTO idType);
}
