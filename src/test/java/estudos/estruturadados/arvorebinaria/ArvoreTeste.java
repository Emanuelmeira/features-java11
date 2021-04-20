package estudos.estruturadados.arvorebinaria;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;

@RunWith(JUnit4.class)
public class ArvoreTeste {

    @Test
    public void arvore() {

        //.........4........
        //...2..........6...
        //1.....3....5.....7

        Arvore<Integer> arvore = new Arvore<>();

        arvore.adicionar(4);
        arvore.adicionar(2);
        arvore.adicionar(6);
        arvore.adicionar(1);
        arvore.adicionar(3);
        arvore.adicionar(5);
        arvore.adicionar(7);

        System.out.println("Em ordem - imprime nessa ordem: esquerda, cima, direita");
        arvore.emOrdem(arvore.getRaiz());

        arvore.remover(4);

        System.out.println("\n\nPré-ordem - imprime nessa ordem: cima, esquerda, direita.");
        arvore.preOrdem(arvore.getRaiz());

        System.out.println("\n\nPós-ordem - imprime nessa ordem: esquerda, direita, cima.");
        //arvore.posOrdem(arvore.getRaiz());

    }

}
