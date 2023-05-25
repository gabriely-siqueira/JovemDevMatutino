package terceira_aula;

import javax.swing.JOptionPane;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter

@Data
public class Jogador {
    private String nome;
    private int camisaJogador ;
    private int gols;

public void cadastra() {
	nome = JOptionPane.showInputDialog("Nome do jogador:");
	camisaJogador  = Integer.parseInt(JOptionPane.showInputDialog("Numero da camisa do jogador"));
	gols = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de gols marcados no campeonato:"));
	
}

@Override
public String toString() {
	return nome + "-" + camisaJogador  + "-" + gols + "\n";
}

}