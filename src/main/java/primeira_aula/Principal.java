package primeira_aula;

import javax.swing.JOptionPane;

public class Principal extends Pessoa {

	public static void main(String[] args) {
		Pessoa pessoa1 = new Pessoa();
		pessoa1.nome = JOptionPane.showInputDialog("Digite o nome:");
		pessoa1.sexo = JOptionPane.showInputDialog("Digite o sexo:");
		pessoa1.peso = Double.parseDouble(JOptionPane.showInputDialog("Digite o peso:"));
		pessoa1.altura = Double.parseDouble(JOptionPane.showInputDialog("Digite a altura:"));
		double resultadoIMC2 = calculaIMC(IMC, sexo);
		System.out.println("Nome:" + pessoa1.nome + "\nSexo: " + pessoa1.sexo + "\nPeso: " + pessoa1.peso + "\nAltura: "
				+ pessoa1.altura + "\nIMC: " + resultadoIMC2);

	}

	public static double calculaIMC(double peso, double altura) {
		double alturaQuadrado = altura * altura;
		double IMC = peso / alturaQuadrado;
		return IMC;
	}

	public static String imcSexo(double IMC, String sexo) {
		if (sexo == "feminino") {
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
			if (sexo == "masculino") {
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
}