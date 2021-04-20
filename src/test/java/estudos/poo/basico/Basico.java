package estudos.poo.basico;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.*;


@RunWith(JUnit4.class)
public class Basico {

    Notebook note1 = new Notebook("ASUS", 1600, 2000);
    Notebook note2 = new Notebook("DELL", 4000, 3000);
    Notebook note3 = new Notebook("APPLE", 16000, 4500);
    Notebook note4 = new Notebook("ACER", 1600, 4000);
    Notebook note5 = new Notebook("LG", 6000, 2500);
    Notebook note6 = new Notebook("SAMSUMG", 14000, 6500);

    @Test
    public void comparable() {
        //comparable: É criado uma ordem natural para os elementos serem comparados, sendo implementado na propria class

        System.out.println("Ordenação dos elementos pela memoria da menor para maior");
        var ls = Arrays.asList(note5,note1,note4,note3,note6, note2);
        Collections.sort(ls);
        ls.forEach(System.out::println);
    }

    class Notebook implements Comparable<Notebook> {
        String marca;
        Integer memoria;
        Integer preco;

        public Notebook(String marca, Integer memoria, Integer preco) {
            this.marca = marca;
            this.memoria = memoria;
            this.preco = preco;
        }

        public String getMarca() {
            return marca;
        }

        public Integer getMemoria() {
            return memoria;
        }

        public Integer getPreco() {
            return preco;
        }

        @Override
        public String toString() {
            return "Notebook{" +
                    "marca='" + marca + '\'' +
                    ", memoria=" + memoria +
                    ", preco=" + preco +
                    '}';
        }

        private final Comparator<Notebook> NATURAL_ORDER_COMPARATOR = //sempre usar esse metodo com static
                Comparator.comparing(Notebook::getMemoria)
                        .thenComparing(Notebook::getPreco);

        @Override
        public int compareTo(Notebook o) {
            return NATURAL_ORDER_COMPARATOR.compare(this, o);
        }
    }

    @Test
    public void comparator() {

        //Comparator: é criado um comparador composto para regras mais especificas
        var ls = Arrays.asList(note5,note1,note4,note3,note6, note2);

        Comparator<Notebook> comparator = new Comparator<Notebook>() {
            @Override
            public int compare(Notebook o1, Notebook o2) {
                if(o2.memoria > o1.memoria) {
                    return 1;
                }else if(o2.memoria < o1.memoria){
                    return -1;
                }else{
                    return 0;
                }
            }
        };

        System.out.println("Ordenação dos elementos pela memoria, da maior para a menor");
        Collections.sort(ls,comparator);
        ls.forEach(System.out::println);

        System.out.println("\n\nOrdenação dos elementos pelo preço, do mais caro para o mais barato");
        Collections.sort(ls,(n1, n2) -> n2.preco.compareTo(n1.preco)); //java 8+
        ls.forEach(System.out::println);

        System.out.println("\n\nOrdenação dos elementos pelo memoria e preço...");
        Collections.sort(ls, Comparator.comparing(Notebook::getMemoria).thenComparing(Notebook::getPreco).reversed());
        ls.forEach(System.out::println);
    }


    @Test
    public void comparatorComNullsNaLista() {

        var ls = Arrays.asList(null,note5,note1,null,note4,note3,null,note6,note2);

        var comparator = Comparator.comparing( Notebook::getMemoria);
        var comparator_nullFirst= Comparator.nullsFirst(comparator);

        System.out.println("Objetos nullos da lista no inicio");
        Collections.sort(ls, comparator_nullFirst);
        ls.forEach(System.out::println);

        var comparator_nullLast= Comparator.nullsLast(comparator);
        System.out.println("Objetos nullos da lista no final");
        ls.sort(comparator_nullLast);
        ls.forEach(System.out::println);
    }

    @Test
    public void comparatorPropriedadeDeObjetosNull() {

        Notebook note7 = new Notebook("", 1000, null);
        Notebook note8 = new Notebook("Teste8", null, 3800);
        Notebook note9 = new Notebook("Teste9", 5000, null);
        Notebook note10 = new Notebook("Teste10", null, 3800);
        Notebook note11 = new Notebook("Teste11", null, 3800);
        Notebook note12 = new Notebook("Teste12", null, 3800);

        var ls = Arrays.asList(note9,note5,note1,note8,note4,note3,note7,note6,note2, note10, note11, note12);

        System.out.println("\nOrdenação dos elementos com atributos nullos primeiro...");
        ls.sort( Comparator.comparing( Notebook::getMemoria, Comparator.nullsFirst(Comparator.naturalOrder() ) )    );
        ls.forEach(System.out::println);

        System.out.println("\n\nOrdenação dos elementos com atributos nullos por ultimo...");
        var comparator = Comparator.comparing( Notebook::getMemoria, Comparator.nullsLast(Comparator.naturalOrder()) )
                .thenComparing(Notebook::getPreco, Comparator.nullsLast(Comparator.naturalOrder()));

        ls.sort(comparator);
        ls.forEach(System.out::println);
    }

