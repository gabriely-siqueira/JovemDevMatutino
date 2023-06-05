package exercicio_farmacia;
import lombok.Getter;

@Getter
public class EquipamentoMedico extends Produto {
	
	public EquipamentoMedico(String nome, Integer estoque, double valor) {
		super(nome, estoque, valor);
	}

}