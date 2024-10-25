package br.com.fiap.dao;

import br.com.fiap.exceptions.PessoaNotFoundException;
import br.com.fiap.exceptions.PessoaNotSavedException;
import br.com.fiap.models.Pessoa;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface PessoaDao {

    List<Pessoa> findAll();

    void deleteById(Long id,Connection connection) throws PessoaNotFoundException, SQLException;

    Pessoa save(Pessoa pessoa,Connection connection) throws SQLException, PessoaNotSavedException;

    Pessoa update(Pessoa pessoa, Connection connection) throws PessoaNotFoundException, SQLException;

}
