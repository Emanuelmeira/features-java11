package estudos.estruturadados.recursividade;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class Recursividade {

    @Test
    public void buscaLinear() {
        Integer[] numeros = new Integer[5];

        for (int i=0; i< numeros.length; i++){
            numeros[i] = (int) (Math.random() * 10);
        }

        System.out.println(somar(0, 0, numeros));
    }

    private int somar(int soma, int posicao, Integer[] vetor){

        if(posicao < vetor.length){
            soma = soma + vetor[posicao];
            return somar(soma, posicao+1, vetor);
        }else {
            return soma;
        }

    }



}
