package estudos.poo.basico.auxiliar;

public class Pizza {
    private String sabor;
    public static int qtdPizzaVendidas;

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public static double calculaPreco(double valor){
        //realizar processamento
        return valor * 2;
    }

    public static void setQtdPizzaVendidas(int qtdPizzaVendidas) {
        Pizza.qtdPizzaVendidas = qtdPizzaVendidas;
    }
}
