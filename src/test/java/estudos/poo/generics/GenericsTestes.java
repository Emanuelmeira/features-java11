package estudos.poo.generics;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class GenericsTestes {

    @Test
    public void generics(){

        EnviarParaAPI<Integer> enviarParaAPI = new EnviarParaAPI<>();
        if(enviarParaAPI.ativo()){
            enviarParaAPI.enviar(10, 20);
        }
    }

    class EnviarParaAPI<T extends Comparable> implements Autorizacao{

        public void enviar(T objParaEnviar1, T objParaEnviar2){

            if(objParaEnviar1.compareTo(objParaEnviar2) == 1){
                System.out.println("enviando.. " + objParaEnviar1);

            }else if(objParaEnviar1.compareTo(objParaEnviar2) == -1){
                System.out.println("enviando.. " + objParaEnviar2);
            }else {
                System.out.println("enviando.. " + objParaEnviar1);
                System.out.println("e enviando.. " + objParaEnviar2);
            }
        }

        public boolean ativo() {
            return true;
        }
    }

    interface Autorizacao{
        boolean ativo();
    }

}
