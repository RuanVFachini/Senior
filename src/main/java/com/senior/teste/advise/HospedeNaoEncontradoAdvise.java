package com.senior.teste.advise;

import com.senior.teste.Exception.HospedeNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class HospedeNaoEncontradoAdvise {

    @ResponseBody
    @ExceptionHandler(HospedeNaoEncontradoException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String HuspedeNaoEncontradoAdvise(HospedeNaoEncontradoException ex) {
        return ex.getMessage();
    }
}
