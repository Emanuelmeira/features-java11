package estudos.optional;

import estudos.stream.PersonStream;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

@RunWith(JUnit4.class)
public class OptionalPrincipal {

        /**
         * Evitar erros NullPointerException.
         * Parar de fazer verificações de valor nulo do tipo if (cliente != null).
         * Escrever código mais limpo e elegante.
         *
         * ** Usado para retorno de metodo que PODE retornar null
         *
         * Guia https://medium.com/@racc.costa/optional-no-java-8-e-no-java-9-7c52c4b797f1
         */

    @Test
    public void optionalWithOrElse(){

        Optional<Integer> optNum= this.convertToInteger("17");
        System.out.println(optNum.orElse(0)); //caso o valor volte empty, posso trabalhar com o valor padrão, caso contrario imprimo a resposta

        Optional<Integer> optEmpty = this.convertToInteger("abc");
        System.out.println(optEmpty.orElse(0));

        System.out.println("Chamando Operação complexa no orElseGet: -> " +optEmpty.orElseGet(() -> operacaoComplexa())); //Diferente do "orElse" esse metodo aceita um lambda podendo realizar uma operação mais complexa

        try{
            System.out.println(optEmpty.orElseThrow(() -> new NullPointerException()) ); //Caso o valor seja null, uma exception é lançada acabando o fluxo
        }catch (Exception e){}

    }

    @Test
    public void whatDifferenceBetweenOrElseAndOrElseGet(){

        /**
         * orElse () sempre chamará a função dada, quer você queira ou não, independentemente do valor Optional.isPresent()
         * orElseGet () só chama a função dada quando a Optional.isPresent() == false
         */

        Optional<Integer> optNum = this.convertToInteger("17");
        System.out.println(optNum.orElse(operacaoComplexa())); // Mesmo o Optional tendo valor, o metodo operacaoComplexa() é chamado

        Optional<Integer> optValue = this.convertToInteger("200");
        System.out.println(optValue.orElseGet(() -> operacaoComplexa())); // Já para o orElseGet, um Optional tendo valor, a função operacaoComplexa() não é chamada

    }

    @Test
    public void optionalWithIfPresent(){
        Stream.of(1,2,3,4,5)
                .findFirst()
                .ifPresent(n -> System.out.println(n)); //Caso valor exista a ação é acionada, metodo aceita um lambda

        Stream.of(1,2,3,4,5)
                .filter(n -> n == 10)
                .findFirst()
                .ifPresentOrElse(n -> System.out.println("Valor encontrado: " +n), ()-> new Exception("valor não encontrado"));
                //Caso valor exista a primeira condição é acionada, caso não exista, a segunda parte é ativada, metodo aceita dois lambdas

        boolean isPresent = Stream.of(1,2,3,4,5)
                                .filter(x -> x == 3)
                                .findFirst()
                                .isPresent(); //retorna true caso exista valor no Optional

        System.out.println("Valor presente: "+ isPresent);

    }

    @Test
    public void optionalWithMap(){

        Optional.of(10)
                .map(String::valueOf) // uma transformação com map pode ser realizada caso o valor exista
                .ifPresent(n -> System.out.println("Tipo de class transformada: "+n.getClass()));

        Optional.of("Usar Optional não é Optional.")
                .map(String::toUpperCase) // uma transformação com map pode ser realizada caso o valor exista
                .ifPresent(n -> System.out.println("Aplicando toUpperCase em frase : "+n ));

    }

    @Test
    public void optionalWithFlatMap(){

        Stream.of(asList(1, 2), asList(3, 4))
                .flatMap(List::stream)  //flatMap pode mesclar as duas listas contidas na lista principal
                .map(integer -> integer + 1) // somando +1 a cada elemento da lista princinpal (mesclada)
                .forEach(System.out::println);
    }

    @Test
    public void optionalWithPrimitiveTypes(){

        // é possivel criar um Optional de tipo primitivo específico

        OptionalInt optInt = OptionalInt.of(Integer.parseInt("12"));
        optInt.ifPresent(n -> System.out.println("OptionalInt presente: " + n));

        OptionalDouble optDouble = OptionalDouble.of(Double.parseDouble("1132.1"));
        optDouble.ifPresent(n -> System.out.println("OptionalDouble presente: " + n));
    }

    @Test
    public void optionalWithOr(){

       // or é invocado quando a primeira condição não traz resultado (Optional.empty())
       // a segunda opção é iniciada e retorna um Optional q pode contar ou não valor

       // utilizando primeira condição
       Optional<Integer> optValue = this.convertToInteger("00000")
                                        .or(() -> convertToInteger("abc"));
       optValue.ifPresent(n -> System.out.println( "Usando primeira condição: " + n));

       //utilizando segunda condição
       Optional<Integer> optNum = this.convertToInteger("abc")
                                      .or(() -> convertToInteger("9999"));
       optNum.ifPresent(n -> System.out.println( "Usando segunda condição: " + n));

    }

    @Test
    public void optionalOfNullable(){

        Optional.ofNullable(PersonStream.getList()).orElseGet(ArrayList::new)
                .stream()
                .forEach(x -> System.out.println("Nome: ".concat(x.name) ));
    }

    @Test
    public void optionalOfNulAAAlable(){

        try{
            var a = Long.parseLong("");
            System.out.println(a);

            //return Optional.of(numConvert); //"Optional.of()" Não permite o uso de valor null
            //Optional.ofNullable(numConvert); //"Optional.ofNullable()" Permite o uso de valor null, o resultado é um "Optional.empty()"


        }catch (Exception e){
            System.out.println(e.getCause());
        }
    }


    public Optional<Integer> convertToInteger(String num){

        try{
            Integer numConvert = Integer.valueOf(num);
            //return Optional.of(numConvert); //"Optional.of()" Não permite o uso de valor null
            return Optional.ofNullable(numConvert); //"Optional.ofNullable()" Permite o uso de valor null, o resultado é um "Optional.empty()"
        }catch (Exception e){
            return Optional.empty();
        }
    }

    public Integer operacaoComplexa(){
        System.out.println("Operação complexa realizada!");
        return 99;
    }

}
