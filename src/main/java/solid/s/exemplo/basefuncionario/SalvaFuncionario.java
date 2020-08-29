package solid.s.exemplo.basefuncionario;

import solid.s.exemplo.Funcionario;

import java.util.Random;

/**
 * class que tem a RESPONSABILIDADE de SALVAR um funcionario
 *
 */
public class SalvaFuncionario {


    public Funcionario salva(Funcionario fun){

        fun.setId(new Random().nextInt());
        System.out.println("Salvando funcionario com nome:"+ fun.getNome() +"e id: "+fun.getId());
        return fun;
    }

}
