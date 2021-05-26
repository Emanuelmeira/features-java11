package estudos.poo.basico;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * https://youtu.be/6FJ5usl7uTw
 */
@RunWith(JUnit4.class)
public class AssociacaoComClass {

    @Test
    public void teste() {
        //TEM-UM: associação
        //É-UM: herança (generalização)
        //Multiplicidade: quantidade de objetos de um lado que se associam com objetos do outro lado
        //1 | 0..1 | 0..* | * | 1..*
        //Ex: 0..1 -> minimo 0, maximo 1

        //Aluno tem uma (TEM-UM) turma
        //Professor tem uma (TEM-UM) turma
        //Turma tem uma (TEM-UM) disciplina
        //Professor tem uma (TEM-UM) dsciplina
        //Aluno é uma (É-UM) pessoa
        //Professor é uma (É-UM) pessoa

        //Multiplicidade:
        //ALUNO: tem 1 turma
        //TURMA: tem 1..* alunos | 1..* professores
        //PROFESSOR: tem 1..* disciplinas | 1..* turmas
        //DISCIPLINA: tem 1..* professores

        //Aluno e Turma: relação N:1
        //Professor e Turma: relação N:N
        //Disciplina e turma: relação N:N

        //obs: para determinar a relação, sempre olhar para o "maximo" da relação para determinar o termo usado
        //Ex: Aluno 1..* Turmas e Turma 1 Aluno -> relação N:1
        //Ex: Professor 1..* Turmas
        //Turma 1..* Professor -> relação N:N

    }

    class Pessoa {
        String nome;
        String matriula;
    }

    class Professor extends Pessoa{
        String formacao;
        double salario;
        ArrayList<Disciplina> disciplinas;
        ArrayList<Turma> turmas;
        ArrayList<Professor> professores;
    }

    class Aluno extends Pessoa{
        LocalDate dataNascimento;
        Turma turma;
    }

    class Turma{
        String sigla;
        ArrayList<Aluno> alunos;
        ArrayList<Disciplina> disciplinas;
    }

    class Disciplina{
        String nome;
        int cargaHoraria;
        ArrayList<Professor> professores;
        ArrayList<Turma> turmas;
    }

}
