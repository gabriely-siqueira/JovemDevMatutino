package exercicio_medicamento;

import java.util.ArrayList;
import java.util.List;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Util {
    private List<Medicamento> medicamentos = new ArrayList<>();
    private List<Pessoa> pessoas = new ArrayList<>();

    public Medicamento addMedicamento(Medicamento medicamento) {
        medicamentos.add(medicamento);
        return medicamento;
    }

    public Pessoa addPessoa(Pessoa pessoa) {
        pessoas.add(pessoa);
        return pessoa;
    }

    public boolean existeMedicamento(Medicamento medicamento) {
        return medicamentos.contains(medicamento);
    }

    public boolean existePessoa(Pessoa pessoa) { 
        return pessoas.contains(pessoa);
    }

    public void prescreveMedicamento(Pessoa pessoa, Medicamento medicamento) {
        if (existeMedicamento(medicamento) && existePessoa(pessoa)) {
            pessoa.addMedicamento(medicamento);
            
        }
    }

    public String listaPessoaMedicamento(Pessoa pessoa) {
        String lista = "";
        if (existePessoa(pessoa)) {
            for (Medicamento medicamento : pessoa.getMedicamentos()) {
                lista += medicamento.toString() + "\n";
            }
        }
        return lista;
    }
    public void clearData() {
        medicamentos.clear();
        pessoas.clear();
    }
}
