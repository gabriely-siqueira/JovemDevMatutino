package exercicio_farmacia;

import lombok.Getter;
import lombok.Setter;

@Setter

@Getter
public class Produto {
    private String nome;
    protected Integer estoque;
    protected Double valor;

    public Produto(String nome, Integer estoque, Double valor) {
        this.nome = nome;
        this.estoque = estoque;
        this.valor = valor;
    }

    public boolean venda(Cliente cliente, Integer quantidade) {
        if (estoque > 0) {
            estoque = estoque - quantidade;
            cliente.setSaldoDevedor(cliente.getSaldoDevedor() + valor * quantidade);
            return true;
        }
        return false;
    }
}