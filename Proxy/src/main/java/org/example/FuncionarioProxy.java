package org.example;

import java.util.List;

public class FuncionarioProxy implements IFuncionario {

    private Funcionario funcionario;
    private Integer id;

    public FuncionarioProxy(Integer id) {
        this.id = id;
    }

    @Override
    public List<String> obterDadosPessoais() {
        if (this.funcionario == null) {
            this.funcionario = new Funcionario(this.id);
        }
        return this.funcionario.obterDadosPessoais();
    }

    @Override
    public List<Float> obterDesempenho(Gestor gestor) {
        if (!gestor.isAdministrador()) {
            throw new IllegalArgumentException("Gestor não autorizado");
        }
        if (this.funcionario == null) {
            this.funcionario = new Funcionario(this.id);
        }
        return this.funcionario.obterDesempenho(gestor);
    }
}