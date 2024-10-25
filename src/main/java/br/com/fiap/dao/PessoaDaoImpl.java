package br.com.fiap.dao;

import br.com.fiap.config.DatabaseConnectionFactory;
import br.com.fiap.exceptions.PessoaNotFoundException;
import br.com.fiap.exceptions.PessoaNotSavedException;
import br.com.fiap.models.Pessoa;
import oracle.jdbc.OracleType;

import java.sql.*;
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
                        resultSet.getLong("id"),
                        resultSet.getString("nome"));
                all.add(pessoa);
            }
        } catch (SQLException e) {
            logger.warning("não foi possível localizar nenhum registro de pessoa: "+e.getMessage());
        }
        return all;
    }

    @Override
    public void deleteById(Long id,Connection connection) throws PessoaNotFoundException, SQLException {
        final String sql = "delete from pessoa where id = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setLong(1, id);
        int linhasAlteradas = stmt.executeUpdate();
        if(linhasAlteradas == 0) {
            throw new PessoaNotFoundException();
        }
    }

    @Override
    public Pessoa save(Pessoa pessoa,Connection connection) throws SQLException, PessoaNotSavedException {
        final String sql = "BEGIN INSERT INTO PESSOA(NOME) VALUES (?) RETURNING ID INTO ?; END;";
        CallableStatement call = connection.prepareCall(sql);
        call.setString(1,pessoa.getNome());
        call.registerOutParameter(2, OracleType.NUMBER);

        int linhasAlteradas = call.executeUpdate();
        long id = call.getLong(2);
        if(linhasAlteradas == 0 || id == 0){
            throw new PessoaNotSavedException();
        }
        pessoa.setId(id);
        return pessoa;
    }

    @Override
    public Pessoa update(Pessoa pessoa,Connection connection) throws PessoaNotFoundException, SQLException {
        final String sql = "UPDATE pessoa set nome=? where id = ?";

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1,pessoa.getNome());
        stmt.setLong(2, pessoa.getId());
        int linhasAlteradas = stmt.executeUpdate();

        if(linhasAlteradas == 0 ) {
            throw new PessoaNotFoundException();
        }
        return pessoa;
    }
}
