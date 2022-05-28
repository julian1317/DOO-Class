package co.edu.uco.grades.api.controller.validators.idtype;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.crosscutting.util.numeric.UtilNumeric;

import co.edu.uco.grades.api.controller.validators.Validator;
import co.edu.uco.grades.dto.IdTypeDTO;

public class FindIdTypeValidator implements Validator<IdTypeDTO> {

	private List<String> validationMessages = new ArrayList<>();
	
	
	@Override
	public List<String> validate(IdTypeDTO dto) {
        if(!UtilNumeric.getUtilNumeric().isGreaterThan(dto.getId(), 0)) 
        {
            validationMessages.add("its not possible validate id or name type data");
        }
        
      
        return validationMessages;
    }
}
