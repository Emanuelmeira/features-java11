package estudos.estruturadados.lista;

public class InteratorListaLigada<T> {

    private Elemento<T> elemento;

    public InteratorListaLigada(Elemento<T> atual) {
        this.elemento = atual;
    }

    public boolean temProximo(){
        if(this.elemento.getProximo() != null){
            return true;
        }else {
            return false;
        }
    }

    public Elemento<T> getProximo(){
        this.elemento = this.elemento.getProximo();
        return this.elemento;
    }

}
