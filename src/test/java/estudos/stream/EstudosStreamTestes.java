package estudos.stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@RunWith(JUnit4.class)
public class EstudosStreamTestes {


    //TODO falta "sorted"

    //FONTE: https://rinaldo.dev/java-8-streams-pare-de-usar-for-e-simplifique-seu-codigo/
    //Stream = Fluxo de dados

    @Test
    public void createStream() {

        List<String> items = Arrays.asList("Um", "Dois", "Tres");

        Stream<String> stream = items.stream();

        try {
            Stream <String> lines = Files.lines(Paths.get("myFile.txt"), Charset.defaultCharset());

        }catch (Exception e){}

        Stream<Integer> numbersFromValues = Stream. of(1, 2, 3, 4, 5);
        Stream<String> StringsFromValues = Stream. of("1", "2", "3", "4", "5");
        IntStream numbersFromArray = Arrays.stream(new int[] {1, 2, 3, 4, 5});

    }

    @Test
    public void interactingStreamWithForEach() {
        List<String> items = Arrays.asList("Pedro", "Miguel", "Maria");

        items.stream().forEach( person -> System.out.println(person));

        items.stream().forEach(
                person -> {
                    if(!person.equals("Miguel"))
                        System.out.println(person);
                });

        List<PersonStream> list = new PersonStream().getList();

        list.stream().forEach( person -> {
            if(person.age > 21)
                System.out.println("NOME: "+person.name +"::::" + "AGE: "+person.age);
        });
    }

    @Test
    public void streamWithFilter() {

        List<PersonStream> list = new PersonStream().getList();

        Stream<PersonStream> streamList = list.stream().filter(person -> person.age > 26 );

        Stream<PersonStream> streamList3 = list.stream().filter(person -> person.age > 26 && person.name.equals("Emanuel") );

        //filter mais complexo com predicate
        Stream<PersonStream> streamList2 = list.stream().filter(person -> {
            Predicate<PersonStream> PredicatePerson = n -> n.age > 26 || n.name.equals("Emanuel");
            return PredicatePerson.test(person);
        });
    }

    @Test
    public void streamWithMap() {

        //Transformar o tipo com map
        List<PersonStream> personList = new PersonStream().getList();

        personList.stream() //monothread
                .filter(person ->  person.age != 25 )
                .map(p -> p.name)
                .forEach(x -> System.out.println("NAME: "+ x));

        personList.parallelStream() //multithread
                .filter(person ->  person.age != 25 )
                .map(p -> { return new Person(p.name, p.age, true); })
                .forEach(x -> System.out.println("NAME: "+ x.name +":: STATUS: "+x.active));

        personList.stream()
                .filter(person ->  person.age != 25 )
                .mapToInt(p -> p.age)
                .forEach(x -> System.out.println("Idades somadas"));

        personList.stream()
                .mapToInt(PersonStream::getAge)
                .average()
                .ifPresentOrElse(n -> System.out.println("MEDIA: "+ n), () -> System.out.println("MEDIA não enconrada"));

        List<String> words = Arrays.asList("Oracle", "Java", "Magazine");
        List<Integer> wordLengths =   words.stream()
                .map(String::length)
                .collect(toList());

        //Transformar IntStream em List<Integer>
        List<Integer> ageList = personList.stream()
                .filter(person ->  person.age != 25 )
                .mapToInt(p -> p.age)
                .boxed().collect(toList());

    }

    @Test
    public void streamWithMatch() {

        //Pesquisas e identificação de coincidências anyMatch, allMatch e noneMatch

        List<PersonStream> list = new PersonStream().getList();

        boolean allMatch = list.stream().allMatch(x -> x.age == 20);
        System.out.println("AllMatch: " + allMatch);

        boolean anyMatch = list.stream().anyMatch(x -> x.age == 30);
        System.out.println("AnyMatch: " + anyMatch);

        boolean noneMatch = list.stream().noneMatch(x -> x.age == 21);
        System.out.println("NoneMatch: " + noneMatch);

    }

