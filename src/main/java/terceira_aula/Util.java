package terceira_aula;


import java.util.List;

import javax.swing.JOptionPane;

public class Util {
	
	public static void cadastraTime(List<Time> times) {
		Time t = new Time();
		t.cadastra();
		times.add(t);
	}
	
	public static Time escolheTime(List<Time> times) {
		String menu = "Escolha um time\n";
		int pos = 1;
		for (Time time : times) {
			menu += pos + " - " + time.getNome() + "\n";
			pos ++;
		}
		int op = Integer.parseInt(JOptionPane.showInputDialog(menu));
		return times.get(op-1);
		
	}
	
	public static String listaJogadoresTime(List<Time> times) {
		Time t = escolheTime(times);
		return t.listaJogadores();
	}
	
	public static String artilheiroCampeonato(List<Time> times) {
		Jogador artilheiro = new Jogador();
		for (Time time : times) {
			if (time.getArtilheiro().getGols() > artilheiro.getGols()) {
				artilheiro = time.getArtilheiro();
			}
		}
		
		return "O artilheiro do campeonato é: " + artilheiro.getNome();
	}
	
	public static String timeMaisGols(List<Time> times) {
		Time timeComMaisGols = new Time();
		for (Time time : times) {
			if(time.getGols() > timeComMaisGols.getGols()) {
				timeComMaisGols = time;
			}
		}
		return "O time que fez mais gols no campeonato é: " + timeComMaisGols.getNome();
	}
	
	public static int escolheMenu() {
		String menu = "1 - Cadastrar times\r\n"
				+ "2 - Listar todos jogadores de um time\r\n"
				+ "3 - Verificar artilheiro do campeonato.\r\n"
				+ "4 - Verificar qual time fez mais gols no campeonato\r\n"
				+ "5 - Sair";
		return Integer.parseInt(JOptionPane.showInputDialog(menu));
	}

}