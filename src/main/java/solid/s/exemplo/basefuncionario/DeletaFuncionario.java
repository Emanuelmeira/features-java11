package solid.s.exemplo.basefuncionario;

import solid.s.exemplo.Funcionario;
/**
 * class que tem a RESPONSABILIDADE de DELETAR um funcionario
 *
 */
public class DeletaFuncionario {


    public void deleta(Funcionario funcionario) {
        System.out.println("Deletando funcionario com id:"+ funcionario.getId());
    }
}
