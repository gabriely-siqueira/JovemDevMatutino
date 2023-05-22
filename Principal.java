package primeira_aula;

import javax.swing.JOptionPane;

public class Principal extends Pessoa {

	public static void main(String[] args) {
		int quantidadePessoas = Integer.parseInt(JOptionPane.showInputDialog("Quantas pessoas deseja cadastrar?"));
		for (int i = 1; i <= quantidadePessoas; i++) {
		Pessoa pessoa1 = new Pessoa();
		pessoa1.nome = JOptionPane.showInputDialog("Digite o nome da pessoa "+ i + ":");
		pessoa1.sexo = JOptionPane.showInputDialog("Digite o sexo da pessoa "+ i + ":");
		pessoa1.peso = Double.parseDouble(JOptionPane.showInputDialog("Digite o peso da pessoa " + i + ":"));
		pessoa1.altura = Double.parseDouble(JOptionPane.showInputDialog("Digite a altura da pessoa "+ i + ":"));
		double resultadoIMC = calculaIMC(peso, altura);
		String avaliacaoIMC = imcSexo(calculaIMC(peso, altura), sexo);
		System.out.printf("Nome:" + pessoa1.nome + "\nSexo: " + pessoa1.sexo + "\nPeso: " + pessoa1.peso + "\nAltura: "
				+ pessoa1.altura + "\nIMC: " + resultadoIMC + "\nAvaliação do IMC: " + avaliacaoIMC);
		}

	}

	public static double calculaIMC(double peso, double altura) {
		double alturaQuadrado = altura * altura;
		double IMC = peso / alturaQuadrado;
		return IMC;
	}

	public static String imcSexo(double IMC, String sexo) {
		if (sexo == "femenino") {
			if (IMC < 19.1) {
				return "Abaixo do normal";
			} else if (IMC >= 19.1 && IMC <= 25.8) {
				return "Peso ideal";
			} else if (IMC >= 25.9 && IMC <= 27.3) {
				return "Pouco acima do peso";
			} else if (IMC >= 27.4 && IMC <= 32.3) {
				return "Acima do peso";
			} else {
				return "Obesidade";
			}
		} else {

			if (IMC < 20.7) {
				return "Abaixo do normal";
			} else if (IMC >= 20.7 && IMC <= 26.4) {
				return "Peso ideal";
			} else if (IMC >= 26.5 && IMC <= 27.8) {
				return "Pouco acima do peso";
			} else if (IMC >= 27.9 && IMC <= 31.1) {
				return "Acima do peso";
			} else {
				return "Obesidade";
			}

		}

	}

}