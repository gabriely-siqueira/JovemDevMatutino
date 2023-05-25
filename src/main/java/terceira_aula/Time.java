package terceira_aula;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Data
public class Time {
    private String nome;
    private List<Jogador> jogadores;

    public Time() {
        jogadores = new ArrayList<Jogador>();
    }

    public void cadastrarJogador(Jogador jogador) {
        jogadores.add(jogador);
    }

    public List<Jogador> listarJogadores() {
        return jogadores;
    }

    public Jogador getArtilheiroDoCampeonato() {
        Jogador artilheiro = null;
        int maxGols = 0;

        for (Jogador jogador : jogadores) {
            if (jogador.getGolsMarcadosNoCampeonato() > maxGols) {
                maxGols = jogador.getGolsMarcadosNoCampeonato();
                artilheiro = jogador;
            }
        }

        return artilheiro;
    }

    public int getTotalDeGols() {
        int totalGols = 0;
        for (Jogador jogador : jogadores) {
            totalGols += jogador.getGolsMarcadosNoCampeonato();
        }
        return totalGols;
    }
}