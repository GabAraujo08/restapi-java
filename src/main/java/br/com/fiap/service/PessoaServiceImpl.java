package br.com.fiap.service;

import br.com.fiap.dao.PessoaDao;
import br.com.fiap.dao.PessoaDaoFactory;
import br.com.fiap.exceptions.PessoaNotFoundException;
import br.com.fiap.exceptions.UnsupportedServiceOperationException;
import br.com.fiap.models.Pessoa;

import java.util.List;

final class PessoaServiceImpl implements PessoaService {

    private PessoaDao dao = PessoaDaoFactory.create();

    @Override
    public Pessoa create(Pessoa pessoa) throws UnsupportedServiceOperationException {
        if (pessoa.getId() == null) {
            return this.dao.save(pessoa);
        }else{
            throw new UnsupportedServiceOperationException();
        }
    }

    @Override
    public List<Pessoa> findAll() {
        return this.dao.findAll();
    }

    @Override
    public Pessoa update(Pessoa pessoa) throws PessoaNotFoundException {
        return this.dao.update(pessoa);
    }

    @Override
    public void deleteById(Long id) throws PessoaNotFoundException {
        this.dao.deleteById(id);
    }


}
