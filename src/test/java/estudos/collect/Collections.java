package estudos.collect;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import java.util.*;
import java.util.stream.Collectors;


import static java.util.Arrays.asList;

@RunWith(JUnit4.class)
public class Collections {

    @Test
    public void ArrayList(){
        // ArrayList a mais pratica coleção, servindo como canivente suiço em muitas situações
        // Funciona como um array, com funções praticas pre prontas.
        // Acessa o elemento diretamente pelo Índice (List.get(i))
        // Mas rápido para buscar elemento em local aleatório da lista
        // Inseri elementos apenas no final da lista

        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);

        imprimir(arrayList.iterator());
    }

    @Test
    public void t(){
      //  System.out.println(fn(7));


        //1)Desenvolva um algoritmo que, para cada número inteiro dentro do intervalo fechado entre 0 e 16, imprima:
        //o"foo" se o número for divisível por 3
        //o"bar" se o número for divisível por 5
        //o"baz" se o número for divisível por 3 e por 5
        //o próprio número caso contrario

//        for (int i=0; i<= 16; i++ ){
//
//            if(i % 3 == 0 && i % 5 == 0 )
//                System.out.println("foo");
//            else if(i % 3 == 0)
//                System.out.println("bar");
//            else if(i % 5 == 0)
//                System.out.println("baz");
//            else
//                System.out.println(i);
//        }
        //2)Implemente um algoritmo que receba como entrada uma sequência de Strings –
        // que podem ou não apresentar repetições – e imprima, uma única vez para cada termo,
        // a quantidade de vezes em que o mesmo foi encontrado.
        //
        //Obs: a formatação da saída é livre.
        //
        //Ex:
        //Entrada: ["PaTiNeTe", "SKATE", "Patinete", "BicicletA"]
        //Saída:
        //skate=1 patinete=2 bicicleta=1

        var stringList = asList("PaTiNeTe", "SKATE", "Patinete", "BicicletA");
        printFrequencyOfWord(stringList);
    }

    public void printFrequencyOfWord(List<String> stringList){
        var stringListLowerCase = stringList.stream()
                .map(String::toLowerCase)
                .collect(Collectors.toList());

        var stringSet = new HashSet<>(stringListLowerCase);

        stringSet.forEach(word -> {
           // System.out.println(word+" - "+Collections.frequency(stringListLowerCase, word));
        });
    }


    public int fn(int v){
        if(v==1 || v==0)
            return 1;
        if(v%2==0)
             return fn(v/2)+2;
        else
             return fn(v-1)+3;
    }

    @Test
    public void hashSet(){

        //Set é uma interface que tem como filosofia não permitir valores iguais nas coleções

        //principal caracteristica: não permitir valores iguais.
        //é preciso implementar corretamente iguais e hashCode do objeto guardado no Set
        // O set trabalha com conceito de "tabela hash" para agrupar os elementos.
        // O atributo que estiver sendo usado no metodo hashCode() da class usada para criação do Set<?>
        // não pode ser modificado apos a inclusão do objeto na lista, pois para buscar um elemento dentro do set
        // primeiro é calculado o valor do hash desse objeto,  encontrado o bucket onde o mesmo estar guardado
        // comparações usando iquals com todos os objetos dentro do bucket (evitar colisão ) é feita e objeto deve ser encontrado
        // Caso um valor do atributo usando no hashcode seja alterado, o bucket do objeto não é mais encontrado.

        //o uso do "contains" verifica se o elemento existe mais rapido que um ArrayList

        //outras implementações para a intrface Set
        //Set<Integer> ex1 = new LinkedHashSet<>();
        //Set<Integer> ex2 = new TreeSet<>();
        //Set<Integer> ex3 = new CopyOnWriteArraySet<>();


        Set<Integer> lista = new HashSet<>();
        lista.add(1);
        lista.add(2);
        lista.add(1);
        imprimir(lista.iterator());


        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(1);
        arrayList.add(2);

        var setSemDuplicados = arrayList.stream().collect(Collectors.toSet()); // removendo duplicados do arrayList

        System.out.println("removendo duplicados --- ");
        imprimir(setSemDuplicados.iterator());
    }

    @Test
    public void linkedList(){

        // Acessa os elementos em cadeia, do primeiro ao ultimo
        // Mas rápido para inserir e remover elementos
        // Consegue inserir elementos no meio da lista (List.add(index, elemt) )
        // Implementa a interface Queue. Significa que vc pode criar lógicas de LIFO, FIFO , FILO e LILO de forma simplificada

        //Quando há uma adição ou exclusão freqüente dos elementos na lista, o LinkedList deve ser usado, pois ele apresenta
        // melhor desempenho durante a manipulação. Se a pesquisa frequente for aplicada à lista, o ArrayList é a melhor opção,
        // pois apresenta melhor desempenho ao acessar elementos da lista.

        LinkedList<Integer> lista = new LinkedList<>();
        lista.add(3);
        lista.add(2);
        lista.add(1, 34); // coloca o elemento numa posição especifica

        imprimir(lista.iterator());

        // CopyOnWriteArrayList é uma versão atualizada de LinkedList, sendo mais rápido para buscar elementos aleatórios
    }

    @Test
    public void hasMap(){

        //Tem o mesmo comportamento de uma Tabela Hash, porem o uso pode variar devido a caracteristicas proprias

        //HashMap
        //Não Thread safe
        //Rapido
        //Permite chaves e valores nulos
        //Permite criar um objeto Thread safe
        //    Collections.synchronizedMap(new HashMap<>());

        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(null, null);
        hashMap.put(1, null);
        hashMap.put(null, "oi");

        imprimir(hashMap.values().iterator());
        imprimir(hashMap.keySet().iterator());
    }

    @Test
    public void hashTable(){

        //Tem o mesmo comportamento de Tabela Hash, porem o uso pode variar devido a caracteristicas proprias

        // HashTable
        // Thread safe internamente
        // Lento
        // Nao Permite chaves ou valores nulos

        Hashtable<Integer,String> hashtable = new Hashtable<>();
        hashtable.put(1, "oi");
        hashtable.put(2, "oi");

        imprimir(hashtable.values().iterator());
        imprimir(hashtable.keySet().iterator());
    }

    @Test
    public void criarCollectionsThreadSafe() {

        // criar collections com Thread safe

        java.util.Collections.synchronizedMap(new HashMap<>());
        java.util.Collections.synchronizedList(new ArrayList<>());
        java.util.Collections.synchronizedSet(new HashSet<>());


    }

    @Test
    public void converterCollections() {

        // Converter collections

        List<Integer> arrayList = new ArrayList<>();

        //arrayList para hashSet
        var set = arrayList.stream().collect(Collectors.toSet());
    }



    private <T> void imprimir(Iterator<T> iterator){

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

}
