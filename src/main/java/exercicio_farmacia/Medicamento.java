package exercicio_farmacia;

import lombok.Getter;

@Getter
public class Medicamento extends Produto {

	private boolean isReceita;

	public Medicamento(String nome, int estoque, double valor, boolean isReceita) {
		super(nome, estoque, valor);
		this.isReceita = isReceita;
	}

	@Override
	public boolean venda(Venda venda) {
		if(isReceita && venda.getMedico()==null) {
			return false;
		}else {
			if (getEstoque() >= venda.getQuantidade()) {
				return super.venda(venda);
			}
			return false;
		}
	}

}