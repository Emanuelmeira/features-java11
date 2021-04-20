package estudos.estruturadados.arvorebinaria;

public class Ramo<T> {

    private T valor;
    private Ramo<T> esquerda;
    private Ramo<T> direita;

    public Ramo<T> getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(Ramo<T> esquerda) {
        this.esquerda = esquerda;
    }

    public Ramo<T> getDireita() {
        return direita;
    }

    public void setDireita(Ramo<T> direita) {
        this.direita = direita;
    }

    public Ramo(T valor) {
        this.valor = valor;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }
}
