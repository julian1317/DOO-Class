package co.edu.uco.grades.crosscutting.exception;

import static co.edu.uco.crosscutting.util.object.UtilObject.getUtilObject;

import co.edu.uco.crosscutting.exception.GeneralException;
import co.edu.uco.grades.crosscutting.exception.enumeration.ExceptionLocation;
import co.edu.uco.grades.crosscutting.exception.enumeration.ExceptionType;

public class GradesException extends GeneralException {

	private static final long serialVersionUID = -1820624074583512374L;
	private ExceptionType type;
	private ExceptionLocation location;

	private GradesException(String userMessage, String technicalMessage, String rootException, ExceptionType technical,
			String location2) {
		super(userMessage, technicalMessage, rootException);
		setType(technical);
		setLocation(location2);
	}

	public static GradesException buildUserException(String userMessage) {
		return new GradesException(userMessage, userMessage, null, ExceptionType.BUSINESS, null);
	}

	public static GradesException buildTechnicalException(String technicalMessage) {
		return new GradesException(null, technicalMessage, null, ExceptionType.TECHNICAL, null);
	}
	

	public static GradesException buildTechnicalException(String technicalMessage, Exception rootException,
			ExceptionType type, ExceptionLocation location) {
		return new GradesException(null, technicalMessage, rootException, type, location);
	}
	public static GradesException buildTechnicalDataException(String technicalMessage) {
		return new GradesException(null, technicalMessage, ExceptionType.TECHNICAL, ExceptionLocation.DATA);
	}

	public static GradesException build(String userMessage, String technicalMessage) {
		return new GradesException(userMessage, userMessage, null, null, null);
	}

	public static GradesException build(String userMessage, String technicalMessage, Exception rootException) {
		return new GradesException(userMessage, userMessage, null, null, null);
	}

	private void setType(ExceptionType type) {
		this.type = getUtilObject().getDefault(type, ExceptionType.GENERAL);
	}

	private void setLocation(ExceptionLocation location) {
		this.location = getUtilObject().getDefault(location, ExceptionLocation.GENERAL);
		;
	}

	public ExceptionType getType() {
		return type;
	}

	public ExceptionLocation getLocation() {
		return location;
	}

}
