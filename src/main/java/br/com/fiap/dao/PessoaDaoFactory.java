package br.com.fiap.dao;

public final class PessoaDaoFactory {

    private PessoaDaoFactory() {
    }

    public static PessoaDao create() {
        return new PessoaDaoImpl();
    }
}
