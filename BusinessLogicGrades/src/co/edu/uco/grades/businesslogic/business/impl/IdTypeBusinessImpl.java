package co.edu.uco.grades.businesslogic.business.impl;

import java.util.List;

import co.edu.uco.crosscutting.util.object.UtilObject;
import co.edu.uco.crosscutting.util.text.UtilText;
import co.edu.uco.grades.businesslogic.business.IdTypeBusiness;
import co.edu.uco.grades.crosscutting.exception.GradesException;
import co.edu.uco.grades.data.factory.DAOFactory;
import co.edu.uco.grades.dto.IdTypeDTO;

public class IdTypeBusinessImpl implements IdTypeBusiness {

	private DAOFactory daoFactory;

	public IdTypeBusinessImpl(DAOFactory daoFactory) {
		if (UtilObject.getUtilObject().isNull(daoFactory)) {
			throw GradesException.buildTechnicalBusinessLogicException("It's not possible create a IdTypeBusinessImpl when the DAOFactory is null");
		}

		this.daoFactory = daoFactory;
	}

	@Override
	public void create(IdTypeDTO dto) {
		
		validateIdTypeDoesNotExistWithSameName(dto);
		daoFactory.getIdTypeDAO().create(dto);
	}
	private void validateIdTypeDoesNotExistWithSameName(IdTypeDTO dto) {
		IdTypeDTO dtoValidator = new IdTypeDTO();
		dtoValidator.setName(dto.getName());
		List<IdTypeDTO> list =daoFactory.getIdTypeDAO().find(dtoValidator);
		if(!list.isEmpty()) {
			var message="an id type with the same name alredy exist";
			throw GradesException.buildBusinessLogicException(message);
			
			
		}
	}

	@Override
	public void update(IdTypeDTO dto) {
		validateIdTypeDoesNotExist(dto);
		validateIdTypeDoesNotExistWithSameName(dto);
		daoFactory.getIdTypeDAO().update(dto);
	}

	@Override
	public void delete(int id) {
		IdTypeDTO dto = new IdTypeDTO(id , UtilText.EMPTY);
		
		
		validateIdTypeDoesNotExist(dto);
		daoFactory.getIdTypeDAO().delete(id);
	}

	@Override
	public List<IdTypeDTO> find(IdTypeDTO dto) {
		
		
		return daoFactory.getIdTypeDAO().find(dto);
	}
	
	private void validateIdTypeDoesNotExist(IdTypeDTO dto) {
		IdTypeDTO dtoValidator = new IdTypeDTO();
		dtoValidator.setId(dto.getId());
		List<IdTypeDTO> list =daoFactory.getIdTypeDAO().find(dtoValidator);
		if(list.isEmpty()) {
			var message="this id does not exist";
			throw GradesException.buildBusinessLogicException(message);
			
			
		}
	}

	@Override
	public List<IdTypeDTO> findById(IdTypeDTO dto) {
		IdTypeDTO dtoValidator = new IdTypeDTO();
		dtoValidator.setId(dto.getId());
		List<IdTypeDTO> list =daoFactory.getIdTypeDAO().find(dtoValidator);
		if(list.isEmpty()) {
			var message="this id does not exist";
			throw GradesException.buildBusinessLogicException(message);
			
			
		}
		return daoFactory.getIdTypeDAO().findById(dto);
	}
	
	
	
	
	

}
