package estudos.collect;

import estudos.stream.PersonStream;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RunWith(JUnit4.class)
public class CollectsTestes {

    /** Usado para objetos mutaveis, (list, map, set)
     *
     */

    @Test
    public void collectNotImplemented() {
        var lsNumbers = Arrays.asList(1,2,3,4,5,6,6,6,7,8,9);

        /**
         * ****CRIANDO O SEU COLLECTORS*****
         * supplier: Função lambda que vai fornecer a instancia do objeto onde queremos acumular o resultado
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

        System.out.println( "------------------------------ guardar valores em um List/Set ------------------------------------------");
        lsNumbers.stream()
                 .filter(x -> x % 2 == 0)
                 .collect(Collectors.toList()) //metodo tbm existe para Set .toSet()
                 //.collect(Collectors.toCollection(TreeSet::new)) //para informar um tipo especifico
                 .forEach(x -> System.out.println(x));

        System.out.println( "-----------  guardar valores em um Map (definindo manualmente qual a chave e o valor)  ------------------");
        //toMap, em sua forma mais simples recebe dois argumentos, o primeiro seta a definição da chave e o segundo sera o valor
        Map<Integer, Double> collect = lsNumbers.stream()
                .distinct()
                .collect(Collectors.toMap(n -> n, n -> Math.pow(n.doubleValue(), 4)));
        System.out.println(collect);

        System.out.println( "------------------------------ Joinng em collect  -------------------------------------------------------");
        String stringsJoined = lsNumbers.stream()
                .map(e -> String.valueOf(e))
                .collect(Collectors.joining(";")); // agrupando tudo em uma unica string delimitando com ';'
        System.out.println(stringsJoined);

        System.out.println( "------------------------------ Obtendo a media com averagingInt  -----------------------------------------");
        Double media = lsNumbers.stream()
                 .collect(Collectors.averagingInt( i -> i.intValue()) ); //obtendo a media dos valores no momento do collect
        System.out.println( "Media " + media);

        System.out.println( "------------------------------ Somando dados da lista com summingInt -------------------------------------");
        Integer soma = lsNumbers.stream()
                .collect(Collectors.summingInt(n -> n.intValue()) ); // obtendo unicamente a  soma dos valores
        System.out.println( "Soma " + soma);

        System.out.println( "------------------------------ Obtendo estatisticas ------------------------------------------------------");
        //É possivel obter com o tipo primitivo Int uma chamada onde dados estatisticos do streamn são retornados
        var stats = lsNumbers.stream()
                .collect(Collectors.summarizingInt(n -> n.intValue()));// convertendo para int e obtendo dados estatisticos
        System.out.println( "Media de itens " + stats.getAverage());
        System.out.println( "Quantidade de itens " + stats.getCount());
        System.out.println( "Max " + stats.getMax());
        System.out.println( "Min " + stats.getMin());
        System.out.println( "Soma " + stats.getSum());

    }

    @Test
    public void collectWithGrouping() {
        var lsNumbers = Arrays.asList(1,2,3,4,5,6,6,6,7,8,9,9);

        System.out.println( "------------------------------ Agrupando dados em Map --------------------------------------------------");
        Map<Boolean , List<Integer>> map = lsNumbers.stream()
                .map(e -> e * 3) //multiplica os valores do stream por 3
                .collect(Collectors.groupingBy(e -> e % 2 == 0)); // separa em dois grupos, numeros divididos por 2 e os não divisiveis
        System.out.println(map);

        Map<Integer , List<Integer>> map2 = lsNumbers.stream()
                .collect(Collectors.groupingBy(e -> e % 3 )); // agrupamento pelo resto da divisão por 3
        System.out.println(map2);

    }

    @Test
    public void collectWithPartitioningBy() {
        var lsNumbers = Arrays.asList(1,2,3,4,5,6,6,6,7,8,9,9);


        System.out.println( "------------------------------ Agrupando dados em Map partitioningBy --------------------------------------------------");
        //partitioningBy agrupa em um Map, porem sempre é um Map de Boolean
        Map<Boolean , List<Integer>> map = lsNumbers
                .stream()
                .collect(Collectors.partitioningBy(e -> e % 3 == 0)); // separa em dois grupos: numeros divididos por 2 e os não divisiveis
        System.out.println(map);

        Map<Boolean, List<PersonStream>> namesStartsWithA = PersonStream
                .getList()
                .stream()
                .collect(Collectors.partitioningBy(n -> n.getName().startsWith("A"))); //agrupando por nomes que começam com a letra 'A'
        System.out.println(namesStartsWithA);
    }

    @Test
    public void CollectWithComparator() {

        var lsNumbers = Arrays.asList(1,2,3,4,5,6,6,6,7,8,9,9);

        System.out.println( "------------------------------ Maior valor com Comparator.naturalOrder() --------------------------------");
        lsNumbers.stream()
                .filter(x -> x % 2 == 0)
                .collect(Collectors.maxBy(Comparator.naturalOrder()))
                //.collect(Collectors.maxBy(Comparator.reverseOrder())) organizar inversamente a ordem natural
                .ifPresent(n -> System.out.println("maior valor" + n));

        System.out.println( "------------------------------ Maior valor com Comparator.comparing() implementado -----------------------");

        //implementação do comparing convencional
        PersonStream
                .getList()
                .stream()
                .collect(Collectors.maxBy(new Comparator<PersonStream>() {
                    @Override
                    public int compare(PersonStream o1, PersonStream o2) {
                        return o1.age.compareTo(o2.getAge());
                    }
                }))
                .ifPresent(System.out::println);

        //implementação do comparing com method Reference
        PersonStream
                .getList()
                .stream()
                .collect(Collectors.maxBy( (s1,s2) -> s1.age.compareTo(s2.getAge())))
                .ifPresent(System.out::println);

        //implementação do comparing com method Reference
        PersonStream
                .getList()
                .stream()
                .collect(Collectors.maxBy( CollectsTestes::compare))
                .ifPresent(System.out::println);

        var list = Arrays.asList("oi", "obrigado", "bem vindo");
        list.sort((s1, s2) -> s1.compareTo(s2));

        System.out.println( list);
    }

    private static int compare(PersonStream s1, PersonStream s2){
        return  s1.age.compareTo(s2.age);
    }
}
