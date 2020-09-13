package estudos.streamParalelo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;
import java.util.stream.Collectors;

@RunWith(JUnit4.class)
public class StreamParaleloTestes {

    @Test
    public void streamParalelo(){
        var lsInteger = Arrays.asList(1,2,3,4,5,6,7,8,9);

        lsInteger.stream()
                .forEach(System.out::println);

        System.out.println("---------forEach em parallelStream--------------");
        lsInteger.parallelStream()
                .forEach(System.out::println); // elementos desorganizados porque cada um esta numa thread distinta

        System.out.println("-------forEachOrdered e parallelStream-----------");
        lsInteger.parallelStream()
                .forEachOrdered(System.out::println);  // elementos organizados na impressão
    }

    @Test
    public void streamParaleloFindAny(){
        var lsInteger = Arrays.asList(1,2,3,4,5,6,7,8,9);

        System.out.println("---------findAny em stream--------------");
        lsInteger.stream()
                .findAny()                   //o primeiro elemento do stream é encontrado e retornado
                .ifPresent(System.out::println);

        System.out.println("---------findAny em parallelStream--------------");
        lsInteger.parallelStream()
                .findAny()
                .ifPresent(System.out::println); //o primeiro elemento pode variar pois os dados estão divididos em threads
    }

    @Test
    public void streamParaleloUnordered(){
        var lsInteger = Arrays.asList(1,2,3,4,5,6,7,8,9);

        lsInteger.parallelStream()
                .unordered() // garante as operações que exigem certa sequencia
                .skip(1)     //unordered() garante que qualquer primeiro elemento que chegar das threads sera pulado
                .limit(2)    //unordered() garante que qualquer dois elementos já processados de qualquer threads sera suficiente
                .forEachOrdered(System.out::println);
    }

    @Test
    public void streamParaleloReduce(){
        /**
         * IMPORTANTE: REDUCE É USADO PARA OPERAÇÕES ASSOCIATIVAS (soma, multiplicação etc ..)
         * (1 + 2) + (3 + 4) = 10  - é associativa
         * (1 - 2) - (3 - 4) != -8 - não é associativa
         * quando os valores que estão sendo processados em threads distintas são combinados
         * apenas valores associativos mantem a integridade.
         */

        var lsInteger = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15);

        System.out.println("--------------reduce associativo---------------");
        lsInteger.parallelStream()
                .reduce((x, y) -> x+y)
                .ifPresent(System.out::println);

        System.out.println("------------reduce não associativo--------------");
        lsInteger.parallelStream()
                .reduce((x, y) -> x-y) // você não tem garantia do resultado
                .ifPresent(System.out::println);
    }

    @Test
    public void streamParaleloCollectMap(){

        var lsInteger = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15);

        var map = lsInteger.parallelStream()
                                              .collect(Collectors.toMap(n -> n, n -> n % 2==0 ));
                                              //cada thread tem um HashMap, onde os valores são adicionados e depois são combinados em um unico HashMap
        System.out.println(map);

        System.out.println("--------------toConcurrentMap--------------");
        /**
         * Por padrão o hasMap não é thread-safe, o ConcurrentMap é!
         * Caso exista muitos elementos a serem processados, usar o ConcurrentMap é uma opção, pois deve existir
         * um unico map, onde as threads vão postando neles ao mesmo tempo,  ConcurrentMap da suporte a isso porqque é thread-safe
         */
        var mapConcurrent = lsInteger.parallelStream()
                          .collect(Collectors.toConcurrentMap(n -> n, n -> n % 2==0 ));
                          //um unico HashMap compartilhado entre threads é usado para postagem dos dados, não existindo a "combinação" dos dados
                          //sendo mais rapido

        System.out.println(mapConcurrent);

        System.out.println("-----------groupingByConcurrent------------");
        //outro exemplo do uso de recurso thread-safe compartilhado entre threads
        var mapGroupingByConcurrent = lsInteger.parallelStream()
                .collect(Collectors.groupingByConcurrent(n -> n % 2==0 ));
        System.out.println(mapGroupingByConcurrent);


        //OBS: usar toConcurrentMap ou groupingByConcurrent não garante a ordem dos elementos no map
    }
}
