package estudos.estruturadados.lista;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import solid.s.acoplamento.antigo.Fatura;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

@RunWith(JUnit4.class)
public class ListaTeste {

    @Test
    public void vetorInt() {
        int[] vetor = new int[10]; // de 0 a 9 posições

        Fatura[] vetorDeClasses = new Fatura[10]; // um vetor de classes
        //existe um vetor sem tamanho definido ?

        vetor[3] = 4;
        vetor[2] = 7;
        vetor[5] = 10;
        vetor[7] = 56;

        System.out.println("-------------- vetor de int ---------- ");
        for(int i=0; i<vetor.length; i++){
            System.out.println(vetor[i]);
        }


    }

    @Test
    public void vetorString() {
        String[] estados = new String[10]; // de 0 a 9 posições
        //existe um vetor sem tamanho definido ?

        estados[3] = "SP";
        estados[2] = "AC";
        estados[5] = "CE";
        estados[7] = "PR";
        estados[9] = "BA";

        System.out.println("-------------- vetor de String ---------- ");
        for(int i=0; i<estados.length; i++){
            System.out.println("Estado: " + estados[i] +" - " + "Posição: " +i);
        }

    }

    @Test
    public void buscaLinear() {
        //Busca linear tem um custo linear, quanto maaior é o vetor, mais demora a busca do elemento

        String[] estados = new String[10];
        boolean encontrou = false;
        estados[3] = "SP";
        estados[2] = "AC";
        estados[5] = "CE";
        estados[7] = "PR";
        estados[9] = "PB";
        estados[1] = "RS";
        estados[0] = "RN";
        estados[4] = "AL";
        estados[6] = "MA";
        estados[8] = "BA";

        String siglaBusca = "BA"; // sigla a ser buscada


        //busca linear
        for(int i=0; i<estados.length; i++){
            var elemento = estados[i];
            if(elemento.equals(siglaBusca)) {
                encontrou = true;
                break;
            }
        }

        if (encontrou) {
            System.out.println("Encontrado");
        }else {
            System.out.println("Não Encontrado");
        }

    }

    @Test
    public void listLigada() {
        var lista = new ListaLigada<String>();

        lista.adicionar("AC");
        lista.adicionar("BA");
        lista.adicionar("SP");
        lista.adicionar("CE");
        System.out.println("qtd :" + lista.getTamanho());
        System.out.println("primeiro elemento: " + lista.getPrimeiro().getValor());
        System.out.println("utimo elemento: " + lista.getUltimo().getValor());

        imprimi(lista, "lista completa");

        lista.remover("AC");
        imprimi(lista, "removendo AC ---------");

        System.out.println("primeiro elemento: " + lista.getPrimeiro().getValor());
        System.out.println("utimo elemento: " + lista.getUltimo().getValor());

        lista.adicionar("RJ");
        imprimi(lista, "adc RJ --------- ");

        System.out.println("primeiro elemento: " + lista.getPrimeiro().getValor());
        System.out.println("utimo elemento: " + lista.getUltimo().getValor());
    }

    @Test
    public void listLigadaInt() {
        var numeros = new ListaLigada<Integer>();

        numeros.adicionar(1);
        numeros.adicionar(2);
        numeros.adicionar(3);

        numeros.imprimi("lista completa");

        numeros.remover(2);
        numeros.imprimi("removendo numero 2");

    }

    private <T> void imprimi(T interator, String msg){

        if(interator instanceof ListaLigada ){
            var ls  = (ListaLigada) interator;
            System.out.println(msg);
            for(int i=0; i< ls.getTamanho(); i++){
                System.out.println( ls.get(i).getValor());
            }

        }else{
            throw new ExceptionInInitializerError("Erro!");
        }
    }

