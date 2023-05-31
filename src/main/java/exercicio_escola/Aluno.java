package exercicio_escola;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Aluno {
    private String nome;
    private List<Disciplina> disciplinas;
    private List<List<Double>> notas;

    public Aluno(String nome) {
        this.nome = nome;
        this.disciplinas = new ArrayList<>();
        this.notas = new ArrayList<>();
    }

    public void addDisciplina(Disciplina disciplina) {
        disciplinas.add(disciplina);
        notas.add(new ArrayList<>());
    }

    public void informarNotas(Disciplina disciplina, List<Double> notas) {
        int index = disciplinas.indexOf(disciplina);
        if (index != -1) {
            this.notas.set(index, new ArrayList<>(notas));
        }
    }
}
