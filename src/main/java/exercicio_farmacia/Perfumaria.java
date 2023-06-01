package exercicio_farmacia;

public class Perfumaria extends Produto {
    public Perfumaria(String nome, Integer estoque, Double valor) {
        super(nome, estoque, valor);
    }

    @Override
    public boolean venda(Cliente cliente, Integer quantidade) {
        if (cliente.getSaldoDevedor() < 300 && estoque > 0) {
            estoque = estoque - quantidade;
            cliente.setSaldoDevedor(cliente.getSaldoDevedor() + valor * quantidade);
            return true;
        }
        return false;
    }
}