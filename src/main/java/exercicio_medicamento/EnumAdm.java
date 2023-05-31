package exercicio_medicamento;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter

public enum EnumAdm {

	ORAL("Oral"), INJETAVEL("Injetável"), TOPICO("Tópico"), SUPOSITORIO("Supositório");

	private String descricao;

}
