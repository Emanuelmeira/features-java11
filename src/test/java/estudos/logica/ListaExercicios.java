package estudos.logica;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.time.LocalDate;
import java.util.Scanner;

@RunWith(JUnit4.class)
public class ListaExercicios {

    @Test
    public void exec2() {

//        int a = 30;
//        int b = 20;
//        int c = a+b;
//
//        System.out.println(c);
//        b = 10;
//        System.out.println(b +" "+c);
//        c = a+b;
//        System.out.println(a+" "+b+" "+c);


//        int a = 0;
//        int b = 0;
//        int c = 0;
//
//        a = 10;
//        b = 20;
//        c = a;
//        b = c;
//        a = b;
//
//        System.out.println(a+" "+b+" "+c);

//        int a = 10;
//        int b = a+1;
//        a = b+1;
//        b = a+1;
//
//        System.out.println(a);
//        a = b+1;
//        System.out.println(a+" "+b);

//        int a = 10;
//        int b = 5;
//        int c = a+b;
//        b = 20;
//        a = 10;
//
//        System.out.println(a+" "+b+" "+c);

//        int x = 1;
//        int y = 2;
//        int z = y-x;
//
//        System.out.println(z);
//        x = 5;
//        y = x +z;
//        System.out.println(x+" "+y +" "+z);

    }

    @Test
    public void exe3() {

        int a1 = (4 / 2) + (2 / 4);  // a1 = 2
        int a2 = 4 / 2 + 2 / 4;      // a2 = 2
        System.out.println(a1 + " = " + a2);

        int b1 = 4 / (2 + 2) / 4;  //  b1 = 0
        int b2 = 4 / 2 + 2 / 4;    //  b2 = 2
        System.out.println(b1 + " = " + b2);

        int c1 = (4 + 2) * 2 - 4; // c1 = 8
        int c2 = 4 + 2 * 2 - 4;   // c2 = 4
        System.out.println(c1 + " = " + c2);
    }

    @Test
    public void exe4() {

        // adequar a equação sem resolver nenhum calculo

        int valor = 6 * (3 + 2);
        System.out.println("A " + valor); // não é possivel remover nenhum ()

        int b = 2 + (6 * (3 + 2));
        System.out.println("B " + b);
        b = 2 + 6 * (3 + 2);   // removi 1 ()
        System.out.println("B " + b);

        int c = 2 + (3 * 6) / (2 + 4); // 5
        System.out.println("C " + c); // não é possivel remover nenhum ()

        int d = 2 * (8 / (3 + 1)); //4
        System.out.println("D " + d);
        d = 2 * 8 / (3 + 1);    // removi 1 ()
        System.out.println("D " + d);

        int e = 3 + (16 - 2) / (2 * (9 - 2)); //4
        System.out.println("E " + e); // não é possivel remover nenhum ()

        int f = (6 / 3) + (8 / 2);
        System.out.println("F " + f);
        f = 6 / 3 + 8 / 2;         // removi 1 ()
        System.out.println("F " + f);

        int g = ((3 + (8 / 2)) * 4) + (3 * 2);
        System.out.println("G " + g);
        g = ((3 + 8 / 2) * 4) + 3 * 2;    // removi 1 ()
        System.out.println("G " + g);

    }

    @Test
    public void exe5() {
        //precisa ser executado dentro de um metodo main

        //5) Escreva um algoritmo para ler um valor (do teclado) e escrever (na tela) o seu antecessor.

        var scanner = new Scanner(System.in);
        var num = scanner.nextInt();
        System.out.println(--num);
    }

    @Test
    public void exe6() {
        //precisa ser executado dentro de um metodo main

        //6) Escreva um algoritmo para ler as dimensões de um retângulo (base e altura), calcular e escrever a
        //área do retângulo. area = b x h(altura)

        var scanner = new Scanner(System.in);
        int base = scanner.nextInt();
        int altura = scanner.nextInt();

        int area = base * altura;

        System.out.println("Area do retângulo: " + area);
    }

