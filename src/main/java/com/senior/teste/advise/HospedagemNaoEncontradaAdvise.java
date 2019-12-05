package com.senior.teste.advise;

import com.senior.teste.Exception.HospedagemNaoEncontradaException;
import com.senior.teste.Exception.HospedeNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class HospedagemNaoEncontradaAdvise {

    @ResponseBody
    @ExceptionHandler(HospedagemNaoEncontradaException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String HospedagemNaoEncontradaAdvise(HospedagemNaoEncontradaException ex) {
        return ex.getMessage();
    }
}
