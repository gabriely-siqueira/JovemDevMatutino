package exercicio_banco;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Caixa {
    private Conta conta;
    private Conta contaDestino;
    private Double valor;

    private List<Conta> contas = new ArrayList<>();

    public Caixa(Conta conta, Conta contaDestino, Double valor) {
        this.conta = conta;
        this.contaDestino = contaDestino;
        this.valor = valor;
    }

    public Caixa() {
		
	}

	public void addContaEspecial(Especial conta) {
        contas.add(conta);
    }

    public void addContaUniversitaria(Universitaria conta) {
        contas.add(conta);
    }

    public void addConta(Conta c) {
        contas.add(c);
    }

    public boolean deposito(double valor, Conta c) {
        return c.deposito(valor);
    }

    public boolean saque(double valor, Conta c) {
        return c.saque(valor);
    }

    public boolean transferencia(double valor, Conta origem, Conta destino) {
        return origem.transferencia(valor, destino);
    }

    public void clearData() {
        contas.clear();
    }
}
