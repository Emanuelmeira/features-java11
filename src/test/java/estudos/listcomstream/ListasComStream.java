package estudos.listcomstream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RunWith(JUnit4.class)
public class ListasComStream {


    @Test
    public void recursosEmListas() {

        //var lsInteger = Arrays.asList(1,2,3,4,5,6,7,8,9); retorna uma lista com "fixed-size" não permitindo algumas alterações na lista
        List<Integer> lsInteger = new ArrayList<>();

        lsInteger.add(1);
        lsInteger.add(2);
        lsInteger.add(3);
        lsInteger.add(4);
        lsInteger.add(5);
        lsInteger.add(6);

        //forEach
        lsInteger.forEach(x -> System.out.println(x));  // recebe um consumer

        System.out.println("----------------------------------");
        //removeIf
        lsInteger.removeIf( n -> n %2 == 0);   // recebe um predicate
        lsInteger.forEach(System.out::println);

        System.out.println("----------------------------------");
        //replateAll
        lsInteger.replaceAll( n -> n*2);   // recebe um UnaryOperator, o resultado deve substituir o dado da lista
        lsInteger.forEach(System.out::println);
    }


    @Test
    public void recursosEmMap() {

        HashMap<Integer, String> map = new HashMap();
        map.put(1, " Olá");
        map.put(2, " Bem");
        map.put(3, " Vindo");
        map.put(4, " Pessoal");
        map.put(5, " Tchau");

        //foreach
        map.forEach((k, v) -> System.out.println(k + v));

        System.out.println("----------------------------------");
        //computer vai fazer uma alteração em uma chave especifica do mapa
        map.compute(1, (k, v) -> v.concat(" - compute"));
        map.forEach((k, v) -> System.out.println(k + v));

        //caso a chave não exista, ele adiciona o valor ao map com a chave
        System.out.println("----------------------------------");
        map.compute(7, (k, v) -> " - compute "+v);
        map.forEach((k, v) -> System.out.println(k + v));


        System.out.println("----------------------------------");
        //o merge procura a chave e caso encontre, o vlaor informado e o valor do map vão para os parametros(v1 , v2) e são trabalhados
        //o resultado é salvo no valor da chave
        map.merge(2, "jogar", (v1, v2) ->   v1+v2 );
        map.forEach((k, v) -> System.out.println(k + v));


        System.out.println("----------------------------------");
        //Caso o merge não encontre o dado pela chave, o mesmo cria mais um elemento no map passando chave e valor fornecidos
        map.merge(10, " jogar", (k, v) ->  v.toUpperCase() );
        map.forEach((k, v) -> System.out.println(k + v));


        System.out.println("----------------------------------");
        //Substitui todos os valores do map pelo novo valor expresso na lambda
        map.replaceAll((k, v) -> v+"!");
        map.forEach((k, v) -> System.out.println(k + v));

    }

}
