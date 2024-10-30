package br.com.fiap.service;

import br.com.fiap.exceptions.PessoaNotFoundException;
import br.com.fiap.exceptions.PessoaNotSavedException;
import br.com.fiap.exceptions.UnsupportedServiceOperationException;
import br.com.fiap.models.Pessoa;

import java.sql.SQLException;
import java.util.List;

public interface PessoaService {

    Pessoa create(Pessoa pessoa) throws UnsupportedServiceOperationException, SQLException, PessoaNotSavedException;

    List<Pessoa> findAll();

    Pessoa update(Pessoa pessoa) throws PessoaNotFoundException, SQLException;

            void deleteById(Long id) throws PessoaNotFoundException, SQLException;
}
