package br.com.fiap.dao;

import br.com.fiap.exceptions.PessoaNotFoundException;
import br.com.fiap.models.Pessoa;

import java.util.List;

class PessoaDaoImpl implements PessoaDao {
    @Override
    public List<Pessoa> findAll() {
        return List.of();
    }

    @Override
    public void deleteById(Long id) throws PessoaNotFoundException {

    }

    @Override
    public Pessoa save(Pessoa pessoa) {
        return null;
    }

    @Override
    public Pessoa update(Pessoa pessoa) throws PessoaNotFoundException {
        return null;
    }
}
