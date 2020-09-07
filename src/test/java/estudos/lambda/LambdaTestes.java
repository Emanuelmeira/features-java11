package estudos.lambda;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@RunWith(JUnit4.class)
public class LambdaTestes {

    @Test
    public void lambdaWith(){

    }

    @Test
    public void methodReference(){

        /**
         *
         * Method Reference: é uma outra forma de escrever lambda
         *
         */

        System.out.println( "------------------------------ referenciando metodo da class -------------------------------------------");
        IntStream.range(0, 10)
                .map(LambdaTestes::multiplicaPorDois)
                .forEach(System.out::println);

        System.out.println( "------------------------------ referenciando metodo doubleValue ----------------------------------------");
        Arrays.asList(0, 5,6,7,8)
                .stream()
                //.map(n -> n.doubleValue() ) // Sem method Reference
                .map(Integer::doubleValue )   //Com method Reference || metodo do Integer sendo referenciado
                .forEach(System.out::println);

        System.out.println( "------------------------------ referenciando metodo na criação de um BigDecimal ------------------------");
        Arrays.asList(0, 5,6,7,8)
                .stream()
                //.map(n -> new BigDecimal(n)) // Sem method Reference
                .map(BigDecimal::new)          //Com method Reference || valor passado como argumento do construtor
                .forEach(System.out::println);

        System.out.println( "------------------------------ referenciando metodo para acumulação em BigDecimal ----------------------");
        BigDecimal dois = new BigDecimal(2);
        Arrays.asList(0,1,2,3,4,5)
                .stream()
                .map(BigDecimal::new)
                .map(dois::multiply)  // valor passado como argumento do metodo multiply
                .forEach(System.out::println);

    }

    private static Integer multiplicaPorDois(Integer num){
        return num * 2;
    }

}
