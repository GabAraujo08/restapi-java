package br.com.fiap.service;

import br.com.fiap.exceptions.PessoaNotFoundException;
import br.com.fiap.models.Pessoa;

import java.util.List;

class PessoaServiceImpl implements PessoaService {



    @Override
    public Pessoa create(Pessoa pessoa) {
        return null;
    }

    @Override
    public List<Pessoa> findAll() {
        return List.of();
    }

    @Override
    public Pessoa update(Pessoa pessoa) throws PessoaNotFoundException {
        return null;
    }

    @Override
    public void deleteById(Long id) throws PessoaNotFoundException {

    }
}
