package estudos.logica;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.validator.ValidateWith;

import java.sql.SQLOutput;

@RunWith(JUnit4.class)
public class LogicaTestes {

    String a;
    @Test
    public void fibonacci() {

        // 0 e 1, vêm 1, 2, 3, 5, 8, 13, 21, 34

        int fibo = 1;
        int anterior = 0;
        for(int i=0; i<10; i++){

            fibo = anterior + fibo;
            System.out.println(fibo);
            anterior = fibo-anterior;
        }
    }

    @Test
    public void fatorial() {

        //4! = 4 · 3 · 2 · 1 = 24
        //5! = 5 · 4 · 3 · 2 · 1= 120

        int result = 1;
        for(int i=0; i<=5; i++){

            int fat = i;
            while (fat >= 1){

                result = result * fat;
                --fat;
            }
            System.out.println(i+"! = "+result);
            result=1;
        }
    }





}
