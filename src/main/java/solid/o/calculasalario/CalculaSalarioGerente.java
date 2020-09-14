package solid.o.calculasalario;

import solid.o.interfaces.IFuncionario;

public class CalculaSalarioGerente implements IFuncionario {

    @Override
    public double calculaSalario() {
        return 5000.0;
    }
}
