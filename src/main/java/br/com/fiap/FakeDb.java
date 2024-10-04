package br.com.fiap;

import java.util.ArrayList;
import java.util.List;

public class FakeDb {



    public FakeDb(List<InputDto> nomesCadastrados) {
        this.nomesCadastrados = new ArrayList<>();
        InputDto primeiroRegistro = new InputDto();
        primeiroRegistro.setNome("Maria");
        nomesCadastrados.add(primeiroRegistro);
    }

    public List<InputDto> getNomesCadastrados() {
        return nomesCadastrados;
    }

    public void setNomesCadastrados(List<InputDto> nomesCadastrados) {
        this.nomesCadastrados = nomesCadastrados;
    }
}
