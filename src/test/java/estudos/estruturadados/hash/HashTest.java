package estudos.estruturadados.hash;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.HashMap;
import java.util.Hashtable;

@RunWith(JUnit4.class)
public class HashTest {

    @Test
    public void hash(){

        //Tem o mesmo comportamento de Tabela Hash, porem o uso pode variar devido a caracteristicas proprias

        //HashMap                                               HashTable
        //Não Thread safe                                       Thread safe internamente
        //Rapido                                                Lento
        //Permite chaves e valores nulos                        Nao Permite chaves ou valores nulos
        //Permite criar um objeto Thread safe
        //    Collections.synchronizedMap(new HashMap<>());

        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(null, null);
        hashMap.put(1, null);
        hashMap.put(null, "oi");

        Hashtable<Integer,String> hashtable = new Hashtable<>();
        hashtable.put(1, "oi");
        hashtable.put(null, "oi"); // lança um erro
    }
}
