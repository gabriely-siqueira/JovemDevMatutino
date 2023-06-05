package exercicio_farmacia;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Produto {
	private String nome;
	private Integer estoque;
	private double valor;

	public Produto(String nome, Integer estoque, double valor) {
		this.nome = nome;
		this.estoque = estoque;
		this.valor = valor;
	}
	
	 public boolean venda(Venda venda) {
	        if (estoque > 0) {
	            estoque =  getEstoque() - venda.getQuantidade();
	    		venda.getCliente().adicionaValor(venda.getQuantidade()*getValor());
	    		return true;
	        }
	        return false;
	    }
}