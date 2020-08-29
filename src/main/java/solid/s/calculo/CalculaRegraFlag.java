package solid.s.calculo;

public class CalculaRegraFlag implements RegraDeCalculo {

    @Override
    public Double calcula(int origem) {

        if(origem == 1){
            return 20.0;
        }
        return 0.0;
    }
}
