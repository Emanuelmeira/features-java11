package estudos.estruturadados.lista;

public class ListaLigada<T> {

    private Elemento<T> primeiro;
    private Elemento<T> ultimo;
    private int tamanho;

    public ListaLigada(){
        this.tamanho = 0;
    }

    public Elemento<T> getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(Elemento<T> primeiro) {
        this.primeiro = primeiro;
    }

    public Elemento<T> getUltimo() {
        return ultimo;
    }

    public void setUltimo(Elemento<T> ultimo) {
        this.ultimo = ultimo;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public void adicionar(T novoValor){

        var novoElemento = new Elemento<T>(novoValor);
        if(this.primeiro == null && this.ultimo == null ){
            this.primeiro = novoElemento;
            this.ultimo = novoElemento;
        }else {
            this.ultimo.setProximo(novoElemento);
            this.ultimo = novoElemento;
        }

        this.tamanho++;
    }

    public void remover(T valorProcurado){
        var atual = this.primeiro;
        Elemento<T> anterior = null;

        for(int i=0; i<this.tamanho; i++){

            if(atual.getValor().equals(valorProcurado)) {

                if (atual == this.primeiro && atual == this.ultimo) {
                    this.primeiro = null;
                    this.ultimo = null;
                    this.tamanho--;
                    break;
                }

                if (atual == this.primeiro) {
                    this.primeiro = atual.getProximo();
                    atual = null;
                    this.tamanho--;
                    break;

                } else if (atual == this.ultimo) {

                    this.ultimo = anterior;
                    this.ultimo.setProximo(null);
                    atual = null;
                    this.tamanho--;
                    break;

                } else {

                    anterior.setProximo(atual.getProximo());
                    atual = null;
                    this.tamanho--;
                    break;
                }
            }

            anterior = atual;
            atual = atual.getProximo();
        }
    }

    public Elemento<T> get(int posicao){
        var atual = this.primeiro;

        for(int i=0; i<posicao; i++){

            if(atual.getProximo() != null){
                atual = atual.getProximo();
            }else{
                atual = null;
            }
        }
        return  atual;
    }

    public InteratorListaLigada<T> getInterator(){
        return new InteratorListaLigada<T>(this.primeiro);
    }

    public void imprimi(String msg){
        var atual = this.primeiro;

        System.out.println(msg);
        for(int i=0; i< this.getTamanho(); i++){
            System.out.println( atual.getValor());
            atual = atual.getProximo();
        }
    }


}
