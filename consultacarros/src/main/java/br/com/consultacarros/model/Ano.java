package br.com.consultacarros.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record Ano(@JsonAlias("codigo") String codigoAno,
                  @JsonAlias("nome") String nomeAno) {
}
