package quarta_aula;

import java.util.ArrayList;

import java.util.List;

import javax.swing.JOptionPane;

public class Util {

	public static List<Autor> autores = new ArrayList<>();
	public static List<Livro> livros = new ArrayList<>();

	public static void cadastrarAutor(List<Autor> autores) {
		Autor autor = new Autor();
		String nome = JOptionPane.showInputDialog("Digite o nome do(a) autor: ");
		while (nome.trim().split("\\s+").length != 2) {
		    nome = JOptionPane.showInputDialog("Digite apenas o nome e sobrenome do(a) autor: ");
		}
		String sexo = JOptionPane.showInputDialog("Digite o sexo do(a) autor(a):");

		while (!(sexo.equalsIgnoreCase("masculino") || sexo.equalsIgnoreCase("feminino"))) {
			sexo = JOptionPane.showInputDialog("Digite o sexo do(a) autor(a):");
		}

		Integer idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade do autor: "));

		while (idade <= 0) {
			idade = Integer.parseInt(JOptionPane
					.showInputDialog("A idade precisa ser maior que zero!\nDigite a idade do autor novamenter: "));
		}

		autor.setNomeAutor(nome);
		autor.setSexo(sexo);
		autor.setIdade(idade);
		autores.add(autor);
	}
		
	public static void cadastrarLivro(List<Livro> livros) {
		Livro livro = new Livro();
		String titulo = JOptionPane.showInputDialog("Digite o titulo do livro: ");
		Double preco = Double.parseDouble(JOptionPane.showInputDialog("Digite o preço do livro: "));

		while (preco <= 0) {
			preco = Double.parseDouble(JOptionPane
					.showInputDialog("O preço precisa ser maior que zero!\nDigite o preço do livro novamente: "));
		}

		Integer autoresQuantidade = Integer
				.parseInt(JOptionPane.showInputDialog("Digite a quantidade de autores (1 a 4):"));
		livro.setTitulo(titulo);
		livro.setPreco(preco);

		while (!(autoresQuantidade >= 1 && autoresQuantidade <= 4)) {
			autoresQuantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de autores (1 a 4):"));
		}

		List<Autor> autores = new ArrayList<>();
		for (int i = 0; i < autoresQuantidade; i++) {
			Integer id = Integer.parseInt(JOptionPane
					.showInputDialog("Autores cadastrados: \n" + stringAutores() + "\n" + "Digite o id do autor:")) - 1;
			autores.add(Util.autores.get(id));
		}
		livro.setAutores(autores);
		livros.add(livro);
	}

	public static String stringAutores() {
		String str = "";
		for (int i = 0; i < autores.size(); i++) {
			str += (i + 1) + " | " + autores.get(i) + "\n";
		}
		return str;
	}

	public static String listarLivros() {
		String str = "";
		for (int i = 0; i < livros.size(); i++) {
			str += (i + 1) + " | " + livros.get(i) + "\n";
		}

		String strLivros = "";
		for (Livro livro : livros) {
			strLivros += livro.toString() + "\n";
		}

		JOptionPane.showMessageDialog(null, strLivros);
		return str;
	}

	public static String pesquisarPorAutor() {
		String str = "Autores cadastrados: \n";
		str += stringAutores() + "\n" + "Digite o id do autor:";

		Integer id = Integer.parseInt(JOptionPane.showInputDialog(str)) - 1;
		listarLivrosDoAutor(autores.get(id));

		return str;
	}

	public static String stringLivrosDoAutor(Autor autor) {
		List<Livro> livros = new ArrayList<>();
		for (int i = 0; i < Util.livros.size(); i++) {
			if (Util.livros.get(i).getAutores().contains(autor)) {
				livros.add(Util.livros.get(i));
			}
		}

		String strLivros = "";
		for (Livro livro : livros) {
			strLivros += livro.semAutor() + "\n";
		}

		return strLivros;
	}

	public static List<Livro> listarLivrosDoAutor(Autor autor) {
		JOptionPane.showMessageDialog(null, "Livros desse autor:\n" + stringLivrosDoAutor(autor));
		return livros;
	}

	public static List<Livro> pesquisarPorFaixaDeValor() {
		List<Livro> livrosPeloValor = new ArrayList<>();
		Double valorMinimo = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor mínimo da busca:"));
		Double valorMaximo = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor máximo da busca:"));
		for (Livro livro : livros) {
			if (livro.getPreco() >= valorMinimo && livro.getPreco() <= valorMaximo) {
				livrosPeloValor.add(livro);
			}
		}
		String strLivros = "";
		for (Livro livro : livrosPeloValor) {
			strLivros += livro + "\n";
		}
		JOptionPane.showMessageDialog(null, strLivros);

		return livrosPeloValor;
	}

	public static List<Livro> listarLivrosAutoresCrianças() {
		List<Livro> livrosPeloIdade = new ArrayList<>();
		List<Autor> autoresCrianca = new ArrayList<>();
		for (Autor autor : autores) {
			if (autor.getIdade() <= 12) {
				autoresCrianca.add(autor);
			}
		}
		String strCrianca = "Autores com menos de 12 anos\n\n";
		for (Autor autor : autoresCrianca) {
			strCrianca += "Nome do autor: " + autor.getNomeAutor() + " - Livros:\n" + stringLivrosDoAutor(autor) + "\n";
		}
		JOptionPane.showMessageDialog(null, strCrianca);
		return livrosPeloIdade;
	}

	public static List<Livro> listarLivrosPorSexo() {
		List<Livro> livrosPeloSexo = new ArrayList<>();
		List<Autor> autoresSexo = new ArrayList<>();
		String sexo = JOptionPane.showInputDialog("Digite o sexo do(a) autor(a) (masculino ou feminino):");

		while (!(sexo.equalsIgnoreCase("masculino") || sexo.equalsIgnoreCase("feminino"))) {
			sexo = JOptionPane.showInputDialog("Digite o sexo do(a) autor(a):");
		}

		for (Autor autor : autores) {
			if (autor.getSexo().equalsIgnoreCase(sexo)) {
				autoresSexo.add(autor);
			}
		}
		String strSexo = "Autores do sexo " + sexo.toLowerCase() + "\n\n";
		for (Autor autor : autoresSexo) {
			strSexo += "Nome do autor: " + autor.getNomeAutor() + " - Livros:\n" + stringLivrosDoAutor(autor) + "\n";
		}
		JOptionPane.showMessageDialog(null, strSexo);
		return livrosPeloSexo;
	}

}
