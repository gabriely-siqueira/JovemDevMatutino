package quarta_aula;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Autor {
	
	private String nomeAutor;
	private String sexo;
	private int idade;
	
	
	
	@Override
	public String toString() {
		return "Nome: " + nomeAutor + ", " + "Sexo: " + sexo + ", " + "Idade: " + idade;
	}

}
