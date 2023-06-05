package exercicio_farmacia;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Venda {
	
	private Cliente cliente;
	private Produto produto;
	private int quantidade;
	private String medico;
	
	@Override
	public String toString() {
		return cliente.getNomeCliente() + "-" + produto.getNome()+"-"+(produto.getValor() + quantidade);
	}
	
	public boolean isCliente(Cliente cliente) {
		return cliente.getNomeCliente().equalsIgnoreCase(cliente.getNomeCliente());
	}

}