    @Test
    public void streamWithReduce() {

        //usado para acumulação de valores, não necesariamente precisam ser numericos

        /**
         * IMPORTANTE: USADO PARA OPERAÇÕES ASSOCIATIVAS (soma, multiplicação etc ..)
         * (1 + 2) + (3 + 4) = 10  - é associativa
         * (1 - 2) - (3 - 4) != -8 - não é associativa
         * quando os valores que estão sendo processados em threads distintas são combinados
         * apenas valores associativos mantem a integridade.
         */

        /**
         * O funcionamento do reduce: na primeira interação os dois primeirso numeros são postos nas varievesi n1 e n2 respectivamente,
         *  uma multiplicação é feita entra os dois e o resultado é guardado em n1, o proximo valor é buscado do stream sendo posto na n2
         *  e assim novamente uma multiplicação é feita, seguindo assim esse fluxo até o fim da stream
         */
        var numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        numbers.stream()
                .reduce((n1, n2) -> n1 * n2)
                .ifPresent(n -> System.out.println("Resultado da mutiplicação: " +n));


        /** Valor de identidade, serve como um valor padrão a ser retornado, POREM ele deve respeitar o valor para cada operação
         *  o valor de identidade para operações de soma é 0, para multiplicação é 1, e para string é "".
         *  ** Quando se passa o valor de indentidade e o valor do stream o resultado tem que ser o proprio valor
         *  EX: para operações de soma  0(valor identidade)+1 = 1
         *  EX: para operações de multiplicação  1(valor identidade)*1 = 1
         *
         *  Caso um valor identidade diferente seja informado, então o calculo sera afertado
         */
        var sum = Stream.of(1,2,3,4,5,6,7,8,9,10)
                .reduce(0, (a, b) -> a + b);
        System.out.println("Valores somados: " + sum);

        //Mesmo exemplo com method reference
        var sum2 = Stream.of(10, 5, 10).reduce(0, Integer::sum);
        System.out.println("Valores somados: " + sum2);

        //Concatenação de Strings usando reduce
        String frase = "Nunca desista de ser um bom programador";
        String[] vector = frase.split(" ");
        Stream.of(vector)
              .reduce((s1, s2) -> s1.concat(s2))
              .ifPresent(n -> System.out.println(n));

        //reduce - menor valor
        var optDu = Stream.of(4.5, 1.5, 8.3, 10.5)
                .reduce((d1, d2) -> Math.min(d1, d2));
        System.out.println(optDu.orElse(0.0));

        /** Não é recomendavel usar reduce para funções NÃO Associativa ex: subitração de valores
         *  quando parallelStream() é usando, os dados para processamento são divididos entre os processadores,
         *  apos o processamento os resultados são somados, tornando um so resultado
         */

        /** Para banho de performance é possivel utilizar as funções de acumulação e combinação, divididas entre os nucleos do processador.
         *  A função de acumulação é quebrada e executada em varios nucleos, ao fim dessa funçao, a funçao combinação é chamada
         *  combinando os resultados gerados separadamente em cada nucleo
         *
         *  ** Função de combinação so e chamada num stream paralelo
         */
        Stream.of(1,2,3,4,5,6,7,8,9,10)
              .parallel()
              .reduce("", (s1, s2) -> s1.toString().concat(s2.toString() ), //função de acumulação
                                 (n1, n2 ) -> n1.concat(n2)  ); //função de combinação
    }

    @Test
    public void streamWithSkipAndLimiteAndDistinct() {

        IntStream.of(1,2,3,4,5)
                .skip(2) // pular os dois primeiros elemetos
                .forEach(e -> System.out.println(e +" skip"));

        IntStream.of(1,2,3,4,5)
                .limit(3) // limita o processamento em x items
                .forEach(e -> System.out.println(e +" limit"));

        IntStream.of(1,1,1,4,5,6 )
                .distinct() // não processa elementos iguais, é usado o equals e hashcode do elemento para comparação
                .forEach(e -> System.out.println(e +" Distinct"));
    }

    @Test
    public  void streamWithCountMinMax() {
        var lsNumbers = Arrays.asList(1,2,3,4,5,6,6,6,7,8,9,9);

        lsNumbers.stream()
                .min(Comparator.naturalOrder()) //Comparator ja implementado para a class Integer //TODO estudar mais
                .ifPresent(n -> System.out.println("Valor minimo encontrado: "+ n));

        lsNumbers.stream()
                .max(Comparator.naturalOrder()) //Comparator ja implementado para a class Integer //TODO estudar mais
                .ifPresent(n -> System.out.println("Valor maximo encontrado: "+ n));
    }



}
