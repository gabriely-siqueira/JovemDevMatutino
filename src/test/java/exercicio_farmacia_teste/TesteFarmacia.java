package exercicio_farmacia_teste;



import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import exercicio_farmacia.Cliente;
import exercicio_farmacia.Util;
import exercicio_farmacia.Venda;
import exercicio_farmacia.Perfumaria;
import exercicio_farmacia.Medicamento;
import exercicio_farmacia.EquipamentoMedico;

public class TesteFarmacia {
	
	private Util util = new Util();
	private Cliente cliente = null;
	private Medicamento medicamento1 = null;
	private Medicamento medicamento2 = null;
	private Perfumaria perfumequipamentoMedico1 = null; 
	private EquipamentoMedico equipamentoMedico1 = null; 
	
	@BeforeEach
	public void init() {
		util.getVendas().clear();
		cliente = new Cliente("Cliente", 0);
		medicamento1 = new Medicamento("Medicamento1", 10, 10, false);
		medicamento2 = new Medicamento("Medicamento1", 10, 10, true);
		perfumequipamentoMedico1 = new Perfumaria("PerfumequipamentoMedico1", 10, 10);
		equipamentoMedico1 = new EquipamentoMedico("equipamentoMedico1", 0, 10);
	}

	@Test
	@DisplayName("Venda de medicamento com receita sem informar o médico")
	void testvendaMedicamentoComReceitaSemMedico() {
		util.venda(cliente, medicamento2, 3, null);
		assertEquals(0, cliente.getSaldoDevedor());
		assertEquals(10, medicamento2.getEstoque());
	}

	@Test
	@DisplayName("Venda de medicamento com receita informando o médico")
	void testvendaMedicamentoComReceitaComMedico() {
		util.venda(cliente, medicamento2, 3, "Médico");
		assertEquals(30, cliente.getSaldoDevedor());
		assertEquals(7, medicamento2.getEstoque());
	}
	
	@Test
	@DisplayName("Venda de medicamento com quantidade acima do estoque")
	void testvendaMedicamentoSemEstoque() {
		util.venda(cliente, medicamento1, 20, null);
		assertEquals(0, cliente.getSaldoDevedor());
		assertEquals(10, medicamento1.getEstoque());
	}
	
	@Test
	@DisplayName("Venda de perfumaria para cliente com dívida maior que 300,00")
	void testvendaPerfumariaComDivida() {
		cliente.adicionaValor(350);
		util.venda(cliente, perfumequipamentoMedico1, 1, null);
		assertEquals(350, cliente.getSaldoDevedor());
		assertEquals(10, perfumequipamentoMedico1.getEstoque());
	}
	
	@Test
	@DisplayName("Venda de Equipamento médico sem estoque")
	void testvendaEquipamentoMedico() {
		util.venda(cliente, equipamentoMedico1, 1, null);
		assertEquals(10, cliente.getSaldoDevedor());
		assertEquals(-1, equipamentoMedico1.getEstoque());
	}
	
	@Test
	@DisplayName("Listar Vendas de um cliente")
	void testVListarVendasCliente() {
		util.venda(cliente, medicamento1, 1, null);
		util.venda(cliente, medicamento2, 1, null);
		util.venda(cliente, perfumequipamentoMedico1, 50, null);
		util.venda(cliente, equipamentoMedico1, 1, null);
		List<Venda> vendas = util.vendasPorCliente(cliente);
		assertEquals(1, vendas.size());
		assertEquals(20, cliente.getSaldoDevedor());
	}

}