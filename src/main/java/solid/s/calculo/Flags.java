package solid.s.calculo;


public enum  Flags {
    STIK(new CalculaRegraStik()),
    LIC(new CalculaRegraFlag());

    public RegraDeCalculo regraDeCalculo;

    Flags(RegraDeCalculo regraDeCalculo){
        this.regraDeCalculo = regraDeCalculo;
    }
}
