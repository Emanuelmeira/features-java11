package solid.s.exemplo.basefuncionario;

import solid.s.exemplo.Funcionario;

import java.util.Random;
/**
 * class que tem a RESPONSABILIDADE de EDITAR um funcionario
 *
 */
public class EditaFuncionario {


    public Funcionario edita(Funcionario fun) {
        System.out.println("Editando funcionario com nome:"+ fun.getNome() +"e id: "+fun.getId());
        return fun;
    }


}
