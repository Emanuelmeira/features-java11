package estudos.thread;


public class ThreadLambdaTestes {

    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            String nome = concatenarSobrenome("Emanuel - ");
            System.out.println("A Thread chamada retornou com a resposta!");
            System.out.println(nome);
        };

        System.out.println("A Thread foi chamada ...");
        new Thread(task).start();
        System.out.println("... e o fluxo de execução continua..");

        System.out.println("//_________________________________________________________");


        // metodo ou objeto compartilhado entre thread pode/deve ser controlado,

        //ProcessingThread pt = new ProcessingThread();
        ProcessingThread2 pt = new ProcessingThread2();
        Thread t1 = new Thread(pt, "t1"); // compartilhando objeto com 2 threads
        t1.start();
        Thread t2 = new Thread(pt, "t2"); // compartilhando objeto com 2 threads
        t2.start();

        t1.join(); // joint espera as threads serem executadas para sincronização
        t2.join();
        System.out.println("Processing count="+pt.getCount());

    }

    private static String concatenarSobrenome(String nome) {

        try {
            Thread.sleep(1500);// simular uma demora no processamento
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return nome.concat(" Meira");
    }

    class ProcessingThread implements Runnable{
        private int count;

        @Override
        public synchronized void run() { // bloqueando o metodo completo
            for(int i=1; i < 5; i++){
                processSomething(i);
                count++;
            }
        }

        public int getCount() {
            return this.count;
        }

        private void processSomething(int i) {
            // processing some job
            try {
                Thread.sleep(i*500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class ProcessingThread2 implements Runnable{
        private Integer count=0; // os objetos bloqueados devem ser privados  e sem setters para não ocorrer mudanças no contexto

        @Override
        public  void run() {
            for(int i=1; i < 5; i++){
                processSomething(i);
                synchronized(count){ // bloqueando apenas o recurso (objeto) a ser acessado
                    count++;
                }
            }
        }

        public int getCount() {
            return this.count;
        }

        private void processSomething(int i) {
            try {
                Thread.sleep(i*500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}


