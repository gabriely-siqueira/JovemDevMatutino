package exercicio_banco;

import lombok.Getter;

@Getter
public class Especial extends Conta {
    private Double limite;

    public Especial(Integer numero, Integer agencia, String nome, Double saldo, Double limite) {
        super(numero, agencia, nome, saldo);
        this.limite = limite;
    }

    @Override
	public boolean saque(double vl) {
		if(getSaldo() + getLimite() >= vl) {
			saldo = getSaldo() - vl;
			return true;
		}
		return false;
	}

    
}
