package solid.s.exemplo.validacao;

import solid.s.exemplo.Funcionario;

import java.util.Objects;

/**
 * Class responsavel por validar ações sobre o funcionario
 */
public class ValidaFuncionario {


    public void validaParaSalvar(Funcionario funcionario)  {

        if(Objects.isNull(funcionario.getNome())) {
            throw new RuntimeException("Funcionario sem nome");
        }

        if(Objects.isNull(funcionario.getIdade())) {
            throw new RuntimeException("Funcionario sem idade");
        }

    }

    public void validaParaEditar(Funcionario funcionario)  {

        if(Objects.isNull(funcionario.getId())) {
            throw new RuntimeException("Funcionario sem Id");
        }

        if(Objects.isNull(funcionario.getNome())) {
            throw new RuntimeException("Funcionario sem nome");
        }

        if(Objects.isNull(funcionario.getIdade())) {
            throw new RuntimeException("Funcionario sem idade");
        }
    }

    public void validaParaDeletar(Funcionario funcionario)  {

        if(funcionario.isAtivo()){
            throw new RuntimeException("Funcionario deve estar desativado para ser deletado.");
        }

    }

    public void validaParaDesativar(Funcionario funcionario)  {

        if(!funcionario.isAtivo()){
            throw new RuntimeException();
        }

    }

}
