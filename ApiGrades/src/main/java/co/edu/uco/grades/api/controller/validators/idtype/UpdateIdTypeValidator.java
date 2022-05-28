package co.edu.uco.grades.api.controller.validators.idtype;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.crosscutting.util.object.UtilObject;
import co.edu.uco.grades.api.controller.validators.Validator;
import co.edu.uco.grades.dto.IdTypeDTO;

public class UpdateIdTypeValidator implements Validator<IdTypeDTO> {

	private List<String> validationMessages = new ArrayList<>();
	
	@Override
	public List<String> validate(IdTypeDTO dto) {
		if(UtilObject.getUtilObject().isNull(dto)) 
		{
			validationMessages.add("its not possible validate id type data");
		}
		dto.validateName(validationMessages);
		return validationMessages;
	}

}
