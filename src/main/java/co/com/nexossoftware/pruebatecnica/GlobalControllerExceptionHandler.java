package co.com.nexossoftware.pruebatecnica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import co.com.nexossoftware.pruebatecnica.dto.RespuestaDto;

@ControllerAdvice
public class GlobalControllerExceptionHandler extends ResponseEntityExceptionHandler {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.web.servlet.mvc.method.annotation.
	 * ResponseEntityExceptionHandler#handleMethodArgumentNotValid(org.
	 * springframework.web.bind.MethodArgumentNotValidException,
	 * org.springframework.http.HttpHeaders, org.springframework.http.HttpStatus,
	 * org.springframework.web.context.request.WebRequest)
	 */
	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		Map<String, List<String>> errors = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			if (!errors.containsKey(fieldName)) {
				errors.put(fieldName, new ArrayList<>());
			}

			errors.get(fieldName).add(error.getDefaultMessage());
		});

		return ResponseEntity.ok(new RespuestaDto(false, "VALIDATION_ERROR", errors));
	}

}
