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
	
	
	public Pessoa findById (final Integer id) {
		return pessoas.stream()
				.filter(pessoa -> id.equals(pessoa.getId()))
				.findAny()
				.orElse(null);
	}

	public Medicamento addMedicamento(Medicamento medicamento) {
		medicamento.setId(medicamentos.size()+1);
		medicamentos.add(medicamento);
		return medicamento;
	}

	public Pessoa addPessoa(Pessoa pessoa) {
		pessoa.setId(pessoas.size()+1);
		pessoas.add(pessoa);
		return pessoa;
	}

	public void prescricaoMedicamento(Pessoa pessoa, Medicamento medicamento) {

		for (String alergia : pessoa.getAlergias()) {
			if (medicamento.getAlergias().contains(alergia)) {
				System.out.println("Aviso: O medicamento '" + medicamento.getNome()
						+ "' está contraindicado devido à alergia a '" + alergia + "'.");
				return;
			}
		}

		if (!medicamento.getIndicacoes().contains(pessoa.getSintoma())) {
			System.out.println("Aviso: O medicamento '" + medicamento.getNome() + "' não é indicado para o sintoma '"
					+ pessoa.getSintoma() + "'.");
			return;
		}

		pessoa.getMedicamentos().add(medicamento);
		System.out.println("Medicamento '" + medicamento.getNome() + "' prescrito para '" + pessoa.getNome() + "'.");
	}

	public void listaPessoasEMedicamentos() {
		for (Pessoa pessoa : pessoas) {
			System.out.println("Nome da Pessoa: " + pessoa.getNome());
			System.out.println("Medicamentos prescritos:");
			for (Medicamento medicamento : pessoa.getMedicamentos()) {
				System.out.println("- Nome: " + medicamento.getNome());
				System.out.println("  Administração: " + medicamento.getAdministracao());
				System.out.println("  Alergias: " + medicamento.getAlergias());
				System.out.println("  Indicações: " + medicamento.getIndicacoes());
			}
			System.out.println("--------------------------");

		}
	}

	public void clearData() {
		medicamentos.clear();
		pessoas.clear();

	}
}
