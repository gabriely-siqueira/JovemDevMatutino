package exercicio_escola;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter

public class Disciplina {
	@NonNull
	private String nome;
	@NonNull
	private Integer cargaHoraria;
	@NonNull
	private Professor professor;

	
}
