package exercicio_escola_teste;

import exercicio_escola.Util;
import exercicio_escola.Professor;
import exercicio_escola.Aluno;
import exercicio_escola.Disciplina;
import exercicio_escola.EnumFormacao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UtilTeste {

    private Util util;

    @BeforeEach
    void init() {
        util = new Util();
        util.clearData();
        Professor professor1 = new Professor("Sandro", EnumFormacao.GRADUACAO);
        util.addProfessor(professor1);
        util.addDisciplina(new Disciplina("Português", 40, professor1));

        Professor professor2 = new Professor("Cara", EnumFormacao.GRADUACAO);
        util.addProfessor(professor2);
        util.addDisciplina(new Disciplina("História", 20, professor2));

        Professor professor3 = new Professor("Rogerio", EnumFormacao.GRADUACAO);
        util.addProfessor(professor3);
        util.addDisciplina(new Disciplina("Matemática", 40, professor3));

        Professor professor4 = new Professor("Giovana", EnumFormacao.ESPECIALIZACAO);
        util.addProfessor(professor4);
        util.addDisciplina(new Disciplina("Inglês", 20, professor4));
    }

    @Test
    @DisplayName("Teste addProfessor")
    public void testAddProfessor() {
        Professor professor = new Professor("Cremilsson", EnumFormacao.POS_GRADUACAO);
        util.addProfessor(professor);

        List<Professor> professores = util.getProfessores();
        assertEquals(5, professores.size());
        assertEquals(professor, professores.get(4));
    }

    @Test
    @DisplayName("Teste addAluno")
    public void testAddAluno() {
        Aluno aluno = new Aluno("Gabriely");
        util.addAluno(aluno);

        List<Aluno> alunos = util.getAlunos();
        assertEquals(1, alunos.size());
        assertEquals(aluno, alunos.get(0));
    }

    @Test
    @DisplayName("Teste addDisciplina")
    public void testAddDisciplina() {
        Professor professor = new Professor("Cremilsson", EnumFormacao.ESPECIALIZACAO);
        Disciplina disciplina = new Disciplina("Física", 60, professor);
        util.addDisciplina(disciplina);

        List<Disciplina> disciplinas = util.getDisciplinas();
        assertEquals(5, disciplinas.size());
        assertEquals(disciplina, disciplinas.get(4));
    }

    @Test
    @DisplayName("Teste matricularAluno")
    public void testMatricularAluno() {
        Aluno aluno = new Aluno("Jane Smith");
        Disciplina disciplina = new Disciplina("Física", 60, new Professor("Cremilsson", EnumFormacao.ESPECIALIZACAO));
        util.addAluno(aluno);
        util.addDisciplina(disciplina);

        util.matricularAluno(aluno, disciplina);

        List<Disciplina> disciplinasAluno = aluno.getDisciplinas();
        assertEquals(1, disciplinasAluno.size());
        assertEquals(disciplina, disciplinasAluno.get(0));
    }

    @Test
    @DisplayName("Teste informarNotas")
    public void testInformarNotas() {
        Aluno aluno = new Aluno("Gabriely");
        Disciplina disciplina = new Disciplina("Math", 60, new Professor("Cremilsson", EnumFormacao.ESPECIALIZACAO));
        util.addAluno(aluno);
        util.addDisciplina(disciplina);
        util.matricularAluno(aluno, disciplina);

        List<Double> notas = Arrays.asList(8.5, 9.0, 7.5);
        util.informarNotas(aluno, disciplina, notas);

        List<List<Double>> notasAluno = aluno.getNotas();
        assertEquals(1, notasAluno.size());
        assertEquals(notas, notasAluno.get(0));
    }

    @Test
    @DisplayName("Teste listarDisciplinasComMedia")
    public void testListarDisciplinasComMedia() {
        Aluno aluno = new Aluno("Gabriely");
        Disciplina disciplina1 = new Disciplina("Física", 60, new Professor("Cremilsson", EnumFormacao.ESPECIALIZACAO));
        Disciplina disciplina2 = new Disciplina("Química", 80, new Professor("Alice", EnumFormacao.POS_GRADUACAO));
        util.addAluno(aluno);
        util.addDisciplina(disciplina1);
        util.addDisciplina(disciplina2);
        util.matricularAluno(aluno, disciplina1);
        util.matricularAluno(aluno, disciplina2);

        List<Double> notasDisciplina1 = Arrays.asList(8.5, 9.0, 7.5);
        List<Double> notasDisciplina2 = Arrays.asList(7.0, 8.0, 6.5);
        util.informarNotas(aluno, disciplina1, notasDisciplina1);
        util.informarNotas(aluno, disciplina2, notasDisciplina2);

        List<Disciplina> disciplinasAluno = util.listarDisciplinasComMedia(aluno);
        assertEquals(2, disciplinasAluno.size());
        assertEquals(disciplina1, disciplinasAluno.get(0));
        assertEquals(disciplina2, disciplinasAluno.get(1));
    }

    @Test
    @DisplayName("Teste listarDisciplinasProfessoresPosGraduacao")
    public void testListarDisciplinasProfessoresPosGraduacao() {
        Professor professor1 = new Professor("Cremilsson", EnumFormacao.POS_GRADUACAO);
        Professor professor2 = new Professor("Alice ", EnumFormacao.ESPECIALIZACAO);
        Disciplina disciplina1 = new Disciplina("Física", 60, professor1);
        Disciplina disciplina2 = new Disciplina("Química", 80, professor2);
        Disciplina disciplina3 = new Disciplina("Biologia", 75, professor1);
        util.addProfessor(professor1);
        util.addProfessor(professor2);
        util.addDisciplina(disciplina1);
        util.addDisciplina(disciplina2);
        util.addDisciplina(disciplina3);

        List<Disciplina> disciplinasPosGraduacao = util.listarDisciplinasProfessoresPosGraduacao();
        assertEquals(2, disciplinasPosGraduacao.size());
        assertEquals(disciplina1, disciplinasPosGraduacao.get(0));
        assertEquals(disciplina3, disciplinasPosGraduacao.get(1));
    }
}
