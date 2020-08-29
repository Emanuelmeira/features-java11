package solid.s.calculo;

import java.util.stream.Stream;

public class SRPPrincinpal {
    public static void main(String[] args) {

        Stream.of(Flags.values()).forEach(x -> {
            System.out.println(x.regraDeCalculo.calcula(1));
        });


    }
}
