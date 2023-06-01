package exercicio_farmacia;

import lombok.Getter;

@Getter
public class Medicamento extends Produto {
    private boolean retencaoReceita;

    public Medicamento(String nome, Integer estoque, Double valor, boolean retencaoReceita) {
        super(nome, estoque, valor);
        this.retencaoReceita = retencaoReceita;
    }

    public boolean isRetencaoReceita() {
        return retencaoReceita;
    }

    @Override
    public boolean venda(Cliente cliente, Integer quantidade) {
        if (estoque > 0 && !retencaoReceita) {
            estoque = estoque - quantidade;
            cliente.setSaldoDevedor(cliente.getSaldoDevedor() + valor * quantidade);
            return true;
        }
        return false;
    }
}
