package solid.s.acoplamento.novo;

import solid.s.acoplamento.antigo.Fatura;
import solid.s.acoplamento.antigo.NotaFiscal;

import java.util.List;

public class GeradorDeNotaFiscal {

    //devemos programar para interfaces e não para implementações
    //Classes devem depender de interfaces e não de classes concretas
    //A class passa a depender de interfaces
    private final List<AcoesPosCriacaoDaNota> acoesPosCriacaoDaNotaList;

    public GeradorDeNotaFiscal(List<AcoesPosCriacaoDaNota> acoesPosCriacaoDaNotaList) {
        this.acoesPosCriacaoDaNotaList = acoesPosCriacaoDaNotaList;
    }

    public void gera(Fatura fatura){
        var valor = fatura.valor;

        var nf = new NotaFiscal(valor, this.calculaImpostoSimples(valor));

        acoesPosCriacaoDaNotaList.stream()
                                 .forEach(acao -> acao.executar(fatura));

    }

    private Double calculaImpostoSimples(Double valor) {
        return valor * 0.5;
    }


}
