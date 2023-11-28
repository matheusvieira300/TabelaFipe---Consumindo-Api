package br.com.alura.tabelafipe.service;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

public class ConverteDados implements IConverteDados {
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T obterDados(String json, Class<T> classe) {
        try {
            return mapper.readValue(json, classe);// para ler o Json repassado e transformar na classe informada
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public <T> List<T> obterLista(String json, Class<T> classe) {
        CollectionType lista = mapper.getTypeFactory() //para gente poder construir uma coleção a partir da classe que repassarmos
            .constructCollectionType(List.class, classe);//construi uma coleção com a classe List.class e o que vai ter dentro da List
            try {
                return mapper.readValue(json, lista);//para obter uma lista de marcas
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
    }
}
