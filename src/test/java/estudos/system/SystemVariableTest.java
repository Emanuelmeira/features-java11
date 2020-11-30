package estudos.system;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SystemVariableTest {

    @Test
    public void getApplicationVariable() {

        //busca variaveis que são iniciados junto com o sistema OU varieveis padrões do sistema || todo relacionado a aplicação Java
        // EX: java -Dnome=Kico

        System.out.println("Nome do SO que roda o sistema: "+ System.getProperty("os.name"));
        System.out.println("Nome da variavel iniciada junto com sistema: "+ System.getProperty("nome"));
    }

    @Test
    public void getSystemVariable() {

        //busca varieveis do servidor onde a aplicação esta rodando

        System.out.println("Local de instalação do java: "+ System.getenv("JAVA_HOME"));
        System.out.println("Path do sistema: "+ System.getenv("PATH"));
    }


}
