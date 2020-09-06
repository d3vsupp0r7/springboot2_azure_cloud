package org.lba.springboot2.azure.servicebus;

import java.io.Serializable;
import java.math.BigDecimal;

public class MessageData implements Serializable {

	private BigDecimal idMessage;
	private String message;
	
	public MessageData() {
		// Implement if necessary
	}

	public MessageData(BigDecimal idMessage, String message) {
		super();
		this.idMessage = idMessage;
		this.message = message;
	}

	public BigDecimal getIdMessage() {
		return idMessage;
	}

	public void setIdMessage(BigDecimal idMessage) {
		this.idMessage = idMessage;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "MessageData [idMessage=" + idMessage + ", message=" + message + "]";
	}
	
	
}
