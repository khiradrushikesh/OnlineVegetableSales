package com.advices;

import java.time.LocalDateTime;
import java.util.Date;

public class ErrorDetails {

	 private LocalDateTime ldt;
	  private String message;
	  private String details;
	    
	    public ErrorDetails(LocalDateTime ldt, String message, String details) {
	        super();
	        this.ldt = ldt;
	        this.message = message;
	        this.details = details;
	    }   

	    public ErrorDetails(Date date, String message2, String defaultMessage) {
			// TODO Auto-generated constructor stub
		}

		public LocalDateTime getLdt() {
			return ldt;
		}
	    
		public void setLdt(LocalDateTime ldt) {
			this.ldt = ldt;
		}
		
		public String getMessage() {
	         return message;
	    }

	    public String getDetails() {
	         return details;
	    }
}
