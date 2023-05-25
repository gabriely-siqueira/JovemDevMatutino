package terceira_aula;

import java.util.List;

import javax.swing.JOptionPane;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Principal {
	public static void main(String[] args) {
		// Cadastro de times
		int numTimes = Integer.parseInt(JOptionPane.showInputDialog("Quantos times deseja cadastrar?"));

		Time[] times = new Time[numTimes];
		for (int i = 0; i < numTimes; i++) {
			Time time = new Time();
			time.setNome(JOptionPane.showInputDialog("Digite o nome do time " + (i + 1) + ":"));

			int numJogadores = Integer.parseInt(JOptionPane
					.showInputDialog("Quantos jogadores deseja cadastrar para o time " + time.getNome() + "?"));

			for (int j = 0; j < numJogadores; j++) {
				Jogador jogador = new Jogador();
				jogador.setNome(JOptionPane
						.showInputDialog("Digite o nome do jogador " + (j + 1) + " do time " + time.getNome() + ":"));
				jogador.setNumeroCamisa(Integer.parseInt(JOptionPane.showInputDialog(
						"Digite o número da camisa do jogador " + (j + 1) + " do time " + time.getNome() + ":")));
				jogador.setGolsMarcadosNoCampeonato(Integer
						.parseInt(JOptionPane.showInputDialog("Digite a quantidade de gols marcados pelo jogador "
								+ (j + 1) + " do time " + time.getNome() + ":")));

				time.cadastrarJogador(jogador);
			}

			times[i] = time;
		}

		// Listar jogadores de um time
		int timeSelecionado = Integer.parseInt(
				JOptionPane.showInputDialog("Selecione o time (1-" + numTimes + ") para listar os jogadores:"));
		Time timeEscolhido = times[timeSelecionado - 1];

		List<Jogador> jogadoresDoTime = timeEscolhido.listarJogadores();
		StringBuilder listaJogadores = new StringBuilder("Jogadores do time " + timeEscolhido.getNome() + ":\n");
		for (Jogador jogador : jogadoresDoTime) {
			listaJogadores.append(jogador.getNome()).append(", Camisa ").append(jogador.getNumeroCamisa())
					.append(", Gols: ").append(jogador.getGolsMarcadosNoCampeonato()).append("\n");
		}
		JOptionPane.showMessageDialog(null, listaJogadores.toString());

		Jogador artilheiro = times[0].getArtilheiroDoCampeonato();
		for (int i = 1; i < numTimes; i++) {
			Jogador jogadorAtual = times[i].getArtilheiroDoCampeonato();
			if (jogadorAtual.getGolsMarcadosNoCampeonato() > artilheiro.getGolsMarcadosNoCampeonato()) {
				artilheiro = jogadorAtual;
			}
		}
		JOptionPane.showMessageDialog(null,
				"O artilheiro do campeonato é: " + artilheiro.getNome() + " do time " + timeEscolhido.getNome());

		Time timeMaisGols = times[0];
		int maxGols = timeMaisGols.getTotalDeGols();
		for (int i = 1; i < numTimes; i++) {
			int golsAtual = times[i].getTotalDeGols();
			if (golsAtual > maxGols) {
				timeMaisGols = times[i];
				maxGols = golsAtual;
			}
		}
		JOptionPane.showMessageDialog(null, "O time que fez mais gols no campeonato é: " + timeMaisGols.getNome());
	}
}
