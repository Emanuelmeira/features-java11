package solid.o.calculasalario;

import solid.o.interfaces.IFuncionario;

public class CalculaSalarioFuncionario implements IFuncionario {

    @Override
    public double calculaSalario() {
        return 2500.0;
    }
}
