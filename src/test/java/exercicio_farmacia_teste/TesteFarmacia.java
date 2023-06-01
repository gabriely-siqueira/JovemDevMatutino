package exercicio_farmacia_teste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import exercicio_farmacia.Cliente;
import exercicio_farmacia.EquipamentoMedico;
import exercicio_farmacia.Medicamento;
import exercicio_farmacia.Produto;
import exercicio_farmacia.Perfumaria;
import exercicio_farmacia.Util;

public class TesteFarmacia {

	private Util util = new Util();

	@BeforeEach
	void setUp() {

		Perfumaria perfume1 = new Perfumaria("Perfume 1", 40, 30.0);
		Medicamento medicamento1 = new Medicamento("Medicamento 2", 40, 20.0, true);

		EquipamentoMedico equipamento1 = new EquipamentoMedico("Equipamento 1", 5, 10.0);

		util.getProdutos().add(medicamento1);

		util.getProdutos().add(perfume1);
		util.getProdutos().add(equipamento1);

		Cliente cliente1 = new Cliente("Gabriely", 100.0);
		util.addCliente(cliente1);
		Cliente cliente2 = new Cliente("Jorge", 150.0);
		util.addCliente(cliente2);
	}

	@Test
	@DisplayName("Teste addCliente")
	void addCliente() {
		Cliente cliente3 = new Cliente("Paulo",100.00);
		util.addCliente(cliente3);
		assertEquals(3, util.getClientes().size());
	}

	@Test
	@DisplayName("Teste addProdutos")
	void AddProduto() {
		Perfumaria perfume2 = new Perfumaria("Perfume 2", 20, 50.0);
		util.addProduto(perfume2);
		assertEquals(4, util.getProdutos().size());
	}
	
}
