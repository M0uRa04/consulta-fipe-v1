package br.com.consultacarros.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public record Modelos(@JsonAlias("codigo") String codigoModelo,
                      @JsonAlias("nome") String nomeModelo) {
}
