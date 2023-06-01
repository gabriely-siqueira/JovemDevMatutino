package exercicio_banco;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class Conta {
	@NonNull
	private Integer numero;
	@NonNull
	private Integer agencia;
	@NonNull
	private String nome;
	@NonNull
	protected Double saldo;

	public Conta(Integer numero, Integer agencia, String nome, Double saldo) {
		this.numero = numero;
		this.agencia = agencia;
		this.nome = nome;
		this.saldo = saldo;
	}

	public boolean deposito(double valor) {
		if (valor > 0) {
			saldo = getSaldo() + valor;
			return true;
		}
		return false;
	}

	public boolean saque(double valor) {
		if (saldo >= valor) {
		saldo = getSaldo() - valor;
		return true;
		}
		return false;
	}

	public boolean transferencia(double vl, Conta destino) {
		if(saque(vl)) {
			if(destino.deposito(vl)) {
				return true;
			}else {
				deposito(vl);
				return false;
			}
		}
		return false;
	}
}
