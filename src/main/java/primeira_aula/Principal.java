package primeira_aula;

import javax.swing.JOptionPane;

public class Principal extends Pessoa {

	public static void main(String[] args) {
		Pessoa pessoa1 = new Pessoa();
		pessoa1.nome = JOptionPane.showInputDialog("Digite o nome:");
		pessoa1.sexo = JOptionPane.showInputDialog("Digite o sexo:");
		pessoa1.peso = Double.parseDouble(JOptionPane.showInputDialog("Digite o peso:"));
		pessoa1.altura = Double.parseDouble(JOptionPane.showInputDialog("Digite a altura:"));
		double resultadoIMC = calculaIMC(peso, altura);
		System.out.println("Nome:" + pessoa1.nome + "\nSexo: " + pessoa1.sexo + "\nPeso: " + pessoa1.peso + "\nAltura: "
				+ pessoa1.altura + "\nIMC: " + resultadoIMC);

	}

	public static double calculaIMC(double peso, double altura) {
		double alturaQuadrado = altura * altura;
		double IMC = peso / alturaQuadrado;
		return IMC;
	}

}