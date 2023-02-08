package com.martinez.app.proyecto1.dtos;

import java.util.Map;

public class ResponsesDTO {
	private Map<String, String> errores;
	private Map<String, String> messages;
	
	public ResponsesDTO() {
		super();
	}

	public Map<String, String> getErrores() {
		return errores;
	}

	public void setErrores(Map<String, String> errores) {
		this.errores = errores;
	}

	public Map<String, String> getMessages() {
		return messages;
	}

	public void setMessages(Map<String, String> messages) {
		this.messages = messages;
	}
	
	
}	
