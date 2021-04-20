package estudos.poo.reflection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.*;

@RunWith(JUnit4.class)
public class Reflection {

    @Test
    public void reflection() {

        var carro = new Carro("azul",2007);
        Class classCarro = carro.getClass();

        System.out.println(Carro.class.getCanonicalName() );

        var fields = classCarro.getDeclaredFields();
        Arrays.asList(fields).forEach(x -> { System.out.println(x.getName() ); });

        var metods = classCarro.getDeclaredMethods();
        Arrays.asList(metods).forEach(x -> { System.out.println(x.getName() ); }); // pega metodos apenas da class

        criarInstancias(Cliente.class);
    }

    class Carro{

        public Carro(String cor, int ano) {
            this.cor = cor;
            this.ano = ano;
        }

        public Carro() {
        }

        public Carro(String cor) {
            this.cor =cor;
        }

        private String cor;
        private int ano;

        public String getCor() {
            return cor;
        }

        public void setCor(String cor) {
            this.cor = cor;
        }

        public int getAno() {
            return ano;
        }

        public void setAno(int ano) {
            this.ano = ano;
        }

        public void trocarCor(String cor){
            if(validaCor(cor)){
                this.cor = cor;
            }
        }

        private boolean validaCor(String cor){
            if("preto".equalsIgnoreCase(cor) ){
                return  false;
            }
            return true;
        }
    }

    @Test
    public void copiarObjeto(){

        var celular1 = new Celular(120, "nokia");
        var bateria = new Bateria();
        bateria.setCapacidade(6000);
        bateria.setValidade(null);
        celular1.setBateria(bateria);

        var destino = new Celular();
        var bateria2 = new Bateria();
        bateria2.setValidade("final do ano");
        destino.setBateria(bateria2);

        copiarObjetoComAtributos(celular1, destino);
        System.out.println(destino.getMarca() +" _ " +destino.getPeso() +" - "+destino.getBateria().getCapacidade());
    }


