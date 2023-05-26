package quarta_aula;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {

		int opcao;
		do {
			opcao = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma opção:\n" + "1 - Cadastrar Autor\n"
					+ "2 - Cadastrar Livro\n" + "3 - Listar todos os livros cadastrados\n" + "4 - Pesquisar por autor\n"
					+ "5 - Pesquisar por faixa de valor do livro\n"
					+ "6 - Listar todos os livros cujos autores sejam crianças\n"
					+ "7 - Listar todos os livros escritos apenas por homens ou mulheres\n" + "0 - Sair"));

			switch (opcao) {
			case 1:
				Util.cadastrarAutor(Util.autores);
				break;
			case 2:
				Util.cadastrarLivro(Util.livros);
				break;
			case 3:
				Util.listarLivros();
				break;
			case 4:
				Util.pesquisarPorAutor();
				break;
			case 5:
				Util.pesquisarPorFaixaDeValor();
				break;
			case 6:
				Util.listarLivrosAutoresCrianças();
				break;
			case 7:
				Util.listarLivrosPorSexo();
				break;
			case 0:
				JOptionPane.showMessageDialog(null, "Saindo do programa.");
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção inválida.");
				break;
			}
		} while (opcao != 0);

	}

}
