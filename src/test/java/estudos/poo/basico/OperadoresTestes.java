package estudos.poo.basico;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class OperadoresTestes {

    @Test
    public void operadoresAritimeticos(){

        int resultado = 11 % 2;
        System.out.println("Resto da divisão: " +resultado);

        //primeiro a multiplicação, depois a divisão NA ORDEM EM QUE ELAS ESTAO
        //depois soma e subitração NA ORDEM EM QUE ELAS ESTAO

        resultado = 1 + 1 - 2 * 2 / 2;
        System.out.println(resultado); // 0

        resultado = 1 + 1 - 2 * 2 / 2;
        System.out.println(resultado); // 0

        resultado = 1 + 1 * 2 / 2 + 2;
        System.out.println(resultado); // 4

        resultado = 1 + 1 * (2 / 2) + 2;    // prioridade em resolver a equação entre ()
        System.out.println(resultado); //4

        resultado = 2 * 5 - 4;
        System.out.println(resultado); // 6

        resultado = 2 * (5 - 4); // prioridade em resolver a equação entre ()
        System.out.println(resultado); // 2

        resultado = 5 / 2;    //o calculo envolvendo 2 numeros inteiros. sempre retorna um numero
        System.out.println(resultado);  //2
    }

    @Test
    public void operadoresAritimeticos2(){

    }

    @Test
    public void incremento(){
        int aux = 0;
        System.out.println(aux++); // primeiro é utilizada a variavel DEPOIS seu valor é incrementado
        System.out.println(++aux); // primrio é incrementada a variavel e DEPOIS ela é usada

        System.out.println("-1---------------------");

        int valor = 0;
        aux = valor++;
        System.out.println(aux);
        aux = ++valor;
        System.out.println(aux);
    }

    @Test
    public void operadorLogico(){

        int valor1 = 1;
        int valor2 = 2;

        //ao usar o && duplo é feita a verificação na primeira parte da expressão.. e sendo falsa, nem verifica a segunda parte
        System.out.println("(valor1 == valor2 && valor1 <= valor2): " + (valor1 == valor2 && valor1 <= valor2));
        System.out.println("(valor1 == valor2 || valor1 <= valor2): " + (valor1 == valor2 || valor1 <= valor2));

        //ao usar o & simples é feita a verificação nos 2 lados da expressão.. mesmo a primeira opção sendo falsa
        System.out.println("(valor1 == valor2 & valor1 <= valor2): " + (valor1 == valor2 & valor1 <= valor2));

        // ^ XOR - falso quando se obtem dois resultados IGUAIS (++ ou --)
        System.out.println("(valor1 == valor2 ^ valor1 <= valor2): " + (valor1 == valor2 ^ valor1 <= valor2));

    }

    @Test
    public void operadorRelacional(){

        int valor1 = 1;
        int valor2 = 2;

        System.out.println("valor1 == valor2: " + (valor1 == valor2));
        System.out.println("valor1 != valor2: " + (valor1 != valor2));
        System.out.println("valor1 > valor2: " + (valor1 > valor2));
        System.out.println("valor1 >= valor2: " + (valor1 >= valor2));
        System.out.println("valor1 < valor2: " + (valor1 < valor2));
        System.out.println("valor1 <= valor2: " + (valor1 <= valor2));

    }

}
