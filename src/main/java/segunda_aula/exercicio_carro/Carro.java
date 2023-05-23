package segunda_aula.exercicio_carro;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Carro {
	private String marca;
	private int ano;
	private Cor cor;

	public Carro(String marca, int ano, Cor cor) {
		this.marca = marca;
		this.ano = ano;
		this.cor = cor;
	}

	public String getMarca() {
		return marca;
	}

	public int getAno() {
		return ano;
	}

	public Cor getCor() {
		return cor;
	}
	 @Override
	    public String toString() {
	        return "Marca: " + marca + ", Ano: " + ano + ", Cor: " + cor;
	    }

	private static void cadastrarCarro(ArrayList<Carro> carros) {
		String marca = JOptionPane.showInputDialog("Digite a marca do carro:");
		String anoStr = JOptionPane.showInputDialog("Digite o ano do carro:");
		int ano = Integer.parseInt(anoStr);
		Cor[] cores = Cor.values();
		String[] coresStr = new String[cores.length];
		for (int i = 0; i < cores.length; i++) {
			coresStr[i] = cores[i].toString();
		}
		String corSelecionada = (String) JOptionPane.showInputDialog(null, "Selecione a cor do carro:", "Cor",
				JOptionPane.QUESTION_MESSAGE, null, coresStr, coresStr[0]);

		Cor cor = Cor.valueOf(corSelecionada);

		Carro carro = new Carro(marca, ano, cor);
		carros.add(carro);
		JOptionPane.showMessageDialog(null, "Carro cadastrado com sucesso!");
	}
	

}
