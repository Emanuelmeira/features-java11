package solid.s.exemplo.basefuncionario;

import solid.s.exemplo.Funcionario;
/**
 * class que tem a RESPONSABILIDADE de BUSCAR um funcionario
 *
 */
public class BuscaFuncionario {


    public Funcionario buscar(int id) {
        System.out.println("Buscando funcionario com id:"+ id);
        //verifica se encontrou um funcionario e lança exception
        return new Funcionario();
    }
}
