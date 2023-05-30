package exercicio_medicamento;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Pessoa {
    private Integer id;
    @NonNull
    private String nome;
    @NonNull
    private String sintoma;
    @NonNull
    private List<String> alergias;
    @NonNull
    private List<Medicamento> medicamentos;
    
}
