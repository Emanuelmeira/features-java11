package estudos.estruturadados.ordenation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;

@RunWith(JUnit4.class)
public class Ordenation {

    /**
     * Bubble sort, notação Big O: o(n²) (Função quadrática)
     */
    @Test
    public void bubbleSort(){
        Integer[] numeros = new Integer[10];

        for (int i=0; i< numeros.length; i++){
            numeros[i] = (int) (Math.random() * 10);
            System.out.println("" + numeros[i]);
        }
        System.out.println("----------------------------");

        int aux;
        for(int i=0; i<numeros.length; i++){
            for (int j=i+1; j<numeros.length; j++){
                if(numeros[i] > numeros[j]){
                    aux = numeros[i];
                    numeros[i] = numeros[j];
                    numeros[j] = aux;
                }
            }
        }

        Arrays.stream(numeros).forEach(System.out::println);
    }

    /**
     * Insertion sort, notação Big O: o(n²) (Função quadrática)
     */
    @Test
    public void insertionSort(){

        Integer[] numeros = new Integer[5];

        for (int i=0; i< numeros.length; i++){
            numeros[i] = (int) (Math.random() * 10);
            System.out.println("" + numeros[i]);
        }
        System.out.println("\n----------------------------");

        int aux, j;
        for(int i=1; i<numeros.length; i++){
            aux = numeros[i];
            j = i-1;
            while (j >= 0 && numeros[j] > aux){
                numeros[j+1] = numeros[j];
                j--;
            }
            numeros[j+1] = aux;
        }

        Arrays.stream(numeros).forEach(System.out::println);
    }

    /**
     * Selection sort, notação Big O: o(n²) (Função quadrática), porem mais rapido que os demais, devido a realização de menor quantidade de trocas dentro do vetor
     */
    @Test
    public void selectSort(){
        Integer[] numeros = new Integer[5];

        for (int i=0; i< numeros.length; i++){
            numeros[i] = (int) (Math.random() * 10);
            System.out.println("" + numeros[i]);
        }
        System.out.println("\n\n ----------------------------");

        int menor_posicao, aux;
        for(int i = 0; i<numeros.length; i++){
            menor_posicao = i;
            for (int j = i+1; j<numeros.length; j++){
                if(numeros[j] < numeros[menor_posicao]){
                    menor_posicao = j;
                }
            }
            aux = numeros[menor_posicao];
            numeros[menor_posicao] = numeros[i];
            numeros[i] = aux;
        }

        Arrays.stream(numeros).forEach(System.out::println);
    }

    /**
     * Heap sort. Notação big O: O(n log n)
     * obs: existe outras implementações para esse algoritmo
     */
    @Test
    public void heapSort(){

        Integer[] numeros = {4,10,  20,5,50, 70, 1, 130, 15};

        //Construir arvore binaria (heap)
        int tamanhoVetor = numeros.length;
        for (int i = tamanhoVetor/2-1; i>=0; i--){
            System.out.println(numeros[i]);
            maxHeapify(numeros, tamanhoVetor, i);
        }

        System.out.println("Arvore Heap-----------------");

        for(int i=0; i<numeros.length/2; i++){

            int raiz = i, noEsquerdo = 2*i +1, noDireito = 2*i +2;

            System.out.println("pai: " + numeros[i]);

            if(noEsquerdo < numeros.length) {
                System.out.println("no Esquerdo: " + numeros[noEsquerdo]);
            }
            if(noDireito < numeros.length) {
                System.out.println("no direito: " + numeros[noDireito]);
            }
        }

        //Aplica o max Heap. Trocar posição dos pais para final do vetor ?
        for (int j = tamanhoVetor-1; j>0; j--){
            int aux = numeros[0];
            numeros[0] = numeros[j];
            numeros[j] = aux;

            maxHeapify(numeros, j, 0);
        }

        System.out.println("\n\n Ordenado-----------------");
        Arrays.stream(numeros).forEach(System.out::println);
    }

    private void maxHeapify(Integer[] numeros, int tamanhoVetor, int pai) {
        int raiz = pai;
        int noEsquerdo = 2 * pai + 1;
        int noDireito = 2 * pai + 2;

        if (noEsquerdo < tamanhoVetor && numeros[noEsquerdo] > numeros[raiz]){
            raiz = noEsquerdo;
        }

        if (noDireito < tamanhoVetor && numeros[noDireito] > numeros[raiz]){
            raiz = noDireito;
        }

        if(raiz != pai){
            int aux = numeros[pai];
            numeros[pai] = numeros[raiz];
            numeros[raiz] = aux;

            maxHeapify(numeros, tamanhoVetor, raiz);
        }
    }

    private void minHeapify(Integer[] numeros, int tamanhoVetor, int pai) {
        int raiz = pai;
        int noEsquerdo = 2*pai +1;
        int noDireito = 2*pai +2;

        //'noEsquerdo < tamanhoVetor' para garantir que não estore o tamanho do vetor
        if (noEsquerdo < tamanhoVetor && numeros[noEsquerdo] < numeros[raiz]){
            raiz = noEsquerdo;
        }

        if (noDireito < tamanhoVetor && numeros[noDireito] < numeros[raiz]){
            raiz = noDireito;
        }

        if(raiz != pai){
            int aux = numeros[pai];
            numeros[pai] = numeros[raiz];
            numeros[raiz] = aux;

            minHeapify(numeros, tamanhoVetor, raiz);
        }
    }

    /**
     * Quick Sort , no pior caso O:(n²), no caso medio O:(n log n)
     *
     */
    @Test
    public void quickSort(){

        Integer[] numeros = {30,20, 9, 1, 5, 4, 3, 2};

        quickSort(numeros, 0, numeros.length-1);
        System.out.println("\n\n Ordenado-----------------");
        Arrays.stream(numeros).forEach(System.out::println);

    }

    private void quickSort(Integer[] vetor, int esquerda, int direita){
        if(esquerda < direita){
            int p = particao(vetor, esquerda, direita);
            quickSort(vetor, esquerda, p);
            quickSort(vetor, p+1, direita);
        }
    }

    private int particao(Integer[] vetor, int esquerda, int direita){
        int meio = (esquerda + direita) /2;
        int pivo = vetor[meio];
        int i = esquerda - 1;
        int j = direita + 1;

        while (true){
            do {
                i++;
            }while (vetor[i] < pivo);
            do {
                j--;
            }while(vetor[j] > pivo);

            if (i >= j){
                return j;
            }

            int aux = vetor[i];
            vetor[i] = vetor[j];
            vetor[j] = aux;
        }


    }

}
