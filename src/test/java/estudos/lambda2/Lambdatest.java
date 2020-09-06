package estudos.lambda2;

import estudos.lambda2.interfaces.ApenasProcessaAlgo;
import estudos.lambda2.interfaces.CarroPredicate;
import estudos.lambda2.interfaces.RecebeParametroEProcessa;
import estudos.lambda2.interfaces.RecebeUmParametroProcessaEDevolveUmTipo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

@RunWith(JUnit4.class)
public class Lambdatest {

    @Test
    public void lambda() {

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

    }


    @Test
    public void IFRecebeParametroEProcessaAlgo(){

        // interface funcional Consumer, recebe parametro, e processa algo || void accept(T t);
        imprimir(Arrays.asList("vamos l�!", "Casa branca", "vaaai lakers"), (String x) -> System.out.println(x));

    }

    private <T> void imprimir(List<T> list, Consumer<T> c){
        list.forEach( x -> c.accept(x) );
    }

    @Test
    public void IFRecebeParametroProcessaAlgoERetornaAlgo(){

        // interface funcional Function, recebe parametro, processa algo e devolve um tipo || R apply(T t);
        var map = map(Arrays.asList("vamos l�!", "Casa branca", "vaaai lakers"), (String x) -> x.length());
        map.forEach(System.out::println);
    }

    private <T, R> List<R> map(List<T> list, Function<T, R> function){
        List<R> lsReturn = new ArrayList<>();

        list.forEach( x -> {
            lsReturn.add(function.apply(x));
        });

        return lsReturn;
    }

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

}
