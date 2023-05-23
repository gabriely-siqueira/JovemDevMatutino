package segunda_aula.exercicio_carro;


import javax.swing.*;
import java.util.ArrayList;

public class PrincipalCarro {
	static ArrayList<Carro> carros = new ArrayList<Carro>();

    public static void main(String[] args) {
        
        while (true) {
            String opcaoStr = JOptionPane.showInputDialog(null,
                    "Selecione uma opção:\n" +
                            "1 - Cadastrar Carro\n" +
                            "2 - Listar carros por período de fabricação\n" +
                            "3 - Listar carros por marca\n" +
                            "4 - Listar carros por cor\n" +
                            "5 - Sair");

            int opcao = Integer.parseInt(opcaoStr);

            switch (opcao) {
                case 1:
                    cadastrarCarro(carros);
                    break;
                case 2:
                    listarCarrosPorPeriodo(carros);
                    break;
                case 3:
                    listarCarrosPorMarca(carros);
                    break;
                case 4:
                    listarCarrosPorCor(carros);
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }

    private static void cadastrarCarro(ArrayList<Carro> carros) {
        String marca = JOptionPane.showInputDialog("Digite a marca do carro:");
        String anoStr = JOptionPane.showInputDialog("Digite o ano do carro:");
        int ano = Integer.parseInt(anoStr);
        Cor[] cores = Cor.values();
        String[] coresStr = new String[cores.length];
        for (int i = 0; i < cores.length; i++) {
            coresStr[i] = cores[i].toString();
        }
        String corSelecionada = (String) JOptionPane.showInputDialog(null,
                "Selecione a cor do carro:",
                "Cor",
                JOptionPane.QUESTION_MESSAGE,
                null,
                coresStr,
                coresStr[0]);

        Cor cor = Cor.valueOf(corSelecionada);

        Carro carro = new Carro(marca, ano, cor);
        carros.add(carro);
        JOptionPane.showMessageDialog(null, "Carro cadastrado com sucesso!");
    }

    private static void listarCarrosPorPeriodo(ArrayList<Carro> carros) {
        String anoInicialStr = JOptionPane.showInputDialog("Digite o ano inicial:");
        int anoInicial = Integer.parseInt(anoInicialStr);
        String anoFinalStr = JOptionPane.showInputDialog("Digite o ano final:");
        int anoFinal = Integer.parseInt(anoFinalStr);

        ArrayList<Carro> carrosFiltrados = new ArrayList<Carro>();
        for (Carro carro : carros) {
            if (carro.getAno() >= anoInicial && carro.getAno() <= anoFinal) {
                carrosFiltrados.add(carro);
            }
        }

        exibirListaCarros(carrosFiltrados);
    }

    private static void listarCarrosPorMarca(ArrayList<Carro> carros) {
        String marca = JOptionPane.showInputDialog("Digite a marca:");

        ArrayList<Carro> carrosFiltrados = new ArrayList<Carro>();
        for (Carro carro : carros) {
            if (carro.getMarca().equals(marca.toUpperCase())) {
                carrosFiltrados.add(carro);
            }
        }

        exibirListaCarros(carrosFiltrados);
    }

    private static void listarCarrosPorCor(ArrayList<Carro> carros) {
        Cor[] cores = Cor.values();
        String[] coresStr = new String[cores.length];
        for (int i = 0; i < cores.length; i++) {
            coresStr[i] = cores[i].toString();
        }
        String corSelecionada = (String) JOptionPane.showInputDialog(null,
                "Selecione a cor:",
                "Cor",
                JOptionPane.QUESTION_MESSAGE,
                null,
                coresStr,
                coresStr[0]);

        Cor cor = Cor.valueOf(corSelecionada);

        ArrayList<Carro> carrosFiltrados = new ArrayList<Carro>();
        for (Carro carro : carros) {
            if (carro.getCor() == cor) {
                carrosFiltrados.add(carro);
            }
        }

        exibirListaCarros(carrosFiltrados);
    }

    private static void exibirListaCarros(ArrayList<Carro> carros) {
        StringBuilder mensagem = new StringBuilder();
        for (Carro carro : carros) {
            mensagem.append(carro.toString()).append("\n");
        }

        double percentual = (double) carros.size() / carros.size() * 100;

        JOptionPane.showMessageDialog(null,
                "Carros listados: \n" + mensagem.toString() +
                        "Percentual: " + percentual + "%");
    }
}



