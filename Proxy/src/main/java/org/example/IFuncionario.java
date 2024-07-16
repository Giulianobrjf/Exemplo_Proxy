package org.example;

import java.util.List;

public interface IFuncionario {
    List<String> obterDadosPessoais();
    List<Float> obterDesempenho(Gestor gestor);
}