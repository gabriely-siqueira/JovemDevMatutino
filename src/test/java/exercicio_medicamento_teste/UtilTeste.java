package exercicio_medicamento_teste;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import exercicio_medicamento.EnumAdm;
import exercicio_medicamento.Medicamento;
import exercicio_medicamento.Pessoa;
import exercicio_medicamento.Util;

public class UtilTeste {
    private Util util;

    @BeforeEach
    void init() {
        util = new Util();
        util.clearData();
    }

    @Test
    @DisplayName("Teste addMedicamento")
    void testAddMedicamento() {
        Medicamento medicamento = new Medicamento(1, "Ibuprofeno", EnumAdm.ORAL, Arrays.asList("Penicilina"),
                Arrays.asList("Dor de garganta"));
        Medicamento result = util.addMedicamento(medicamento);
        assertEquals(medicamento, result);
        assertEquals(1, util.getMedicamentos().size());
    }

    @Test
    @DisplayName("Teste addPessoa")
    void testAddPessoa() {
        Medicamento medicamento = new Medicamento(1, "Ibuprofeno", EnumAdm.ORAL, Arrays.asList("Penicilina"),
                Arrays.asList("Dor de garganta"));
        Pessoa pessoa = new Pessoa(1, "Maria", "Dor de garganta", Arrays.asList("Alergia a penicilina"),
                Arrays.asList(medicamento));
        Pessoa result = util.addPessoa(pessoa);
        assertEquals(pessoa, result);
        assertEquals(1, util.getPessoas().size());
    }

    @Test
    @DisplayName("Teste findById")
    void testFindById() {
        Medicamento medicamento = new Medicamento(1, "Ibuprofeno", EnumAdm.ORAL, Arrays.asList("Penicilina"),
                Arrays.asList("Dor de garganta"));
        Pessoa pessoa = new Pessoa(1, "Maria", "Dor de garganta", Arrays.asList("Alergia a penicilina"),
                Arrays.asList(medicamento));
        util.addPessoa(pessoa);

        Pessoa result = util.findById(1);
        assertEquals(pessoa, result);
    }

    @Test
    @DisplayName("Teste findById - Pessoa não encontrada")
    void testFindByIdNotFound() {
        Medicamento medicamento = new Medicamento(1, "Ibuprofeno", EnumAdm.ORAL, Arrays.asList("Penicilina"),
                Arrays.asList("Dor de garganta"));
        Pessoa pessoa = new Pessoa(1, "Maria", "Dor de garganta", Arrays.asList("Alergia a penicilina"),
                Arrays.asList(medicamento));
        util.addPessoa(pessoa);

        Pessoa result = util.findById(2);
        assertNull(result);
    }

    @Test
    @DisplayName("Teste prescricaoMedicamento")
    void testPrescricaoMedicamento() {
        Medicamento medicamento = new Medicamento(1, "Ibuprofeno", EnumAdm.ORAL, Arrays.asList("Penicilina"),
                Arrays.asList("Dor de garganta"));
        util.addMedicamento(medicamento);

        Pessoa pessoa = new Pessoa(1, "Maria", "Dor de garganta", Arrays.asList("Alergia a penicilina"), null);
        util.addPessoa(pessoa);

        util.prescricaoMedicamento(pessoa, medicamento);

        List<Medicamento> medicamentosPrescritos = pessoa.getMedicamentos();
        assertEquals(1, medicamentosPrescritos.size());
        assertEquals(medicamento, medicamentosPrescritos.get(0));
    }

    @Test
    @DisplayName("Teste listaPessoasEMedicamentos")
    void testListaPessoasEMedicamentos() {
        Medicamento medicamento = new Medicamento(1, "Ibuprofeno", EnumAdm.ORAL, Arrays.asList("Penicilina"),
                Arrays.asList("Dor de garganta"));
        Pessoa pessoa = new Pessoa(1, "Maria", "Dor de garganta", Arrays.asList("Alergia a penicilina"),
                Arrays.asList(medicamento));
        util.addPessoa(pessoa);

        System.out.println("Lista de Pessoas e Medicamentos:");
        util.listaPessoasEMedicamentos();
    }
}
