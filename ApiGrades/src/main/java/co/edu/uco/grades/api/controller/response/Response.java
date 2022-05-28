package co.edu.uco.grades.api.controller.response;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.crosscutting.util.object.UtilObject;




public class Response<D> {
	private List<D> data;
	private List<String> messages;
	
	public Response() {
		super();
		setData(new ArrayList<>());
		setMessages(new ArrayList<>());
		
	}
	
	
	public Response(List<D> data, List<String> messages) {
		super();
		setData(data);
		setMessages(messages);
	}
	
	
	public List<D> getData() {
		return data;
	}
	public void setData(List<D> data) {
		this.data = UtilObject.getUtilObject().getDefault(data, new ArrayList<>());
	}
	public List<String> getMessages() {
		return messages;
	}
	public void setMessages(List<String> message) {
		this.messages = message;
	}
	
	

}
