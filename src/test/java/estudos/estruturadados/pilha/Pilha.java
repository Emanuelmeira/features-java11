package estudos.estruturadados.pilha;

import estudos.estruturadados.lista.ListaLigada;


public class Pilha<T> {

    private ListaLigada<T> fila = new ListaLigada<>();

    public void adicionar(T valor){
        this.fila.adicionarComeco(valor);
    }

    public void remover(){
        this.fila.remover(this.get());
    }

    public T get(){
        return this.fila.getPrimeiro().getValor();
    }
}
