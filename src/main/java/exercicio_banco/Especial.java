package exercicio_banco;

public class Especial extends Conta {
    private Double limite;

    public Especial(Integer numero, Integer agencia, String nome, Double saldo, Double limite) {
        super(numero, agencia, nome, saldo);
        this.limite = limite;
    }

    @Override
    public Double saque(double valor) {
        if (saldo + limite >= valor) {
            saldo -= valor;
        }
        return saldo;
    }

    @Override
    public Double transferencia(Conta destino, double valor) {
        if (saldo + limite >= valor) {
            saldo -= valor;
            destino.deposito(valor);
        }
        return saldo;
    }
}