    @Test
    public void exe7() {
        //precisa ser executado dentro de um metodo main

        //7) Faça um algoritmo que leia a idade de uma pessoa expressa em anos, meses e dias e escreva a idade
        //dessa pessoa expressa apenas em dias. Considerar ano com 365 dias e mês com 30 dias.

        var scanner = new Scanner(System.in);
        int anos = scanner.nextInt(); // obter entrada
        int meses = scanner.nextInt();
        int dias = scanner.nextInt();

        int qtdMeses = anos * 12; // descobrir a quantidade de meses
        qtdMeses = qtdMeses + meses;

        int qtdDias = qtdMeses * 30; // descobrir a quantidade de dias
        qtdDias += dias; // somar com os dias ja informados

        System.out.println("Quantidade de dias: " + qtdDias);
    }

    @Test
    public void exe8() {
        //precisa ser executado dentro de um metodo main

        //8) Escreva um algoritmo para ler o número total de eleitores de um município, o número de votos
        //brancos, nulos e válidos. Calcular e escrever o percentual que cada um representa em relação ao total
        //de eleitores.

        //ref: https://www.youtube.com/watch?v=jAMWhbv-8A0

        //Formula : porcentagem = valorMenor * 100 / valorMaior
        var scanner = new Scanner(System.in);
        int totalEleitores = scanner.nextInt(); // obter entrada
        int votosBrancos = scanner.nextInt();
        int votosNulos = scanner.nextInt();
        int votosValidos = scanner.nextInt();

        int perc = votosBrancos * 100 / totalEleitores;
        System.out.println("Percentual voto Branco: " + perc);
        perc = votosNulos * 100 / totalEleitores;
        System.out.println("Percentual voto Nulo: " + perc);
        perc = votosValidos * 100 / totalEleitores;
        System.out.println("Percentual voto Valido: " + perc);
    }

    @Test
    public void exe9() {

        //precisa ser executado dentro de um metodo main

        //9) Escreva um algoritmo para ler o salário mensal atual de um funcionário e o percentual de reajuste.
        //Calcular e escrever o valor do novo salário.

        var scanner = new Scanner(System.in);
        int salarioAtual = scanner.nextInt(); // obter entrada
        int percReajuste = scanner.nextInt();

        int valorAumento = salarioAtual * percReajuste / 100;
        int novoSalario = salarioAtual + valorAumento;

        System.out.println("Seu novo salario sera: " + novoSalario);
    }

    @Test
    public void exe10() {

        //precisa ser executado dentro de um metodo main

        //10) O custo de um carro novo ao consumidor é a soma do custo de fábrica com a porcentagem do
        //distribuidor e dos impostos (aplicados ao custo de fábrica). Supondo que o percentual do distribuidor
        //seja de 28% e os impostos de 45%, escrever um algoritmo para ler o custo de fábrica de um carro,
        //calcular e escrever o custo final ao consumidor.

        var scanner = new Scanner(System.in);
        int custoFabrica = scanner.nextInt(); // obter entrada

        int valorPercDistribuidor = custoFabrica * 28 / 100; // aplicando % do distribuidor sobre o valor do custo de fabrica
        int valorPercImposto = custoFabrica * 45 / 100; // aplicando % do imposto sobre o valor do custo de fabrica

        int valorTotal = custoFabrica + valorPercDistribuidor + valorPercImposto;
        System.out.println("o carro vai custar no total: " + valorTotal);
    }

    @Test
    public void exe11() {

        // 11) Uma revendedora de carros usados paga a seus funcionários vendedores um salário fixo por mês,
        // mais uma comissão também fixa para cada carro vendido e mais 5% do valor das vendas por ele
        // efetuadas. Escrever um algoritmo que leia o número de carros por ele vendidos, o valor total de suas
        // vendas, o salário fixo e o valor que ele recebe por carro vendido. Calcule e escreva o salário final do
        // vendedor.

        // sala fixo
        // comissoa fixa para cada carro vendido
        // mais 5% do valor das vendas por ele

        var scanner = new Scanner(System.in);
        int qtdCarrosVend = scanner.nextInt(); // obter entradas
        int valorComissaoPorVenda = scanner.nextInt();
        int valorTotalVend = scanner.nextInt();
        int salarioFixo = scanner.nextInt();

        int comissaoTotal = qtdCarrosVend * valorComissaoPorVenda; // obtendo valor total da comissao
        int valorPerc = valorTotalVend * 5 / 100; // obtendo valor a receber do total de vendas efetuadas
        int novoSalario = salarioFixo + comissaoTotal + valorPerc;

        System.out.println("O salario a receber: " + novoSalario);

    }

