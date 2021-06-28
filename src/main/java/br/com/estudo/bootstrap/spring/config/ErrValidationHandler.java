package br.com.estudo.bootstrap.spring.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.AbstractMessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.estudo.bootstrap.spring.config.form.ErrFormDTO;

@RestControllerAdvice
public class ErrValidationHandler {

	private AbstractMessageSource massageSource;

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErrFormDTO> handle(MethodArgumentNotValidException exception) {
		List<ErrFormDTO> formErr = new ArrayList<ErrFormDTO>();
		List<FieldError> camposErr = exception.getBindingResult().getFieldErrors();
		camposErr.forEach(campo -> {
			String msg = massageSource.getMessage(campo, LocaleContextHolder.getLocale());
			formErr.add(new ErrFormDTO(campo.getField(), msg));
		});
		return formErr;
	}

}
