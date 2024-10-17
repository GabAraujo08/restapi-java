package br.com.fiap.service;

import br.com.fiap.exceptions.PessoaNotFoundException;
import br.com.fiap.models.Pessoa;

import java.util.List;

public interface PessoaService {

    Pessoa create(Pessoa pessoa);

    List<Pessoa> findAll();

    Pessoa update(Pessoa pessoa) throws PessoaNotFoundException;

    void deleteById(Long id) throws PessoaNotFoundException;
}