    @Test
    public void exe12() {

        //12) Escreva um algoritmo para ler uma temperatura em graus Fahrenheit, calcular e escrever o valor
        //correspondente em graus Celsius (baseado na fórmula abaixo):

        //Ex: 100ºC = 212F

        int fahrenheit = 100; // obter entrada
        int celsius = 5 / 9 * (fahrenheit - 32); // aplicar formula
        System.out.println(fahrenheit + " - Convertido para Celsius: " + celsius);
    }

    @Test
    public void exe13() {

        //13) Faça um algoritmo que leia três notas de um aluno, calcule e escreva a média final deste aluno.
        //Considerar que a média é ponderada e que o peso das notas é 2, 3 e 5. Fórmula para o cálculo da média
        //final é:

        // multiplicar cada nota pelo peso definido em cada prova. Somar tudo e dividir pela soma total dos pesos.
        //media ponderada: https://matematicabasica.net/media-ponderada/

        int nota1 = 5;
        int nota2 = 7;
        int nota3 = 6;

        int media = (nota1 * 2 + nota2 * 7 + nota3 * 5) / (2 + 3 + 5);

        System.out.println("Media ponderada: " + media);
    }

    @Test
    public void exe14() {
        //14) Ler um valor e escrever a mensagem É MAIOR QUE 10! se o valor lido for maior que 10, caso
        //contrário escrever NÃO É MAIOR QUE 10!
        //mt simples kkkk
    }

    @Test
    public void exe15() {
        //15) Ler um valor e escrever se é positivo ou negativo (considere o valor zero como positivo).
        //mt simples kkkk
    }

    @Test
    public void exe16() {
        //16) As maçãs custam R$ 1,30 cada se forem compradas menos de uma dúzia, e R$ 1,00 se forem
        //compradas pelo menos 12. Escreva um programa que leia o número de maçãs compradas, calcule e
        //escreva o custo total da compra.

        int qtdMacasComp = 5;
        double valorAPagar;

        if (qtdMacasComp < 12) {
            valorAPagar = qtdMacasComp * 1.30;
        } else {
            valorAPagar = qtdMacasComp * 1.00;
        }

        System.out.println("Valor a pagar: " + valorAPagar);
    }

    @Test
    public void exe17() {
        //17) Ler as notas da 1a. e 2a. avaliações de um aluno. Calcular a média aritmética simples e escrever
        //uma mensagem que diga se o aluno foi ou não aprovado (considerar que nota igual ou maior que 6 o
        //aluno é aprovado). Escrever também a média calculada.

        int nota1 = 5; // obtendo valores
        int nota2 = 3;

        int media = (nota1 + nota2) / 2;

        if (media >= 6) {
            System.out.println("Aprovado!" + media);
        } else {
            System.out.println("Reprovado!" + media);
        }
    }

    @Test
    public void exe18() {

        //18) Ler o ano atual e o ano de nascimento de uma pessoa. Escrever uma mensagem que diga se ela
        //poderá ou não votar este ano (não é necessário considerar o mês em que a pessoa nasceu).
        //voto permitido com 16 anos

        LocalDate anoAtual = LocalDate.now();
        LocalDate anoNascimento = LocalDate.of(1995, 2, 10);

        var idade = anoAtual.getYear() - anoNascimento.getYear();

        if (idade >= 16) {
            System.out.println("pode votar " + idade);
        } else {
            System.out.println("nao pode votar " + idade);
        }
    }

