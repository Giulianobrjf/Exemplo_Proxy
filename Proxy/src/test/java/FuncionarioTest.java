import org.example.BD;
import org.example.Funcionario;
import org.example.FuncionarioProxy;
import org.example.Gestor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class FuncionarioTest {

    @BeforeEach
    void setUp() {
        BD.addFuncionario(new Funcionario(1, "João", "Juiz de Fora", 8.0f, 9.0f));
        BD.addFuncionario(new Funcionario(2, "Maria", "Juiz de Fora", 10.0f, 10.0f));
    }

    @Test
    void deveRetornarDadosPessoaisFuncionario() {
        FuncionarioProxy funcionario = new FuncionarioProxy(1);

        assertEquals(Arrays.asList("João", "Juiz de Fora"), funcionario.obterDadosPessoais());
    }

    @Test
    void deveRetornarDesempenhoFuncionario() {
        Gestor gestor = new Gestor("Ana", true);
        FuncionarioProxy funcionario = new FuncionarioProxy(2);

        assertEquals(Arrays.asList(10.0f, 10.0f), funcionario.obterDesempenho(gestor));
    }

    @Test
    void deveRetornarExcecaoUsuarioNaoAutorizadoConsultarDesempenhoFuncionario() {
        try {
            Gestor gestor = new Gestor("Joana", false);
            FuncionarioProxy funcionario = new FuncionarioProxy(2);

            funcionario.obterDesempenho(gestor);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Gestor não autorizado", e.getMessage());
        }
    }
}
