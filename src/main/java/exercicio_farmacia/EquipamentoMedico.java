package exercicio_farmacia;

public class EquipamentoMedico extends Produto {
	int encomenda;
	public EquipamentoMedico(String nome, Integer estoque, Double valor) {
		
		super(nome, estoque, valor);

	}
	@Override
	public boolean venda(Cliente cliente, Integer quantidade) {

		if (estoque > 0) {
			estoque = getEstoque() - quantidade;
			cliente.setSaldoDevedor(cliente.getSaldoDevedor() + getValor() * quantidade);
			return true;
		}else {
			while(estoque == 0) {
				estoque = getEstoque() - 1;
				quantidade -= 1;
				encomenda += quantidade;
				cliente.setSaldoDevedor(cliente.getSaldoDevedor() + getValor() * quantidade);
				
			}
		}
		return false;
	}

}
