package estudos.thread.schedule;


import java.util.Timer;

public class AgendamentoDeTarefa {

    public static void main(String[] args) {

        //Para agendamento de tarefas usando apenas o recurso do Java

        Timer timer = new Timer(); // responsavel por dar inicio ao agendador
        ExecAgendado execAgendado = new ExecAgendado();

        // segundo parametro: “long”, com o tempo em millisegundos antes da thread começar a ser executada
        // terceiro parametro: “long” com o intervalo de tempo em milisegundos para execução repetida
        // da thread, ou seja, de quanto em quanto tempo ela será executada. Em nosso caso usamos os parâmetros:

        timer.schedule(execAgendado, 0, 1);
        //timer.schedule(agendamento, new Date(), 1000);


        while (true){

            try {
                var vet = new Integer[]{1, 2, 3, 4, 5};
                System.out.println(ExecAgendado.soma(vet));

                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
