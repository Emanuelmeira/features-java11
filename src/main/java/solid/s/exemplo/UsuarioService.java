package solid.s.exemplo;

import solid.s.exemplo.basefuncionario.BuscaFuncionario;
import solid.s.exemplo.basefuncionario.DeletaFuncionario;
import solid.s.exemplo.basefuncionario.EditaFuncionario;
import solid.s.exemplo.basefuncionario.SalvaFuncionario;
import solid.s.exemplo.validacao.ValidaFuncionario;

public class UsuarioService {

    private ValidaFuncionario validaFuncionario;
    private SalvaFuncionario salvaFuncionario;
    private EditaFuncionario editaFuncionario;
    private BuscaFuncionario buscaFuncionario;
    private DeletaFuncionario deletaFuncionario;
    private DesativaFuncionario desativaFuncionario;

    public Funcionario salva(Funcionario funcionario) {

         validaFuncionario.validaParaSalvar(funcionario);
         return salvaFuncionario.salva(funcionario);
    }

    public Funcionario edita(Funcionario funcionario) {
        validaFuncionario.validaParaEditar(funcionario);
        return editaFuncionario.edita(funcionario);
    }

    public Funcionario busca(int id){
        return buscaFuncionario.buscar(id);
    }

    public void deleta(int id) {
        var funcionario = this.busca(id);
        validaFuncionario.validaParaDeletar(funcionario);
        deletaFuncionario.deleta(funcionario);
    }

    public void desativar(int id)  {
        var funcionario = this.busca(id);
        validaFuncionario.validaParaDesativar(funcionario);
        desativaFuncionario.desativa(funcionario);
    }

}
