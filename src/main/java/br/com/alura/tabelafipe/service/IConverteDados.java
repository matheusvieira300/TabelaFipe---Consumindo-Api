package br.com.alura.tabelafipe.service;

import java.util.List;

public interface IConverteDados {
   <T> T obterDados(String json, Class<T> classe);//<T> T Generics pois ainda não sei o tipo de retorno, usado para obter um dado

   <T> List<T> obterLista(String json, Class<T> classe);//usado para obter uma lista
}
