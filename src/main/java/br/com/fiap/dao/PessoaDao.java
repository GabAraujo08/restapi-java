package br.com.fiap.dao;

import br.com.fiap.exceptions.PessoaNotFoundException;
import br.com.fiap.models.Pessoa;

import java.util.List;

public interface PessoaDao {

    List<Pessoa> findAll();

    void deleteById(Long id) throws PessoaNotFoundException;

    Pessoa save(Pessoa pessoa);

    Pessoa update(Pessoa pessoa) throws PessoaNotFoundException;
}
