package br.com.rafael.adopet.tutor.exceptions.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class ErrorResponse {
		private Date timestamp;
		private String status;
		private String message;
		private String details;
}
