package solid.s.calculo;

public class CalculaRegraStik implements RegraDeCalculo{

    @Override
    public Double calcula(int origem) {

        if(origem == 0){
            return 10.0;
        }

        return 0.0;
    }
}
