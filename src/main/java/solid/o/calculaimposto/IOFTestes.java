package solid.o.calculaimposto;

import solid.o.interfaces.IImposto;

import java.time.LocalDate;

public class IOFTestes {

    public static void main(String[] args) {
        calculaImposto(new CalculaICMS());
    }

    public static void calculaImposto(IImposto imposto){
        var impostoCalculado = imposto.calcula(LocalDate.of(2007, 5, 12));
        System.out.println(impostoCalculado);
    }
}
