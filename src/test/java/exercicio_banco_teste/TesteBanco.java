package exercicio_banco_teste;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import exercicio_banco.Conta;
import exercicio_banco.Especial;
import exercicio_banco.Universitaria;

import exercicio_banco.Caixa;

import static org.junit.jupiter.api.Assertions.*;

public class TesteBanco {

	private Caixa caixa;

	@BeforeEach
	public void init() {
		caixa = new Caixa();
		caixa.getContas().clear();
		caixa.addConta(new Conta(1, 1, "Gabriely", 10.00));
		caixa.addConta(new Especial(2, 2, "João", 500.00, 3000.00));
		caixa.addConta(new Universitaria(3, 3, "Gabriel", 10.00));
	}

	@Test
	@DisplayName("Transferencia entre Conta Corrente e Conta Universitária possível")
	public void transferencia1() {
		Conta corrente = caixa.getContas().get(0);
		Universitaria universitaria = (Universitaria) caixa.getContas().get(2);
		caixa.transferencia(10, corrente, universitaria);
		assertEquals(0, corrente.getSaldo());
		assertEquals(20, universitaria.getSaldo());
	}

	@Test
	@DisplayName("Transferencia entre Conta Corrente e Conta Universitária impossível")
	public void transferencia2() {
		Conta corrente = caixa.getContas().get(0);
		Universitaria universitaria = (Universitaria) caixa.getContas().get(2);
		caixa.deposito(1990, universitaria);
		assertEquals(2000, universitaria.getSaldo());
		caixa.transferencia(10, corrente, universitaria);
		assertEquals(10, corrente.getSaldo());
		assertEquals(2000, universitaria.getSaldo());
	}

	@Test
	@DisplayName("Deposito em Conta Corrente")
	public void depositoContaCorrente() {
		Conta corrente = caixa.getContas().get(0);
		caixa.deposito(100, corrente);
		assertEquals(110, corrente.getSaldo());
	}

	@Test
	@DisplayName("Deposito em Conta Especial")
	public void depositoContaEspecial() {
		Conta especial = caixa.getContas().get(1);
		caixa.deposito(100, especial);
		assertEquals(600, especial.getSaldo());
	}

	@Test
	@DisplayName("Saque em Conta Corrente")
	public void saqueContaCorrente() {
		Conta corrente = caixa.getContas().get(0);
		caixa.saque(5, corrente);
		assertEquals(5, corrente.getSaldo());
	}

	@Test
	@DisplayName("Saque em Conta Especial")
	public void saqueContaEspecial() {
		Conta especial = caixa.getContas().get(1);
		caixa.saque(100, especial);
		assertEquals(400, especial.getSaldo());
	}

	@Test
	@DisplayName("Limpar Dados")
	public void clearData() {
		caixa.clearData();
		assertEquals(0, caixa.getContas().size());
	}
}