    @Test
    public void exe19() {

        //19) Ler dois valores (considere que não serão lidos valores iguais) e escrever o maior deles.

        int val1 = 5;
        int val2 = 23;

        if (val1 > val2) {
            System.out.println("Valor 1 é maoir");
        } else {
            System.out.println("valor 2 é maior");
        }
    }

    @Test
    public void exe20() {

        //20) Ler dois valores (considere que não serão lidos valores iguais) e escrevê-los em ordem crescente.

        int val1 = 5;
        int val2 = 23;

        if (val1 > val2) {
            System.out.println(val2 + " " + val1);
        } else {
            System.out.println(val1 + " " + val2);
        }

    }

    @Test
    public void exe21() {

        //21) Ler a hora de início e a hora de fim de um jogo de Xadrez (considere apenas horas inteiras, sem os
        //minutos) e calcule a duração do jogo em horas, sabendo-se que o tempo máximo de duração do jogo é
        //de 24 horas e que o jogo pode iniciar em um dia e terminar no dia seguinte.

        //esse foi dificil

        int hrInicio = 9;
        int hrFim = 1;

        int duracao = 0;

        if (hrInicio < hrFim) { // para uma partida que termina no mesmo dia, a hora de inicio sempre será MENOR que hora fim
            duracao = hrFim - hrInicio;   //ex: hrInicio 4, hrFim = 23  , ex: hrInicio 18, hrFim = 22
        } else if (hrFim < hrInicio) {
            // uma partida que passa para o dia seguinte, terá a hora de fim MENOR que a hora de começo
            //ex: hrInicio = 9, hrFim = 4

            duracao = hrInicio - hrFim;
            duracao = 24 - duracao;
            //tbm pode ser feito usando:
            //duracao = (24-hrInicio) + hrFim;
        } else {
            // partidas que começam e terminam no mesmo horario, são partidas de 24h, ex: hrInicio = 20, hrFim = 20
            duracao = 24;
        }

        System.out.println("A partida durou: " + duracao + "h");
    }

    @Test
    public void exe22() {

        //22) A jornada de trabalho semanal de um funcionário é de 40 horas. O funcionário que trabalhar mais
        //de 40 horas receberá hora extra, cujo cálculo é o valor da hora regular com um acréscimo de 50%.
        //Escreva um algoritmo que leia o número de horas trabalhadas em um mês, o salário por hora e escreva
        //o salário total do funcionário, que deverá ser acrescido das horas extras, caso tenham sido trabalhadas
        //(considere que o mês possua 4 semanas exatas).

        int hrTrabalhada = 163;
        int valorHr = 60;
        int qtdHrMensalRegular = 40 * 4;

        int salario = qtdHrMensalRegular * valorHr;

        if (hrTrabalhada > qtdHrMensalRegular) {
            int qtdHrExtra = hrTrabalhada - qtdHrMensalRegular;
            double valorHrExtra = valorHr + (valorHr * 0.5);
            salario += qtdHrExtra * valorHrExtra;
        }

        System.out.println("Salario a receber: " + salario);
    }

    @Test
    public void exe23() {

        ///23) Para o enunciado a seguir foi elaborado um algoritmo em Português Estruturado que contém
        //erros, identifique os erros no algoritmo apresentado abaixo:
    }

    @Test
    public void exe24() {

        //24) Ler o salário fixo e o valor das vendas efetuadas pelo vendedor de uma empresa. Sabendo-se que
        //ele recebe uma comissão de 3% sobre o total das vendas até R$ 1.500,00 mais 5% sobre o que
        //ultrapassar este valor, calcular e escrever o seu salário total.

        int salario = 2000;
        int totalVendas = 3000;

        if (totalVendas <= 1500) {
            salario += 1500 * 0.03;
        } else {
            salario += 1500 * 0.03;
            salario += (totalVendas - 1500) * 0.05;
        }

        System.out.println("salario: " + salario);
    }

