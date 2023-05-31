package exercicio_banco;

import lombok.Getter;

@Getter

public class Universitaria extends Conta {
    private Double limite;

    public Universitaria(Integer numero, Integer agencia, String nome, Double saldo, Double limite) {
        super(numero, agencia, nome, saldo);
        this.limite = limite;
    }

    @Override
    public Double saque(double valor) {
        if (saldo >= valor && valor <= limite) {
            saldo -= valor;
        }
        return saldo;
    }

    @Override
    public Double transferencia(Conta destino, double valor) {
        if (saldo >= valor && valor <= limite) {
            saldo -= valor;
            destino.deposito(valor);
        }
        return saldo;
    }
}
