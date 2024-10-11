package br.com.fiap.infra;

import br.com.fiap.dtos.PessoaDto;

import java.util.HashMap;
import java.util.Map;

public class FakeDb {
    public static Map<Long, PessoaDto> nomesCadastrados = new HashMap<>();

}
