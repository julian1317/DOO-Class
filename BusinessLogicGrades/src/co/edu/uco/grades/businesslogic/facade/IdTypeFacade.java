package co.edu.uco.grades.businesslogic.facade;

import java.util.List;

import co.edu.uco.grades.dto.IdTypeDTO;

public interface IdTypeFacade {
	
	void create(IdTypeDTO dto);

	void update(IdTypeDTO dto);

	void delete(int id);

	List<IdTypeDTO> find(IdTypeDTO dto);
	

}
