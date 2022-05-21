package co.edu.uco.businesslogic.business.impl;

import java.util.List;

import co.edu.uco.businesslogic.bussines.IdTypeBusiness;
import co.edu.uco.crosscutting.util.object.UtilObject;
import co.edu.uco.grades.crosscutting.exception.GradesException;
import co.edu.uco.grades.data.factory.DAOFactory;
import co.edu.uco.grades.dto.IdTypeDTO;

public class IdTypeBusinesImpl implements IdTypeBusiness {
	
private DAOFactory daoFactory;
public IdTypeBusinesImpl (DAOFactory daoFactory) {
	if(UtilObject.getUtilObject().isNull(daoFactory)){
		throw GradesException.buildTechnicalBusinessException("it's no possible create a IdTypeBusinessImpl when the daoFactory is null");
	}
	this.daoFactory= daoFactory;
}
@Override
public void create(IdTypeDTO dto) {
	// TODO Auto-generated method stub
	 daoFactory.getIdTypeDAO().create(dto);
}
@Override
public void update(IdTypeDTO dto) {
	// TODO Auto-generated method stub
	 daoFactory.getIdTypeDAO().update(dto);
}
@Override
public void delete(int id) {
	// TODO Auto-generated method stub
	 daoFactory.getIdTypeDAO().delete(id);
}
@Override
public List<IdTypeDTO> find(IdTypeDTO dto) {
	// TODO Auto-generated method stub
	return daoFactory.getIdTypeDAO().find(dto);
}
}