    @Test
    public void listLigadaTestePerformance() {

        //****** ArrayList
        //* Acessa o elemento diretamente pelo Índice (List.get(i))
        //* Mas rápido para buscar elemento em local aleatório da lista
        //* Inseri elementos apenas no final da lista


        //****** LinkedList
        //* Acessa os elementos em cadeia, do primeiro ao ultimo
        //* Mas rápido para inserir e remover elementos
        //* Consegue inserir elementos no meio da lista (List.add(index, elemt) )
        //* Implementa a interface Queue. Significa que vc pode criar lógicas de LIFO, FIFO , FILO e LILO de forma simplificada
        //
        //* CopyOnWriteArrayList é uma versão atualizada de LinkedList, sendo mais rápido para buscar elementos aleatórios

        //Quando há uma adição ou exclusão freqüente dos elementos na lista, o LinkedList deve ser usado, pois ele apresenta
        // melhor desempenho durante a manipulação. Se a pesquisa frequente for aplicada à lista, o ArrayList é a melhor opção,
        // pois apresenta melhor desempenho ao acessar elementos da lista.

        var numeros = new ListaLigada<Integer>();

        var tempInicial = System.currentTimeMillis();
        for(int i=0; i<100000; i++){
            numeros.adicionar(i);
        }
        var tempFinal = System.currentTimeMillis();
        System.out.println("Lista: " + (tempFinal - tempInicial));


        Integer[] veto = new Integer[100000];
        tempInicial = System.currentTimeMillis();
        for(int i=0; i<100000; i++){
            veto[i] = i;
        }
        tempFinal = System.currentTimeMillis();
        System.out.println("Vetor: " + (tempFinal - tempInicial));


        ArrayList<Integer> array = new ArrayList<>();
        tempInicial = System.currentTimeMillis();
        for(int i=0; i<100000; i++){
            array.add(i);
        }
        tempFinal = System.currentTimeMillis();
        System.out.println("array: " + (tempFinal - tempInicial));


        //CopyOnWriteArrayList
        var copyOnWriteArrayList = new CopyOnWriteArrayList<Integer>();
        tempInicial = System.currentTimeMillis();
        for(int i=0; i<100000; i++){
            copyOnWriteArrayList.add(i);
        }
        tempFinal = System.currentTimeMillis();
        System.out.println("copyOnWriteArrayList: " + (tempFinal - tempInicial));


        //linkedList
        var linkedList = new LinkedList<Integer>();
        tempInicial = System.currentTimeMillis();
        for(int i=0; i<100000; i++){
            linkedList.add(i);
        }
        tempFinal = System.currentTimeMillis();
        System.out.println("linkedList: " + (tempFinal - tempInicial));

        System.out.println("buscar elementos ------------------------------------------- ");

        //busca vetor
        int a;
        tempInicial = System.currentTimeMillis();
        for(int i=0; i<100000; i++){
            a =  veto[i];
        }
        tempFinal = System.currentTimeMillis();
        System.out.println("Vetor: " + (tempFinal - tempInicial));


        //busca com interator
        tempInicial = System.currentTimeMillis();
        var interator = numeros.getInterator();
        while (interator.temProximo()){
            interator.getProximo();
        }
        tempFinal = System.currentTimeMillis();
        System.out.println("listaLigada com iterador: " + (tempFinal - tempInicial));


        //busca arrayList
        tempInicial = System.currentTimeMillis();
        for(int i=0; i<100000; i++){
            array.get(i);
        }
        tempFinal = System.currentTimeMillis();
        System.out.println("array: " + (tempFinal - tempInicial));


        //busca CopyOnWriteArrayList
        tempInicial = System.currentTimeMillis();
        for(int i=0; i<100000; i++){
            copyOnWriteArrayList.get(i);
        }
        tempFinal = System.currentTimeMillis();
        System.out.println("copyOnWriteArrayList: " + (tempFinal - tempInicial));


        //buscar linkedList
        tempInicial = System.currentTimeMillis();
        for(int i=0; i<100000; i++){
            linkedList.get(i);
        }
        tempFinal = System.currentTimeMillis();
        System.out.println("linkedList: " + (tempFinal - tempInicial));

        //busca listaLigada
        tempInicial = System.currentTimeMillis();
        for(int i=0; i<100000; i++){
            numeros.get(i);
        }
        tempFinal = System.currentTimeMillis();
        System.out.println("Lista: " + (tempFinal - tempInicial));

    }

