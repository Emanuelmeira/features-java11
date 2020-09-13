package estudos.interfacesfuncionais;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.DoublePredicate;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * interfaces funcionais podem ser divididas em 3 categorias:
 * 1 - apenas executa algo                                  test()
 * 2 - recebe parametro e executa algo                      test(T t)
 * 3 - recebe parametro, executa algo e devolve um valor    T test(T t)
 */
@RunWith(JUnit4.class)
public class InterfaceFuncionalTestes {

    @Test
    public void supplier(){

        //TIPO 1
        Supplier<LocalDateTime> sup = () -> LocalDateTime.now();
        System.out.println(sup.get());
    }

    @Test
    public void consumer(){

        //TIPO 2
        Consumer<String> con = x -> System.out.println(x);
        con.accept("Consumer");

        IntStream.range(0,5)
                .forEach(System.out::println); // recebe um consumer

        //Usando andThen()
        System.out.println("-------------------------------------Testando o andThen--------------------------------------");
        Consumer<String> then = x -> System.out.println(x);
        then = then.andThen(x -> System.out.println(x + " pela segunda vez"));
        then.accept("Testando o Then");

    }

    @Test
    public void biConsumer(){

        //TIPO 2
        BiConsumer<String, String> biConsumer = (s1, s2) ->  System.out.println(s1+s2);
        biConsumer.accept("Emanuel ", "MEira");

        System.out.println("-------------------------------------Testando o andThen--------------------------------------");
        BiConsumer<String, String> then = (s1, s2) ->  System.out.println(s1+s2);
        then = then.andThen( (s1, s2) ->  System.out.println(s1.concat("_Teste ")+s2.concat("_Teste")) );
        then.accept("Emanuel ", " MEira");
    }

    @Test
    public void predicate(){

        //TIPO 3
        Predicate<Integer> pred = n -> n == 10;
        System.out.println(pred.test(1));

        Predicate<ClassPred> predT = t -> t.idade > 18 && t.nome.startsWith("Emanuel");
        System.out.println(predT.test(new ClassPred(15, "Aline")));

        //existem predicate mais expecificos, não necessitando de boxing e unboxing
        DoublePredicate predD = d -> d == 1.8;
        System.out.println(predD.test(12.9));

        IntPredicate predI = i -> i > 10;
        System.out.println(predI.test(123));

        LongPredicate preL = l -> l > 1000000l;
        System.out.println(preL.test(123l));
    }

    @Test
    public void biPredicate(){
        BiPredicate<String, Integer> biP = (x, y) -> x.length() == y;
        System.out.println(biP.test("casa", 4));

        System.out.println("---------------------Testando o and----------------------");
        //Executa dois testes que tem que retornar true
        var and = biP.and((x , y) -> x.length() == y);
        System.out.println(biP.test("casa", 4));

        System.out.println("-------------------Negando predicate---------------------");
        var negate = biP.negate();
        System.out.println(negate.test("casa", 4));
    }

    @Test
    public void function(){

        //TIPO 3
        Function<ClassPred, Integer> function = c -> c.idade;
        System.out.println(function.apply(new ClassPred(15, "Aline")));

        new ClassPred().getLs()
                        .map(n -> n.nome) // recebe um tipo, processa e devolve um novo tipo
                        .forEach(System.out::println);

        System.out.println("-------------------------------------Testando o andThen--------------------------------------");
        Function<ClassPred, Integer> then = c -> c.idade;
        then = then.andThen(c -> c + 15);

        System.out.println(then.apply(new ClassPred(15, "Aline")));
    }

    @Test
    public void biFunction(){

        var lsCp1 = Arrays.asList(new ClassPred(15, "Aline"),
                                                            new ClassPred(15, "Juliana"));
        var cp1 = new ClassPred(15, "Juliana");

        //TIPO 3
        BiFunction<List<ClassPred>, ClassPred, Boolean>  biFunction = (lsCp, cp) -> lsCp.contains(cp);
        System.out.println(biFunction.apply(lsCp1, cp1));
    }

    @Test
    public void binaryOperator(){

        //binaryOperator extends o BiFunction<T,T,T> passando 3 tipos iguais
        //logo, os argumentos passados e o retorno tem que ser do mesmo tipo

        //TIPO 3
        BinaryOperator<Integer> binaryOperator = (s1, s2) -> s1+s2;
        System.out.println(binaryOperator.apply(1, 1));

        new ClassPred().getLs()
                .map(n -> n.idade )
                .reduce((s1, s2) -> s1+s2) // recebe um tipo, processa e devolve um novo tipo
                .ifPresent(n -> System.out.println(n));
    }

    @Test
    public void unaryOperator(){

        //TIPO 3
        UnaryOperator<String> unaryOperator = n -> n.concat(" Meira");
        System.out.println(unaryOperator.apply("Emanuel"));

        //igual a function, so que o tipo de entrade e o tipo de saida devem ser o mesmo
    }

    @Test
    public void aaa(){

        Stream.iterate(1l, n -> n +2l).peek(n -> System.out.println("OK")).limit(10000l).forEach(System.out::println);
    }


    class ClassPred {

        Integer idade;
        String nome;

        public ClassPred() {}

        public ClassPred(Integer idade, String nome) {
            this.idade = idade;
            this.nome = nome;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ClassPred classPred = (ClassPred) o;
            return Objects.equals(idade, classPred.idade) &&
                    Objects.equals(nome, classPred.nome);
        }

        public Stream<ClassPred> getLs(){
            return Arrays.asList(new ClassPred(15, "Aline"),
                    new ClassPred(15, "Juliana")).stream();
        }
    }

}
