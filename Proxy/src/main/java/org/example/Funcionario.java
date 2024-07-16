package org.example;

import java.util.Arrays;
import java.util.List;

public class Funcionario implements IFuncionario {

    private Integer id;
    private String nome;
    private String departamento;
    private Float desempenho1;
    private Float desempenho2;

    public Funcionario(int id) {
        this.id = id;
        Funcionario objeto = BD.getFuncionario(id);
        this.nome = objeto.nome;
        this.departamento = objeto.departamento;
        this.desempenho1 = objeto.desempenho1;
        this.desempenho2 = objeto.desempenho2;
    }

    public Funcionario(Integer id, String nome, String departamento, Float desempenho1, Float desempenho2) {
        this.id = id;
        this.nome = nome;
        this.departamento = departamento;
        this.desempenho1 = desempenho1;
        this.desempenho2 = desempenho2;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public List<String> obterDadosPessoais() {
        return Arrays.asList(this.nome, this.departamento);
    }

    @Override
    public List<Float> obterDesempenho(Gestor gestor) {
        return Arrays.asList(this.desempenho1, this.desempenho2);
    }
}