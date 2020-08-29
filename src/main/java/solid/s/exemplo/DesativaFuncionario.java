package solid.s.exemplo;

/**
 * Class responsavel por desativaro  funcionario
 *
 */
public class DesativaFuncionario {

    public void desativa(Funcionario funcionario) {
        funcionario.setAtivo(false);
        System.out.println("Desativnado funcionario com id:"+ funcionario.getId());
    }

}
