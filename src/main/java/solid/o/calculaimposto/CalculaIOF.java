package solid.o.calculaimposto;

import solid.o.interfaces.IImposto;

import java.time.LocalDate;
import java.util.Objects;

public class CalculaIOF implements IImposto {

    @Override
    public double calcula(LocalDate dataCorte) {

        var data = LocalDate.of(2010, 8, 20);

        if(Objects.nonNull(dataCorte) && dataCorte.isBefore( data )){
            return 2000.0;
        }
        return 0;
    }
}
