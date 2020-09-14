package solid.o.calculasalario;


import solid.o.interfaces.IFuncionario;

public class CalculaSalarioService {

    public double calculaSalario(IFuncionario funcionario){

        return funcionario.calculaSalario();
    }

}
