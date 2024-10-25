package br.com.fiap.service;

public class PessoaServiceFactory {

    private PessoaServiceFactory() {
    }

    public static PessoaService create(){
        return new PessoaServiceImpl();
    }
}
