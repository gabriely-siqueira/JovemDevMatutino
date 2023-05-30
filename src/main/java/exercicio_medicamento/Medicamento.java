package exercicio_medicamento;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Medicamento {
    private Integer id;
    @NonNull 
    private String nome;
    @NonNull
    private EnumAdm administracao;
    @NonNull
    private List<String> alergias;
    @NonNull
    private List<String> indicacoes;
}
