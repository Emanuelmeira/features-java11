package estudos.poo.interfaces;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class InterfacesTeste {

    @Test
    public void impressora() {
        //Interfaces são "contrato", onde a class que implementa a mesma, deve implementa os metodos exigidos por ela

        var impressoraEpson5542 = new ImpressoraEpson5542();
        if(impressoraEpson5542.ativa()){
            impressoraEpson5542.imprimi("A vida é bela..");
        }else {
            System.out.println("Impressora não esta funcionando");
        }

        var impressoraMaxPrint5841 = new ImpressoraMaxPrint5841();
        if(impressoraMaxPrint5841.ativa()){
            impressoraMaxPrint5841.imprimi("A vida é bela..");
        }else {
            System.out.println("Impressora MaxPrint não esta funcionando");
        }

    }

    interface Impressora{
        void imprimi(String texto);
        default boolean ativa(){
            return true;
        }

        //interfaces podem ter metodos staticos com corpo java8+
        static void contador() {

        }
    }

    interface ImpressoraMultifuncional{
        void imprimi(String texto);
        void copia(Object documento);
        void scaneia(Object documento);
        default boolean ativa(){ // java 8+
            return false;
        }
    }

    class ImpressoraEpson5542 implements Impressora{

        @Override
        public void imprimi(String texto) {
            System.out.println("Imprimindo.." + texto);
        }

    }

    class ImpressoraMaxPrint5841 implements ImpressoraMultifuncional{

        @Override
        public void imprimi(String texto) {
            System.out.println("Imprimindo.." + texto);
        }

        @Override
        public void copia(Object documento) {
            System.out.println("Copiando documento..");
        }

        @Override
        public void scaneia(Object documento) {
            System.out.println("Scaneia documento..");
        }
    }

}
