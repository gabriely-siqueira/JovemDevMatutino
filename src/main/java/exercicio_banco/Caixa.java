package exercicio_banco;

public class Caixa {
    private Conta conta;
    private Double valor;
    private EnumOperacao operacao;

    public Caixa(Conta conta, Double valor, EnumOperacao operacao) {
        this.conta = conta;
        this.valor = valor;
        this.operacao = operacao;
    }

    public void executarOperacao() {
        if (operacao == EnumOperacao.DEPOSITO) {
            conta.deposito(valor);
        } else if (operacao == EnumOperacao.SAQUE) {
            conta.saque(valor);
        } else if (operacao == EnumOperacao.TRANSFERENCIA) {
            
        	Conta destino = conta ;

        	if (conta instanceof Universitaria) {
        	    Universitaria universitaria = (Universitaria) conta;
        	    if (universitaria.getSaldo() >= valor && valor <= universitaria.getLimite()) {
        	        universitaria.transferencia(destino, valor);
        	    }
        	} else {
        	    conta.transferencia(destino, valor);
        	}
    }
}}
