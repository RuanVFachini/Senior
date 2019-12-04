package com.senior.teste.Exception;

public class HospedeNaoEncontradoException extends RuntimeException{

    public HospedeNaoEncontradoException(Long id){
        super("Não foi encontrado hospede para o id:" + id);
    }
}
