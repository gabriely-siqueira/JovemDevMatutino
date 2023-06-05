package exercicio_farmacia;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class Util {
	
	private List<Venda> vendas = new ArrayList<Venda>();
	
	public void venda(Cliente cliente, Produto produto, int quantidade, String medico) {
		Venda venda = new Venda(cliente, produto, quantidade, medico);
		if(produto.venda(venda)) {
			vendas.add(venda);
		}
	}
	
	public List<Venda> vendasPorCliente(Cliente cliente){
	List<Venda> vendasEncontradas = new ArrayList<>();
		for (Venda venda : vendas) {
			if(venda.isCliente(cliente)) {
				vendasEncontradas.add(venda);
			}
		}
		return vendasEncontradas;
		
		
	}
	
	

}