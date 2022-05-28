package co.edu.uco.grades.businesslogic.facade;

import java.util.List;


import co.edu.uco.grades.dto.ProfessorDTO;

public interface ProfessorFacade {
	List<ProfessorDTO> find(ProfessorDTO dto);

}
