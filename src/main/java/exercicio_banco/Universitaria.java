package exercicio_banco;

import lombok.Getter;

@Getter
public class Universitaria extends Conta {
    private Double limite;
    private static final double SALDO_MAXIMO = 2000.00;

    public Universitaria(Integer numero, Integer agencia, String nome, Double saldo) {
        super(numero, agencia, nome, saldo);
        
    }
    @Override
	public boolean deposito(double vl) {
		if(getSaldo() + vl <= SALDO_MAXIMO) {
			return super.deposito(vl);
		}
		return false;
	}
   

}