    @Test
    public void exe25() {
        //25) Faça um algoritmo para ler: número da conta do cliente, saldo, débito e crédito. Após, calcular e
        //escrever o saldo atual (saldo atual = saldo - débito + crédito). Também testar se saldo atual for maior
        //ou igual a zero escrever a mensagem 'Saldo Positivo', senão escrever a mensagem 'Saldo Negativo'.

        int numConta = 542343;
        int saldo = 100;
        int debito = 50;
        int credito = 70;

        saldo = saldo - debito + credito;

        if (saldo >= 0) {
            System.out.println("Saldo positivo: " + saldo);
        } else {
            System.out.println("Saldo negativo: " + saldo);
        }
    }

    @Test
    public void exe26() {

        //26) Faça um algoritmo para ler: quantidade atual em estoque, quantidade máxima em estoque e
        // quantidade mínima em estoque de um produto. Calcular e escrever a quantidade média ((quantidade
        // média = quantidade máxima + quantidade mínima)/2). Se a quantidade em estoque for maior ou igual
        // a quantidade média escrever a mensagem 'Não efetuar compra', senão escrever a mensagem 'Efetuar compra'.

        int qtdAtual = 100;
        int qtdMax = 300;
        int qtdMin = 30;

        int qtdMedia = (qtdMax + qtdMin) / 2;

        if (qtdAtual >= qtdMedia) {
            System.out.println("nao efetuar compra");
        } else {
            System.out.println("efetuar compra");
        }
    }

    @Test
    public void exe27() {
        //27) Ler um valor e escrever se é positivo, negativo ou zero.

        int valor = -0;

        if (valor > 0) {
            System.out.println("positivo");
        } else if (valor < 0) {
            System.out.println("negativo");
        } else {
            System.out.println("zero");
        }


        if (valor > 0) {
            System.out.println("positivo");
        } else {

            if (valor == 0) {
                System.out.println("zero");
            } else {
                System.out.println("Positivo");
            }
        }

    }

    @Test
    public void exe28() {
        //28) Ler 3 valores (considere que não serão informados valores iguais) e escrever o maior deles.

        int a = 500;
        int b = 20;
        int c = 1;

        if (a > b && a > c) {
            System.out.println("a");
        } else if (b > a && b > c) {
            System.out.println("b");
        } else {
            System.out.println("c");
        }

        if (a > b) {
            if (a > c) {
                System.out.println("a");
            } else {
                System.out.println("c");
            }
        } else {

            if (b > c) {
                System.out.println("b");
            } else {
                System.out.println("c");
            }
        }

    }

    @Test
    public void exe29() {

        //29) Ler 3 valores (considere que não serão informados valores iguais) e escrever a soma dos 2
        //maiores.

        int a = 5;
        int b = 2000;
        int c = 100;
        int soma = 0;

        if (a > b) {

            if (a > c) {

                if (c > b) {
                    soma = a + c;
                    System.out.println("a + c");
                } else {
                    soma = a + b;
                    System.out.println("a + b");
                }

            } else {
                soma = a + c;
                System.out.println("a + c");
            }
        } else {
            if (b > c) {

                if (a > c) {
                    soma = b + a;
                    System.out.println("b + a ");
                } else {
                    soma = b + c;
                    System.out.println("b + c");
                }

            } else {
                soma = b + c;
                System.out.println("b + c");
            }
        }

        System.out.println("Soma dos maiores valores: " + soma);
    }

    @Test
    public void exe30() {
        //30) Ler 3 valores (considere que não serão informados valores iguais) e escrevê-los em ordem
        //crescente.

        int a = 5;
        int b = 2000;
        int c = 100;

        if (a > b && a > c) {
            if (b > c) {
                System.out.println(a + b + c);
            } else {
                System.out.println(a + c + b);
            }
        } else if (b > a && b > c) {
            if (a > c) {
                System.out.println(b + a + c);
            } else {
                System.out.println(b + c + a);
            }
        } else {
            if (a > b) {
                System.out.println(c + a + b);
            } else {
                System.out.println(c + b + a);
            }
        }

    }

