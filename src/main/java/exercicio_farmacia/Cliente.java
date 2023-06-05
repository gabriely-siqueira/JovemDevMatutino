package exercicio_farmacia;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Cliente {
	private String nomeCliente;
	private double saldoDevedor;

	public Cliente(String nomeCliente, double saldoDevedor) {
		this.nomeCliente = nomeCliente;
		this.saldoDevedor = saldoDevedor;

	}
	public double pagarConta(double valorl) {
		if(valorl > 0 && getSaldoDevedor() >= valorl) {
			saldoDevedor = getSaldoDevedor() - valorl;
		}
		return getSaldoDevedor();
	}
	
	public void adicionaValor(double vl) {
		saldoDevedor = getSaldoDevedor() + vl;
	}
}