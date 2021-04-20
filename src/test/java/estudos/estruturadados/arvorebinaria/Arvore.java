package estudos.estruturadados.arvorebinaria;

import java.util.Objects;

public class Arvore<T extends  Comparable> {

    private Ramo<T> raiz;

    public Arvore(){
        this.raiz = null;
    }

    public Ramo<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(Ramo<T> raiz) {
        this.raiz = raiz;
    }

    public void adicionar(T valor){
            Ramo<T> novoRamo = new Ramo(valor);

            if(raiz == null){
                this.raiz = novoRamo;
            }else{
                //Se o elemento for MENOR sera adc a esquerda, se for MAIOR sera adc a direita
                var atual  = this.raiz;
                while (true) {
                    if (novoRamo.getValor().compareTo(atual.getValor()) == -1) { //valor menor que o comparado
                        if (atual.getEsquerda() != null) {
                            atual = atual.getEsquerda();
                        } else {
                            atual.setEsquerda(novoRamo);
                            break;
                        }

                    }else{ // se o elemento for maior ou igual
                        if(atual.getDireita() != null){
                            atual = atual.getDireita();
                        }else{
                            atual.setDireita(novoRamo);
                            break;
                        }
                    }
                }
            }
    }

    public boolean remover(T valor){

        //buscar o elemento da arvore
        Ramo<T> atual = this.raiz;
        Ramo<T> paiAtual = null;

        while (Objects.nonNull(atual)){
            if(atual.getValor().equals(valor)){
                break;
            }else if(valor.compareTo(atual.getValor()) == -1){ // valor buscado menor que o atual
                paiAtual = atual;
                atual = atual.getEsquerda();
            }else{
                paiAtual = atual;
                atual = atual.getDireita();
            }
        }

        if(Objects.nonNull(atual)){

            //se elemento tem 2 filhos ou somente filho a direita
            if(Objects.nonNull(atual.getDireita()) ){ //filho só a direita

                //deve ir para Direita do nó e depois seguir SEMPRE a esquerda
                Ramo<T> substituto = atual.getDireita();
                Ramo<T> paiSubstituto = atual;

                while (substituto.getEsquerda() != null){
                    paiSubstituto = substituto;
                    substituto = substituto.getEsquerda();
                }

                substituto.setEsquerda(atual.getEsquerda());

                if(paiAtual != null) {
                    //setando o valor encontrado na posição
                    if (atual.getValor().compareTo(paiAtual.getValor()) == -1) { //atual menor que paiAtual
                        paiAtual.setEsquerda(substituto);
                    } else {
                        paiAtual.setDireita(substituto);
                    }
                }else { //se não tem paiAtual então é a raiz
                    this.raiz = substituto;
                }

                //removeu o elemento da arvore
                if(substituto.getValor().compareTo( paiSubstituto.getValor() ) == -1){ //substituto menor que paiSubstituto
                    paiSubstituto.setEsquerda(null);
                }else{
                    paiSubstituto.setDireita(null);
                }

            }else if(Objects.nonNull(atual.getEsquerda()) ){ //filho só a esquerda
                    //deve ir para esquerda do nó e depois seguir SEMPRE a direita, para encontrar o maior elemento
                    Ramo<T> substituto = atual.getEsquerda();
                    Ramo<T> paiSubstituto = atual;

                    while (substituto.getDireita() != null){
                        paiSubstituto = substituto;
                        substituto = substituto.getDireita();
                    }

                substituto.setDireita(atual.getDireita());

                    if(paiAtual != null) {
                        //setando o valor encontrado na posição
                        if (atual.getValor().compareTo(paiAtual.getValor()) == -1) { //atual menor que paiAtual
                            paiAtual.setEsquerda(substituto);
                        } else {
                            paiAtual.setDireita(substituto);
                        }
                    }else{//se não tem paiAtual então é a raiz
                        this.raiz = substituto;
                    }

                    //removeu o elemento da arvore
                if(substituto.getValor().compareTo( paiSubstituto.getValor() ) == -1){ //substituto menor que paiSubstituto
                    paiSubstituto.setEsquerda(null);
                }else{
                    paiSubstituto.setDireita(null);
                }

            }else { //elemento sem filhos

                if(paiAtual != null) {
                    if (atual.getValor().compareTo(paiAtual.getValor()) == -1) { //atual menor que paiAtual
                        paiAtual.setEsquerda(null);
                    } else {
                        paiAtual.setDireita(null);
                    }
                }else { // o elemento a ser removido é a raiz
                    this.raiz = null;
                }
            }

            return true;
        }else{
            return false;
        }
    }
    public void emOrdem(Ramo<T> atual){
        if(atual != null){
            emOrdem(atual.getEsquerda());
            System.out.println(atual.getValor());
            emOrdem(atual.getDireita());
        }
    }

    public void preOrdem(Ramo<T> atual){
        if(atual != null){
            System.out.println(atual.getValor());
            preOrdem(atual.getEsquerda());
            preOrdem(atual.getDireita());
        }
    }

    public void posOrdem(Ramo<T> atual){
        if(atual != null){
            posOrdem(atual.getEsquerda());
            posOrdem(atual.getDireita());
            System.out.println(atual.getValor());
        }
    }
}