    @Test
    public void listLigadaTesteExclusaoPerformance() {

        ArrayList<Integer> array = new ArrayList<>();
        var copyOnWriteArrayList = new CopyOnWriteArrayList<Integer>();
        var linkedList = new LinkedList<Integer>();
        for(int i=0; i<100000; i++){
            array.add(i);
            copyOnWriteArrayList.add(i);
            linkedList.add(i);
        }
        array.add(99999999);
        copyOnWriteArrayList.add(99999999);
        linkedList.add(99999999);


        var tempInicial = System.currentTimeMillis();
        var a = array.remove(new Integer(99999999));
        var tempFinal = System.currentTimeMillis();
        System.out.println(a +""+"tempo para remover ArrayList: " + (tempFinal - tempInicial));

        tempInicial = System.currentTimeMillis();
        a = copyOnWriteArrayList.remove(new Integer(99999999));
        tempFinal = System.currentTimeMillis();
        System.out.println(a +""+"tempo para remover CopyOnWriteArrayList: " + (tempFinal - tempInicial));

        tempInicial = System.currentTimeMillis();
        a = linkedList.remove(new Integer(99999999));
        tempFinal = System.currentTimeMillis();
        System.out.println(a +""+ "tempo para remover LinkedList: " + (tempFinal - tempInicial));
    }

    @Test
    public void streamForVsIterator(){


        var linkedList = new LinkedList<Integer>();
        for(int i=0; i<1000000; i++){
            linkedList.add(i);
        }

        var tempInicial = System.currentTimeMillis();
        var interator = linkedList.iterator();
        while (interator.hasNext()){
            int nextV = interator.next();
            interator.remove();
        }
        var tempFinal = System.currentTimeMillis();
        System.out.println("Iterator: " + (tempFinal - tempInicial));

        tempInicial = System.currentTimeMillis();
        linkedList.stream().forEach(x -> {});
        tempFinal = System.currentTimeMillis();
        System.out.println("Stream for: " + (tempFinal - tempInicial));

        System.out.println(linkedList.size());
    }

    @Test
    public void baralho(){

        var baralho = Carta.embaralhar(Carta.construirBaralho());
        int aux=0;
        int count=1;

        for(var carta : baralho){
            System.out.println( aux+"- Mão " +count+ ": " +carta);
            aux++;

            if(aux == 13){
                System.out.println("-------------------------");
                aux = 0;
                count++;
            }
        }
        System.out.println("quantidade de cartas: " + baralho.size());
    }

    static class Carta{

        private String nome;
        private Nipe nipe;

        public Carta(String nome, Nipe nipe) {
            this.nome = nome;
            this.nipe = nipe;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public Nipe getNipe() {
            return nipe;
        }

        public void setNipe(Nipe nipe) {
            this.nipe = nipe;
        }

        public static CopyOnWriteArrayList<Carta> construirBaralho(){

            CopyOnWriteArrayList<Carta> baralho = new CopyOnWriteArrayList<>();

            Arrays.stream(Nipe.values()).forEach(n -> {
                var as = new Carta("Ás", n);
                baralho.add(as);

                for(Integer i = 2; i<=10; i++){
                    var carta = new Carta(i.toString(), n);
                    baralho.add(carta);
                }

                var valete = new Carta("Valete J", n);
                var rainha = new Carta("Rainha Q", n);
                var rei = new Carta("Rei K", n);

                baralho.add(valete);
                baralho.add(rainha);
                baralho.add(rei);
            });

            return baralho;
        }

        public static ArrayList<Carta> embaralhar(CopyOnWriteArrayList<Carta> baralho){

            var embaralhado = new ArrayList<Carta>();

            baralho.forEach(x -> {
                var carta = baralho.get(((int) (Math.random() * (baralho.size()))));
                baralho.remove(carta);
                embaralhado.add(carta);
            });

            return embaralhado;
        }

        @Override
        public String toString() {
            return nome + " - " + nipe;
        }
    }


    @Test
    public void lendoLinkedList(){

        ListaLigada<Integer> num = new ListaLigada<>();

        num.adicionar(1);
        num.adicionar(2);
        num.adicionar(3);
        num.adicionar(4);
        num.adicionar(5);

        imprimirComRecursao(num.getPrimeiro());

    }

    private void imprimirComRecursao(Elemento<Integer> elemento) {
        if(elemento != null){
            System.out.println(elemento.getValor());
            imprimirComRecursao(elemento.getProximo());
        }
    }

    enum Nipe{
        ESPADAS,
        PAUS,
        COPAS,
        OURO;
    }

}

// TODO estudar oq é o hashcode em java
//TODO praticar breake, continue etc