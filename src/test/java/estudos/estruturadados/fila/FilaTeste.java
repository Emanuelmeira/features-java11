package estudos.estruturadados.fila;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Fila é um tipo abistrato de dado.
 */

@RunWith(JUnit4.class)
public class FilaTeste {

    @Test
    public void fila() {

        Fila<String> fila = new Fila();

        fila.adicionar("Ana");
        fila.adicionar("Pedro");
        fila.adicionar("Juca");
        fila.adicionar("Aline");

        System.out.println("Primeiro da lista: " + fila.get());
        System.out.println("Removendo primeiro da lista ......");
        fila.remover();
        System.out.println("Novo primeiro da lista: " + fila.get());

    }


}
