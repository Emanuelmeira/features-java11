package solid.s.acoplamento.antigo;

import solid.s.acoplamento.novo.AcoesPosCriacaoDaNota;

public class EnviardorDeEmail implements AcoesPosCriacaoDaNota {

    @Override
    public void executar(Fatura fatura) {

        System.out.println("Enviando Email");

    }
}
