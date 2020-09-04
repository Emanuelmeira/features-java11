package solid.s.acoplamento.antigo;

public class GeradorDeNotaFiscal {

    private final EnviardorDeEmail  enviardorDeEmail;
    private final NotaFiscalDao notaFiscalDao;

    public GeradorDeNotaFiscal(EnviardorDeEmail enviardorDeEmail, NotaFiscalDao notaFiscalDao) {
        this.enviardorDeEmail = enviardorDeEmail;
        this.notaFiscalDao = notaFiscalDao;
    }

    public void gera(Fatura fatura){
        var valor = fatura.valor;

        var nf = new NotaFiscal(valor, this.calculaImpostoSimples(valor));

        //enviardorDeEmail.enviaEmail(nf);
        //notaFiscalDao.salva(nf);
    }

    private Double calculaImpostoSimples(Double valor) {

        return valor * 0.5;
    }


}
