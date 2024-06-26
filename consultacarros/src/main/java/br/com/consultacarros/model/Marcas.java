package br.com.consultacarros.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Marcas (@JsonAlias("nome") String nome,
                    @JsonAlias("codigo") String codigoMarca) {}
