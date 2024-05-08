package br.com.consultacarros.services;

import com.fasterxml.jackson.core.type.TypeReference;

public interface IConverteDados {
    <T> T converterDados(String json, TypeReference<T> TypeReference);
}
