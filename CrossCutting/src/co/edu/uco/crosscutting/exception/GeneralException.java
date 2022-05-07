package co.edu.uco.crosscutting.exception;

import static co.edu.uco.crosscutting.ultil.text.UtilText;
import static co.edu.uco.crosscutting.util.object.UtilObject.getUtilObject;

import co.edu.uco.crosscutting.ultil.text.UtilText;

public class GeneralException extends RuntimeException{
	private static final long serialVersionUID = -349723082969698830L;
	private String userMessage;
	private String technicalMessage;
	private Exception rootException;
	
	
	
	public GeneralException(String userMessage, String technicalMessage, Exception rootException) {
		super();
		setUserMessage(userMessage);
		setTechnicalMessage(technicalMessage);
		setRootException(rootException);
		
	}
	public static GeneralException build(String technicalMessage) {
		return new GeneralException(null, technicalMessage, null);
	}
	private void setUserMessage(String userMessage) {
		this.userMessage =trim(userMessage);
	}
	private void setTechnicalMessage(String technicalMessage) {
		this.technicalMessage = trim(technicalMessage);
	}
	private void setRootException(Exception rootException) {
		this.rootException =getUtilObject().getDefautl(rootException, new Exception();
	}
	
	public String getUserMessage() {
		return userMessage;
	}
	public String getTechnicalMessage() {
		return technicalMessage;
	}
	public Exception getRootException() {
		return rootException;
	}
	
	
	

}
