package org.example;

import java.util.HashMap;
import java.util.Map;

public class BD {
    private static Map<Integer, Funcionario> funcionarios = new HashMap<>();

    public static Funcionario getFuncionario(Integer id) {
        return funcionarios.get(id);
    }

    public static void addFuncionario(Funcionario funcionario) {
        funcionarios.put(funcionario.getId(), funcionario);
    }
}