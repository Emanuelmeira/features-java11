package estudos.lambda;

import estudos.lambda.interfaces.ApenasProcessaAlgo;
import estudos.lambda.interfaces.CarroPredicate;
import estudos.lambda.interfaces.RecebeParametroEProcessa;
import estudos.lambda.interfaces.RecebeUmParametroProcessaEDevolveUmTipo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;
import java.util.stream.IntStream;

@RunWith(JUnit4.class)
public class LambdaTestes {

    @Test
    public void minhasInterfaces(){

        ApenasProcessaAlgo apenasProcessaAlgo = () -> System.out.println("Hello");
        apenasProcessaAlgo.processIt();

        RecebeParametroEProcessa<String> recebeParametroEProcessa = (String x) -> System.out.println(x);
        recebeParametroEProcessa.recebeUmParametroEProcessa("oi");

        RecebeUmParametroProcessaEDevolveUmTipo<String, Integer> recebePPDT = (String n) ->  {
            var val = n.length();
            System.out.println(val);
            return val;
        };
        recebePPDT.recebeUmParametroProcessaEDevolveUmTipo("uma frase");
    }

    @Test
    public void lambdaSimples() {

        //Exemplo sem lambda
        CarroPredicate carroPredicate = new CarroPredicate(){
            @Override
            public boolean test(Carro carro) {
                return carro.getCor().equals("verde");
            }
        };

        System.out.println(carroPredicate.test(new Carro("verde")));

        //Exemplo com lambda
        CarroPredicate carroPredicate2 = carro -> carro.getCor().equals("verde");
        System.out.println(carroPredicate2.test(new Carro("Azul")));

        Runnable runnable = () -> System.out.println("ok"); // A interface funcional Runnable apenas processa algo  public abstract void run();
        runnable.run();

        var data = supGet( () -> LocalDate.now() );
        System.out.println(data.toString());

    }


    @Test
    public void IFRecebeParametroEProcessaAlgo(){
        // interface funcional Consumer, recebe parametro, e processa algo || void accept(T t);
        imprimir(Arrays.asList("vamos lá!", "Casa branca", "vaaai lakers"), (String x) -> System.out.println(x));
    }

    @Test
    public void IFRecebeParametroProcessaAlgoERetornaAlgo(){
        // interface funcional Function, recebe parametro, processa algo e devolve um tipo || R apply(T t);
        var map = map(Arrays.asList("vamos lá!", "Casa branca", "vaaai lakers"), (String x) -> x.length());
        map.forEach(System.out::println);
    }

    @Test
    public void methodReference(){

        /**
         * Method Reference: é uma outra forma de escrever lambda
         * Existe 4 tipos de methodReference:
         * Referenciar um metodo statico de uma class  nomeDaClass::metodoStatico
         * Referenciar um metodo de um objeto          pessoaObjeto::getIdade
         * Referenciar um metodo de um tipo            Integer::doubleValue
         * Referenciar um construtor                   BigDecimal::new
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

    @Test
    public void obterAtributosObjetosLista(){
        map(Arrays.asList("a","ab", "abc"), (String x) -> x.startsWith("b")).forEach(System.out::println);
    }

    private <T> List<T> filtrarLista(List<T> lista, Predicate<T> predicate) {
        List<T> listaFiltrada = new ArrayList<>();

        lista.forEach(items -> {
            if(predicate.test(items)){
                listaFiltrada.add(items);
            }
        });

        return  listaFiltrada;
    }

    private <T, R> List<R> map(List<T> list, Function<T, R> function){
        List<R> lsReturn = new ArrayList<>();

        list.forEach( x -> {
            lsReturn.add(function.apply(x));
        });

        return lsReturn;
    }

    private <T> void imprimir(List<T> list, Consumer<T> c){
        list.forEach( x -> c.accept(x) );
    }

    private <T> T supGet(Supplier<T> sup){
        return sup.get();
    }

    private static Integer multiplicaPorDois(Integer num){
        return num * 2;
    }

}
