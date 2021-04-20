package estudos.estruturadados.fila;

import estudos.estruturadados.lista.ListaLigada;

public class Fila<T> {
    private ListaLigada<T> fila = new ListaLigada<>();

    public void adicionar(T valor){
        this.fila.adicionar(valor);
    }

    public void remover(){
        this.fila.remover(this.get());
    }

    public T get(){
        //obter primeiro elemento da fila
        return this.fila.getPrimeiro().getValor();
    }
}
