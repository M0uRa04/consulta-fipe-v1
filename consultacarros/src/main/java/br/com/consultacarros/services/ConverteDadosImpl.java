package br.com.consultacarros.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConverteDadosImpl implements IConverteDados {
    ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public <T> T obterDados(String json, TypeReference<T> typeReference) {
        try {
            return objectMapper.readValue(json, typeReference);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
