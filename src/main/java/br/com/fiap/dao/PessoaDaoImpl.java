package br.com.fiap.dao;

import br.com.fiap.config.DatabaseConnection;
import br.com.fiap.config.DatabaseConnectionFactory;
import br.com.fiap.exceptions.PessoaNotFoundException;
import br.com.fiap.models.Pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

class PessoaDaoImpl implements PessoaDao {

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @Override
    public List<Pessoa> findAll() {
        final List<Pessoa> all = new ArrayList<>();
        final String sql = "SELECT * FROM PESSOA";
        try(Connection conn = DatabaseConnectionFactory.create().get()){
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();
            while(resultSet.next()){
                Pessoa pessoa = new Pessoa(
                        resultSet.getLong("ID"),
                        resultSet.getString("NOME"));
                pessoa.setNome(resultSet.getString("NOME"));
                all.add(pessoa);
            }
        }catch (SQLException e){
            logger.warning("Não foi possível buscar as pessoas." + e.getMessage());

        }
        return all;
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
