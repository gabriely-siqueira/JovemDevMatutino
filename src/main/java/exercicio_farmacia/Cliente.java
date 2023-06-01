package exercicio_farmacia;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cliente {
	private String nome;
	private double saldoDevedor;

	public Cliente(String nome, double saldoDevedor) {
		this.nome = nome;
		this.saldoDevedor = saldoDevedor;

	}

}
