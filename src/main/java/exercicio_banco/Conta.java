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

    public Double deposito(double valor) {
        saldo += valor;
        return saldo;
    }

    public Double saque(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
        }
        return saldo;
    }

    public Double transferencia(Conta destino, double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            destino.deposito(valor);
        }
        return saldo;
    }
}
