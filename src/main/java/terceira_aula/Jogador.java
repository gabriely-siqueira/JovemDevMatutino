package terceira_aula;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter

@Data
public class Jogador {
    private String nome;
    private int numeroCamisa;
    private int golsMarcadosNoCampeonato;
}