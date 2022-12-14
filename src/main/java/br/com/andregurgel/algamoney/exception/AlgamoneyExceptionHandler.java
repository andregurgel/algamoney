package br.com.andregurgel.algamoney.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ControllerAdvice
public class AlgamoneyExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String mensagemUsuario = messageSource.getMessage("mensagem.invalida", null, LocaleContextHolder.getLocale());
        String mensagemDev = ex.getCause().toString();
        List<Erro> erroList = Collections.singletonList(new Erro(mensagemUsuario, mensagemDev));
        return handleExceptionInternal(ex, erroList, headers, HttpStatus.BAD_REQUEST, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<Erro> erroList = criarListaDeErros(ex.getBindingResult());
        return handleExceptionInternal(ex, erroList, headers, HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler({ EmptyResultDataAccessException.class })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleEmptyResultDataAccessException() { }

    @ExceptionHandler({ DataIntegrityViolationException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handleDataIntegrityViolationException() { }

    private List<Erro> criarListaDeErros(BindingResult bindingResult) {
        List<Erro> erroList = new ArrayList<>();

        bindingResult.getFieldErrors().forEach((field) -> {
            String msgUsuario = messageSource.getMessage(field, LocaleContextHolder.getLocale());
            String msgDev = field.toString();
            erroList.add(new Erro(msgUsuario, msgDev));
        });

        return erroList;
    }

    public static class Erro {
        private String msgUsuario;
        private String msgDev;

        public Erro(String msgUsuario, String msgDev) {
            this.msgUsuario = msgUsuario;
            this.msgDev = msgDev;
        }

        public String getMsgUsuario() {
            return msgUsuario;
        }

        public String getMsgDev() {
            return msgDev;
        }
    }
}
