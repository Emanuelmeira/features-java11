package solid.o.calculasalario;

public class OCPTeste {

    static  CalculaSalarioService calculaSalarioService = new CalculaSalarioService();

    public static void main(String[] args) {
        var salario = calculaSalarioService.calculaSalario(new CalculaSalarioFuncionario());
        System.out.println(salario);
    }

}
