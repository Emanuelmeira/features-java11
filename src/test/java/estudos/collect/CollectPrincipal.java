package estudos.collect;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RunWith(JUnit4.class)
public class CollectPrincipal {

    /** Usado para objetos mutaveis, (list, map, set)
     *
     */

    @Test
    public void collectNotImplemented() {
        var lsNumbers = Arrays.asList(1,2,3,4,5,6,6,6,7,8,9);

        /** supplier: Função lambda que vai fornecer a instancia do objeto onde queremos acumular o resultado
         *  accumulator: Recebe a lista e UM elemento do stream como parametro, (similar a função reduce)
         *  combiner: Responsavel por agrupar(combinar) os colletors da execução paralela (similar a função reduce) nesse caso varias listas em uma unica
         *  paremtros: ccollect(supplier, accumulator, combiner)
         */
        lsNumbers.stream().collect(
                () -> new ArrayList<>(),              //OQUE será usado para armazenar o resultado
                (list, e) -> list.add(e) ,            //COMO armazenar o resultado
                (list1, list2) -> list1.addAll(list2) //COMO combinar as varias threads que podem estar tratando esse stream
        ).forEach(System.out::print);

    }

    @Test
    public void collector() {
        var lsNumbers = Arrays.asList(1,2,3,4,5,6,6,6,7,8,9,9);

        Map<Boolean , List<Integer>> map = lsNumbers.stream()
                .map(e -> e * 3) //multiplica os valores do stream por 3
                .collect(Collectors.groupingBy(e -> e % 2 == 0)); // separa em dois grupos, numeros divididos por 2 e os não divisiveis
        System.out.println(map);

        Map<Integer , List<Integer>> map2 = lsNumbers.stream()
                .collect(Collectors.groupingBy(e -> e % 3 )); // agrupamento pelo resto da divisão por 3
        System.out.println(map2);

        String stringsJoined = lsNumbers.stream()
                .map(e -> String.valueOf(e))
                .collect(Collectors.joining(";")); // agrupando tudo em uma unica string
        System.out.println(stringsJoined);
    }

}
