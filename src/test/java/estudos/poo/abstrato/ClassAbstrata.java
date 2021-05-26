package estudos.poo.abstrato;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ClassAbstrata {

    @Test
    public void usoDeClassAbstrata(){

        // O principal objetivo da class abstrata é prover atributos e metodos para as subclass.. não podendo ser estanciada ..
        // Caso não tenha atributos .. talvez seja melhor usar interfaces, pos não fica preso a regra de herança multipla

        Professor professor = new Professor();
        professor.setNome("Juca");
        professor.setSalario(15000);

        System.out.println(professor.getSalario());
        System.out.println(professor.getNome());
        professor.andar();
        professor.trabalhar();
    }


    class Professor extends Pessoa{
        private int salario;

        public int getSalario() {
            return salario;
        }

        public void setSalario(int salario) {
            this.salario = salario;
        }

        @Override
        public void trabalhar() { // é obrigatorio implementar o medo abstrato
            System.out.println("Trabalhando..");
        }
    }

    abstract class Pessoa{
        private String nome;

        public abstract void trabalhar(); // posso ter metodos abstract sem corpo para serem implementados pelas subclass

        public void andar(){
            System.out.println("Andando..");
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }
    }



}
