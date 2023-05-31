package exercicio_escola;

import java.util.ArrayList;
import java.util.List;

public class Util {
    public List<Professor> professores = new ArrayList<>();
    private List<Aluno> alunos = new ArrayList<>();
    private List<Disciplina> disciplinas = new ArrayList<>();

    public Professor addProfessor(Professor professor) {
        professores.add(professor);
        return professor;
    }

    public Aluno addAluno(Aluno aluno) {
        alunos.add(aluno);
        return aluno;
    }

    public Disciplina addDisciplina(Disciplina disciplina) {
        disciplinas.add(disciplina);
        return disciplina;
    }

    public void matricularAluno(Aluno aluno, Disciplina disciplina) {
        if (alunos.contains(aluno) && disciplinas.contains(disciplina)) {
            aluno.addDisciplina(disciplina);
        }
    }

    public void informarNotas(Aluno aluno, Disciplina disciplina, List<Double> notas) {
        if (alunos.contains(aluno) && disciplinas.contains(disciplina)) {
            aluno.informarNotas(disciplina, notas);
        }
    }

    public List<Disciplina> listarDisciplinasComMedia(Aluno aluno) {
        List<Disciplina> disciplinasAluno = new ArrayList<>();
        if (alunos.contains(aluno)) {
            disciplinasAluno = aluno.getDisciplinas();
        }
        return disciplinasAluno;
    }

    public List<Disciplina> listarDisciplinasProfessoresPosGraduacao() {
        List<Disciplina> disciplinasPosGraduacao = new ArrayList<>();
        for (Disciplina disciplina : disciplinas) {
            Professor professor = disciplina.getProfessor();
            if (professor.getFormacao() == EnumFormacao.POS_GRADUACAO) {
                disciplinasPosGraduacao.add(disciplina);
            }
        }
        return disciplinasPosGraduacao;
    }

    public void clearData() {
        professores.clear();
        alunos.clear();
        disciplinas.clear();
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }
}