    @Test
    public void exe31() {
        //31) Ler 3 valores (A, B e C) representando as medidas dos lados de um triângulo e escrever se formam
        //ou não um triângulo. OBS: para formar um triângulo, o valor de cada lado deve ser menor que a soma
        //dos outros 2 lados.

        int a = 300;
        int b = 200;
        int c = 100;
        boolean eTriangulo = false;

        if ((a + b) < c) {
            if ((b + c) < a) {
                if ((c + a) < b) {
                    eTriangulo = true;
                }
            }
        }

        if (eTriangulo) {
            System.out.println("é um triangulo");
        } else {
            System.out.println("não é um triangulo");
        }

    }

    @Test
    public void exe32() {
        //32) Ler o nome de 2 times e o número de gols marcados na partida (para cada time). Escrever o nome
        //do vencedor. Caso não haja vencedor deverá ser impressa a palavra EMPATE.

    }

    @Test
    public void exe33() {
        //33) Ler dois valores e imprimir uma das três mensagens a seguir:
        //‘Números iguais’, caso os números sejam iguais
        //‘Primeiro é maior’, caso o primeiro seja maior que o segundo;
        //‘Segundo maior’, caso o segundo seja maior que o primeiro.
    }

    @Test
    public void exe35() {
        //35) Um posto está vendendo combustíveis com a seguinte tabela de descontos:
        //Escreva um algoritmo que leia o número de litros vendidos e o tipo de combustível (codificado da
        //seguinte forma: A-álcool, G-gasolina), calcule e imprima o valor a ser pago pelo cliente sabendo-se
        //que o preço do litro da gasolina é R$ 3,30 e o preço do litro do álcool é R$ 2,90.

        char tipo = 'A';
        int qtdLitro = 19;
        double valor = 0;

        if (tipo == 'A') {
            if (qtdLitro <= 20) {
                valor = qtdLitro * 2.90;
                valor = valor - (valor * 0.03);

            } else {
                valor = qtdLitro * 2.90;
                valor = valor - (valor * 0.05);
            }
        } else {
            if (qtdLitro <= 20) {
                valor = qtdLitro * 3.30;
                valor = valor - (valor * 0.04);
            } else {
                valor = qtdLitro * 3.30;
                valor = valor - (valor * 0.06);
            }
        }

        System.out.println("valor a apgar: " + valor);

    }

    @Test
    public void exe36() {
        //36) Escreva um algoritmo que leia as idades de 2 homens e de 2 mulheres (considere que as idades
        //dos homens serão sempre diferentes entre si, bem como as das mulheres). Calcule e escreva a soma
        //das idades do homem mais velho com a mulher mais nova, e o produto das idades do homem mais
        //novo com a mulher mais velha.


        int h1 = 16;
        int h2 = 25;
        int m1 = 60;
        int m2 = 20;

        int hMaisVelho = 0;
        int mMaisNova = 0;

        int hMaisNovo = 0;
        int mMaisVelha = 0;


        if (h1 > h2) {
            hMaisVelho = h1;
            hMaisNovo = h2;
        } else {
            hMaisVelho = h2;
            hMaisNovo = h1;
        }

        if (m1 < m2) {
            mMaisNova = m1;
            mMaisVelha = m2;
        } else {
            mMaisNova = m2;
            mMaisVelha = m1;
        }

        int result1 = hMaisVelho + mMaisNova;
        int result2 = hMaisNovo * mMaisVelha;

        System.out.println("soma das idades do homem mais velho com a mulher mais nova: " + result1);
        System.out.println("produto das idades do homem mais novo com a mulher mais velha: " + result2);
    }

    @Test
    public void exe37() {
        //37) Uma fruteira está vendendo frutas com a seguinte tabela de preços:

        int qtdKgMorangos = 5;
        int qtdMoca = 7;
        double valorPagar = 0;

        if (qtdKgMorangos <= 5) {
            valorPagar = qtdKgMorangos * 2.5;
        } else {
            valorPagar = qtdKgMorangos * 2.2;
        }

        if (qtdMoca <= 5) {
            valorPagar += qtdMoca * 1.8;
        } else {
            valorPagar += qtdMoca * 1.5;
        }

        if ((qtdKgMorangos + qtdMoca) > 8 || valorPagar > 25.0) {
            valorPagar = valorPagar - (valorPagar * 0.10);
        }

        System.out.println("valor a pagar: " + valorPagar);
    }

