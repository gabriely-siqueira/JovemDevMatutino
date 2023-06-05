package exercicio_farmacia;

import lombok.Getter;

@Getter
public class Perfumaria extends Produto {
	
	public Perfumaria(String nome, int estoque, double valor) {
		super(nome, estoque, valor);
	}
	
	@Override
	public boolean venda(Venda venda) {
		if(getEstoque() >= venda.getQuantidade() && venda.getCliente().getSaldoDevedor() < 300) {
			return super.venda(venda);
		}
		return false;
	}

}