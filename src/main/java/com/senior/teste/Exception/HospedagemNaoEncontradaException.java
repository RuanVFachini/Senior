package com.senior.teste.Exception;

public class HospedagemNaoEncontradaException extends RuntimeException{

    public HospedagemNaoEncontradaException(Long id){
        super("Não foi encontrada hospedagem para o id:" + id);
    }
}
