package estudos.estruturadados.busca;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.*;

/**
 * https://estevestoni.medium.com/iniciando-com-a-nota%C3%A7%C3%A3o-big-o-be996fa3b47b
 */

@RunWith(JUnit4.class)
public class Busca {

    /**
     * Busca Linear, notação Big o:  o(n) (Função linear)
     * quando o vetor aumenta a quantidade de passos aumenta na mesma proporção
     */
    @Test
    public void buscaLinear() {
        Integer[] vetor = new Integer[10];

        for(int i=0; i<vetor.length; i++)
            vetor[i] = (int) (Math.random() * 10);

        var numeroBuscado = 2;
        var existe = false;

        for (int i=0; i <vetor.length; i++){
            System.out.println(vetor[i]);
            if(vetor[i] == numeroBuscado){
                existe = true;
                break;
            }
        }

        if(existe){
            System.out.println("numero encontrado");
        }else{
            System.out.println("numero não encontrado");
        }
    }

    /**
     * Busca binaria, notação Big o:  o(log n) (Função logarítmica)
     */

    @Test
    public void buscaBinaria() {
        Integer[] vetor = new Integer[1000000];

        for(int i=0; i<vetor.length; i++)
            vetor[i] = i;

        int contador = 0;
        int numBuscado = 999999;
        boolean achou = false;
        int inicio = 0;
        int fim = vetor.length - 1;
        int meio;

        while (inicio <= fim){
            meio = ((inicio+fim) /2);
            contador++;
            if(vetor[meio] == numBuscado){
                achou = true;
                break;
            } else if(vetor[meio] < numBuscado){
                inicio = meio + 1;
            }else{
                fim = meio - 1;
            }
        }

        if(achou){
            System.out.println("Encontrado com: " + contador + " tentativas");
        }else{
            System.out.println("Não encontrado com: " + contador + " tentativas");
        }

    }

    @Test
    public void buscaBinariaComArrayList() {

        ArrayList<Aluno> alunos = new ArrayList<>();

        for(int i=0; i<2000000; i++) {
            var a = (int) (Math.random() * 10);
            alunos.add(new Aluno(a + "Carlos", i));
        }
        var aluno = new Aluno("00000AAAAAAAAA", 10000);


        var tempInicial = System.currentTimeMillis();
        Collections.sort(alunos, Comparator.comparing(Aluno::getNome));
        System.out.println(Collections.binarySearch(alunos, aluno, Comparator.comparing(Aluno::getNome)));
        var tempFinal = System.currentTimeMillis();
        System.out.println("busca binaria " + (tempFinal - tempInicial));

        tempInicial = System.currentTimeMillis();
        for(int i=0; i<2000000; i++) {
            alunos.get(i);
        }
        tempFinal = System.currentTimeMillis();
        System.out.println("busca linear " + (tempFinal - tempInicial));

    }

    public class Aluno{
        private String nome;
        private  int idade;

        public Aluno(String nome, int idade) {
            this.nome = nome;
            this.idade = idade;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public int getIdade() {
            return idade;
        }

        public void setIdade(int idade) {
            this.idade = idade;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Aluno aluno = (Aluno) o;
            return idade == aluno.idade &&
                    Objects.equals(nome, aluno.nome);
        }

        @Override
        public int hashCode() {
            return Objects.hash(nome, idade);
        }
    }


}











