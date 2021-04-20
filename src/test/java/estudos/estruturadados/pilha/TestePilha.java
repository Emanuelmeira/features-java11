package estudos.estruturadados.pilha;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.LinkedList;

/**
 * Pilha é um tipo abistrato de dado, pois não é necessario a criação de uma nova estrutura de dados, apenas a utilização de estruturas ja existentes
 */
@RunWith(JUnit4.class)
public class TestePilha {


    /**
     * Utilização de metodos push e pop de uma LinkedList do java é a reprsentação de uma pilha
     */
    @Test
    public void pilha() {

        Pilha<String> pilha = new Pilha<>();

        pilha.adicionar("E");
        pilha.adicionar("B");
        pilha.adicionar("C");
        pilha.adicionar("Z");

        System.out.println("Topo: " +pilha.get());

        System.out.println("Removendo do Topo da fila ....");
        pilha.remover();
        System.out.println("Novo elemento no topo: " +pilha.get());

        System.out.println("\n\n\nusando LinkedList");

        //Usando push() e pop()
        var pilhalinkedList = new LinkedList<String>();
        pilhalinkedList.push("E");
        pilhalinkedList.push("B");
        pilhalinkedList.push("C");
        pilhalinkedList.push("Z");

        pilhalinkedList.stream().forEach(System.out::println);
        System.out.println("Removendo da pilha .......");
        pilhalinkedList.pop();
        pilhalinkedList.stream().forEach(System.out::println);
    }

}
