package br.com.consultacarros.services;

import com.fasterxml.jackson.core.type.TypeReference;

public interface IConverteDados {
    <T> T obterDados (String json, TypeReference<T> TypeReference);
}