    @Test
    public void exe38() {

        //rodar dentro de um main

        //38) Faça um algoritmo para ler um número que é um código de usuário. Caso este código seja
        //diferente de um código armazenado internamente no algoritmo (igual a 1234) deve ser apresentada a
        //mensagem ‘Usuário inválido!’. Caso o Código seja correto, deve ser lido outro valor que é a senha. Se
        //esta senha estiver incorreta (a certa é 9999) deve ser mostrada a mensagem ‘senha incorreta’. Caso a
        //senha esteja correta, deve ser mostrada a mensagem ‘Acesso permitido’.

        Scanner scanner = new Scanner(System.in);

        String codigo = scanner.next();

        if (codigo.equals("abc")) {
            String senha = scanner.next();
            if (senha.equals("9999")) {
                System.out.println("Acesso permitido");
            } else {
                System.out.println("senha incorreta");
            }

        } else {
            System.out.println("Usuário inválido!");
        }

    }

    @Test
    public void exe40() {
        //40) Faça um algoritmo para ler: a descrição do produto (nome), a quantidade adquirida e o preço
        //unitário. Calcular e escrever o total (total = quantidade adquirida * preço unitário), o desconto e o total
        //a pagar (total a pagar = total - desconto), sabendo-se que:
        // - Se quantidade <= 5 o desconto será de 2%
        // - Se quantidade > 5 e quantidade <=10 o desconto será de 3%
        // - Se quantidade > 10 o desconto será de 5%

        String nome = "rodas";
        int qtd = 7;
        double preco = 35.50;
        double desconto = 0;

        double total = preco * qtd;


        if (qtd <= 5) {
            desconto = total * 0.02;
        } else if (qtd > 5 && qtd <= 10) {
            desconto = total * 0.03;
        } else {
            desconto = total * 0.05;
        }

        total -= desconto;
        System.out.println("quantidade: " + qtd + " desconto: " + desconto + "total a pagar: " + total);
    }

    @Test
    public void exe42() {
        //Uma empresa quer verificar se um empregado está qualificado para a aposentadoria ou não. Para
        //estar em condições, um dos seguintes requisitos deve ser satisfeito:
        // - Ter no mínimo 65 anos de idade.
        // - Ter trabalhado no mínimo 30 anos.
        // - Ter no mínimo 60 anos e ter trabalhado no mínimo 25 anos.
        //Com base nas informações acima, faça um algoritmo que leia: o número do empregado (código), o ano
        //de seu nascimento e o ano de seu ingresso na empresa. O programa deverá escrever a idade e o tempo
        //de trabalho do empregado e a mensagem 'Requerer aposentadoria' ou 'Não requerer'.

        LocalDate nascimento = LocalDate.of(1995, 4, 4);
        LocalDate ingressoEmpresa = LocalDate.of(2000, 11, 4);

        boolean aposenta = false;
        String msg = "Não requerer";

        var idade = LocalDate.now().getYear() - nascimento.getYear();
        var tempoDeTrabalho = LocalDate.now().getYear() - ingressoEmpresa.getYear();

        if (idade >= 65) {
            aposenta = true;
            msg = "Requerer aposentadoria";
        }

        if (tempoDeTrabalho >= 30) {
            aposenta = true;
            msg = "Requerer aposentadoria";
        }

        if (idade >= 60 && tempoDeTrabalho >= 25) {
            aposenta = true;
            msg = "Requerer aposentadoria";
        }

        System.out.println("Idade: " + idade + " tempo de trabalho: " + tempoDeTrabalho + " Pode se aposentar? " + msg);
    }