    @Test
    public void recursao(){

        var rec1 = new Recursao("1");
        var rec2 = new Recursao("2");
        var rec3 = new Recursao("3");
        var rec4 = new Recursao("4");

        rec1.recursao = rec2;
        rec2.recursao = rec3;
        rec3.recursao = rec4;

        System.out.println("Ativando recursao");
        ativarRecursao(rec1);
        System.out.println("Recursao desativada");
    }

    private void ativarRecursao(Recursao rec) {
        if(rec.recursao != null){
            ativarRecursao(rec.recursao);
            System.out.println(rec.linha);
        }
    }

    class Recursao{
        Recursao recursao;
        String linha;

        public Recursao(String linha) {
            this.linha = linha;
        }
    }

    @Test
    public void equalsEHashCode(){

        //https://angeliski.com.br/2014/01/05/equals-e-hashcode/
        // O hashcode calcula o hash do elemento e organiza os elementos em uma
        // "Tabela Hash" dentro da coleção, facilitando assim a busca de elementos
        // No momento da busca dos elementos dentro de uma coleção, o hashcode é
        // calculado, e a partição da tabela referente a esse hash é encontrado,
        // existindo outros elementos na partição, o iguals é usado para comparar e encontrar o elemento

        var t1 = new Teclado(143, "maxPrint", true);
        var t2 = new Teclado(133, "knup", true);
        var t3 = new Teclado(123, "multlaser", false);

        var t4 = new Teclado(123, "multlaser", false);
        var exist = Arrays.asList(t1, t2, t3).contains(t4); //não usa hascode, apenas iquals para comparar cada elemento, encontrando o similar
        if(exist){
            System.out.println("Elemento existe");
        }

        Set<Teclado> set = new HashSet<>(Arrays.asList(t1,t2,t3,t4));
        // Elemento não foi adicionado por ser semelhante ao t3

        if(set.size() == 3){
            System.out.println("Elemento t4 não foi adicionado");
        }

        // o elemento c2, mesmo sendo indentico ao c1, foi adicionado a coleção.
        // devido a falta de hashcode implementado, a busca por elementos iguais não consegue encontrar nenhum objeto, pois não encontra
        // a partição para iniciar a comparação de objetos com iguals
        var c1 = new Carro("rosa", "gol", 2010);
        var c2 = new Carro("rosa", "gol", 2010);
        var c3 = new Carro("zaul", "fiesta", 2015);
        Set<Carro> carroSets = new HashSet<>(Arrays.asList(c1,c2,c3)); // usa tabela hash para agrupar os elementos

        if(carroSets.size() == 3){
            System.out.println("Elemento c2 foi adicionado mesmo sendo igual ao c1");
        }

        // Dica: objetos mutaveis não deve ser usados para implementação no hascode
        // pois um hash é calculado para incluir o elemento num bucket, então o atributo da classe mutavel pode ser alterado
        // no momento da busca desse elemento ( ja com atributo alterado ) na lista, o mesmo não sera encontrado
    }

    class Teclado{
     int qtdTeclas;
     String marca;
     boolean led;

        public Teclado(int qtdTeclas, String marca, boolean led) {
            this.qtdTeclas = qtdTeclas;
            this.marca = marca;
            this.led = led;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Teclado teclado = (Teclado) o;
            return qtdTeclas == teclado.qtdTeclas &&
                    led == teclado.led &&
                    Objects.equals(marca, teclado.marca);
        }

        @Override
        public int hashCode() {
            return Objects.hash(qtdTeclas, marca, led);
        }
    }

    class Carro{
        String cor;
        String modelo;
        int ano;

        public Carro(String cor, String modelo, int ano) {
            this.cor = cor;
            this.modelo = modelo;
            this.ano = ano;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Carro carro = (Carro) o;
            return ano == carro.ano &&
                    Objects.equals(cor, carro.cor) &&
                    Objects.equals(modelo, carro.modelo);
        }

    }

}



