    private <T, D> void copiarObjetoComAtributos(T origem, D destino) {

        var destinoClass = destino.getClass();

        var origemCLass = origem.getClass();
        var fieldsOrigem = origemCLass.getDeclaredFields();

        Arrays.asList(fieldsOrigem).forEach(fieldOrigem -> {

            try {
                var fieldDestino = destinoClass.getDeclaredField(fieldOrigem.getName());
                fieldDestino.setAccessible(true);
                var valorFieldOrigem = fieldOrigem.get(origem);

                if(valorFieldOrigem != null){
                    fieldDestino.set( destino, this.copyObject( fieldDestino.getClass(), valorFieldOrigem) );
                }
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }

    class Celular{
        private int peso;
        private String marca;
        private Bateria bateria;

        public Celular(int peso, String marca) {
            this.peso = peso;
            this.marca = marca;
        }

        public Celular() { }

        public Bateria getBateria() {
            return bateria;
        }

        public void setBateria(Bateria bateria) {
            this.bateria = bateria;
        }

        public int getPeso() {
            return peso;
        }

        public void setPeso(int peso) {
            this.peso = peso;
        }

        public String getMarca() {
            return marca;
        }

        public void setMarca(String marca) {
            this.marca = marca;
        }
    }

    class Bateria{
        private Integer capacidade;
        private String validade;

        public String getValidade() {
            return validade;
        }

        public void setValidade(String validade) {
            this.validade = validade;
        }

        public Integer getCapacidade() {
            return capacidade;
        }

        public void setCapacidade(Integer capacidade) {
            this.capacidade = capacidade;
        }
    }

    private Object copyObject(Class<?> targetType, Object valueFound)  {

        try {
            if( !targetType.isInstance(valueFound) && !targetType.isPrimitive()){

                Constructor<?> constructor = targetType.getConstructor();
                var destinationValue = constructor.newInstance();
                this.copiarObjetoComAtributos(destinationValue, valueFound);

                return destinationValue;
            }else {
                return valueFound;
            }
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new IllegalArgumentException("Erro ao copiar objeto");
        }
    }

    private Object criarInstancias(Class<?> clazz) {

        Object obj = null;

        try {
            Constructor<?> constructor = null;
            if(!clazz.isPrimitive()){

                Constructor[] constructors = clazz.getConstructors();
                for(var constr : constructors){
                    if(Objects.isNull(constr.getParameters())){ // o construtor padrão (sem argumentos) é buscado
                        constructor = constr;
                    }
                }

                if(constructor != null){
                    obj  = constructor.newInstance();
                    return obj;
                }
            }

        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return obj;
    }

    @Test
    public void lerMetodosComAnotacoes() {

        try{

            var cliente = new Cliente();
            cliente.setNome("Emanuel");
            cliente.setDataNascimento(new Date());
            cliente.setCodigo(12);
            cliente.setEnderecoCompleto("Rua a");

            var clazz = cliente.getClass();

            for(var m: clazz.getDeclaredMethods()){

                if(m.isAnnotationPresent(Mostrar.class)){ //Reflection funciona apenas em anotações que tenham sido marcadas com @Retention.RUNTIME.
                    if(m.getParameterCount() > 0){
                        System.out.println(m.getName() +"- metodo 'set' precisa de parametro");
                        continue;
                    }
                    System.out.println(m.getName() +"-"+ m.invoke(cliente));
                }
            }

        }catch (InvocationTargetException | IllegalAccessException e){
            e.printStackTrace();
        }
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Test
    public void teste(){
        ArrayList a = new ArrayList(); // codigo sem utilização de generics java < 1.5m lança warnings que são suprimidos com @
        a.add("");
    }

    @DOING(novoResponsavel = "Emanuel",
            classTarefa = Reflection.class,
            antigosResponsaveis = {"Pedro", "lucas", "joão"})
    @TODO("utilização de anotação com unico parametro")
    private void metodoTesteAnotacoes(){}

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface TODO{
        String value(); // caso tenha apenas um valor, é obrigatorio a utilização do nome "value"
        //O tipo de retorno deve ser um dos seguintes: primitivos, String, Class, enum ou um array cujo tipo seja um dos precedentes
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface DOING{
        Area area() default Area.RH;
        String novoResponsavel();
        Class classTarefa();
        String[] antigosResponsaveis();
    }

    public enum Area { RH, FINANCEIRO, TI; }

    @Test
    public void testessssssssssssssssssss() throws ClassNotFoundException, URISyntaxException {

        //implementandoReflection("src.test.java.estudos");

        var a = ClassLoader.getSystemClassLoader();// SystemResource("estudos.poo.reflection");
        var b = a.getDefinedPackage("estudos.poo.reflection");

        //Class.forName("C:/Users/Emmit/Documents/projetos/estudos-java11/src/test/java/estudos/collect/CollectsTestes.java");
        //Class.forName("src/test/java/estudos/collect/CollectsTestes.java");
        //Class.forName("src.test.java.estudos.collect.CollectsTestes.java");

    }

    @SuppressWarnings({"rawtypes"})
    private void implementandoReflection(String packageName) throws ClassNotFoundException {

        String path = packageName.replace('.', '/');
        File directory = new File(path);

        ArrayList<Class> classes = new ArrayList<>();
        classes.addAll(findClasses(directory, packageName));

        System.out.println(classes.size());
    }

    private static List<Class> findClasses(File directory, String packageName) throws ClassNotFoundException {
        List<Class> classes = new ArrayList<Class>();
        if (!directory.exists()) {
            return classes;
        }
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                assert !file.getName().contains(".");
                classes.addAll(findClasses(file, packageName + "." + file.getName()));
            } else if (file.getName().endsWith(".java")) {

                file.getPath();


                classes.add(Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 5)));
            }
        }
        return classes;
    }

    //TODO pegar todas as classes que anotações do projeto e fazer verificações
}




















