package solid.o.calculaimposto;

import solid.o.interfaces.IImposto;

import java.time.LocalDate;
import java.util.Objects;

public class CalculaICMS implements IImposto {

    @Override
    public double calcula(LocalDate dataCorte) {

        var data = LocalDate.of(2005, 5, 05);

        if(Objects.nonNull(dataCorte) && dataCorte.isBefore( data )){
            return 0;
        }

        return 10.0;
    }
}
