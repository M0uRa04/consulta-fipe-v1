package br.com.consultacarros.model;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public record Resultado(@JsonAlias("modelos")List<DadosModelos> modelosList, @JsonAlias("anos") List<Ano> anosList) {}
