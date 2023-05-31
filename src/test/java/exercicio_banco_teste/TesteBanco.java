package exercicio_banco_teste;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;

import exercicio_banco.Conta;
import exercicio_banco.Especial;
import exercicio_banco.Universitaria;



public class TesteBanco {
	List<Conta> contas = new ArrayList<Conta>();
	@BeforeEach
	public void init() {
	contas.add(new Conta(1234,5432,"Gabriely", 3000.00));
	contas.add(new Especial(1234,5432,"João", 3000.00, 2000.00));
	contas.add(new Universitaria(1234,5432,"Gabriel", 3000.00, 2000.00));
	
	}

}