    @Test
    public void exe44() {

        //rodar dentro de um main

        //44) Escreva um algoritmo para ler 2 valores e se o segundo valor informado for ZERO, deve ser lido
        //um novo valor, ou seja, para o segundo valor não pode ser aceito o valor zero e imprimir o resultado
        //da divisão do primeiro valor lido pelo segundo valor lido. (utilizar a estrutura REPITA).

        Scanner scanner = new Scanner(System.in);

        int val1 = scanner.nextInt();
        int val2 = 0;

        for(int i=0; val2==0; i++){

            System.out.println("Informe um numero diferente de 0: ");
            val2 = scanner.nextInt();
        }

        int result = val1 / val2;
        System.out.println(result);
    }

    @Test
    public void exe45() {

        //rodar dentro de um main

        //44) Escreva um algoritmo para ler 2 valores e se o segundo valor informado for ZERO, deve ser lido
        //um novo valor, ou seja, para o segundo valor não pode ser aceito o valor zero e imprimir o resultado
        //da divisão do primeiro valor lido pelo segundo valor lido. (utilizar a estrutura REPITA).

        Scanner scanner = new Scanner(System.in);

        int val1 = scanner.nextInt();
        int val2 = 0;

         while (val2 == 0){
            System.out.println("Informe um numero diferente de 0: ");
            val2 = scanner.nextInt();
        }

        int result = val1 / val2;
        System.out.println(result);
    }

    @Test
    public void exe46() {

        //rodar dentro de um main

        //44) Escreva um algoritmo para ler 2 valores e se o segundo valor informado for ZERO, deve ser lido
        //um novo valor, ou seja, para o segundo valor não pode ser aceito o valor zero e imprimir o resultado
        //da divisão do primeiro valor lido pelo segundo valor lido. (utilizar a estrutura REPITA).

        Scanner scanner = new Scanner(System.in);

        int val1 = scanner.nextInt();
        int val2 = 0;

        for(int i=0; val2==0; i++){

            System.out.println("Informe um numero diferente de 0: ");
            val2 = scanner.nextInt();
            if(val2 == 0){
                System.out.println("VALOR INVÁLIDO");
            }
        }

        int result = val1 / val2;
        System.out.println(result);
    }

    @Test
    public void exe48() {

        Scanner scanner = new Scanner(System.in);

        int val1 = scanner.nextInt();
        int val2 = scanner.nextInt();

        while ( (val1 < 0 || val1 > 10) || (val2 < 0 || val2 > 10) ) {

            System.out.println("Valor invalido, insira novos valores: ");
             val1 = scanner.nextInt();
             val2 = scanner.nextInt();
        }

        int result = (val1 + val2) /2;
        System.out.println("Media simples: " +result);

    }

    @Test
    public void exe49() {

        Scanner scanner = new Scanner(System.in);

        int val1 = 0;
        int val2 = 0;
        int result = 0;

        while ( true ) {

            System.out.println("Informe os valores das avaliações: ");
            val1 = scanner.nextInt();
            val2 = scanner.nextInt();

            if( (val1 < 0 || val1 > 10) || (val2 < 0 || val2 > 10) ){
                System.out.println("Valor invalido, insira novos valores: ");
                continue;
            }

            result = (val1 + val2) /2;
            System.out.println("Media simples: " +result);

            System.out.println("NOVO CÁLCULO (S/N)? ");
            String newCalc = scanner.next();

            if(newCalc.equals("S")){
                continue;
            }

            break;

        }
    }


    @Test
    public void exe53() {

        //53) Ler um valor N e imprimir todos os valores inteiros entre 1 (inclusive) e N (inclusive). Considere
        //que o N será sempre maior que ZERO.

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for(int i=0; i<=n; i++){
            System.out.println(i);
        }

    }

    @Test
    public void exe54() {

        //54) Modifique o exercício anterior para aceitar somente valores maiores que 0 para N. Caso o valor
        //informado (para N) não seja maior que 0, deverá ser lido um novo valor para N.

        Scanner scanner = new Scanner(System.in);
        int n = 10;
        boolean ler = true;

        for(int i=1; i<=n; i++){

            if(ler){
                n = scanner.nextInt();
            }

            if(n < 0 ){
                i=0;
                n=10;
                continue;
            }

            ler = false;
            System.out.println(i);
        }

    }

    public static void main(String[] args) {



    }

}

















