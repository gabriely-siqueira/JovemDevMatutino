package quarta_aula;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Livro {
	
	private String titulo;
	private Double preco;
	private List<Autor> autores;
	
	@Override
	public String toString() {
		List<String> nomeAutores = new ArrayList<>();
		for (Autor autor : autores) {
			nomeAutores.add(autor.getNomeAutor());
		}
		return "Título: " + titulo.toLowerCase() + ", Preço: R$" + preco + ", Autores: " + nomeAutores + "";
	}
	
	public String semAutor() {
		return "Título: " + titulo.toLowerCase() + " - Preço: R$" + preco;
	}
	

}
