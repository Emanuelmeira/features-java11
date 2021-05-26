package estudos.thread;

public class ThreadImplementacaoTestes {


    public static void main(String[] args) {
        Thread t1 = new Thread(new ThreadComRunnable(), "t1");
        Thread t2 = new Thread(new ThreadComRunnable(), "t2");
        System.out.println("Iniciando Runnable threads");
        t1.start();
        t2.start();
        System.out.println("Runnable Threads foram iniciadas");

        Thread t3 = new MinhaThread("t3");
        Thread t4 = new MinhaThread("t4");
        System.out.println("Iniciando MinhaThread");
        t3.start();
        t4.start();
        System.out.println("MinhaThread foram iniciadas ");

        //A implementação de Runnable é preferível porque o java suporta a implementação de várias interfaces.
        // Se você estender a classe Thread, não poderá estender nenhuma outra classe.

    }

    // Se sua classe fornece mais funcionalidade ao invés de apenas rodar como Thread, você deve implementar a interface
    // Runnable para fornecer uma maneira de executá-la como Thread
    static class ThreadComRunnable implements Runnable{

        @Override
        public void run() {
            System.out.println("Iniciar processo "+Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
                //Get database connection, delete unused data from DB
                doDBProcessing();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Fim do processo "+Thread.currentThread().getName());
        }

        private void doDBProcessing() throws InterruptedException {
            Thread.sleep(5000);
        }
    }

    // Se o único objetivo de sua classe é executar como Thread, você pode estender a classe Thread.
    static class MinhaThread extends Thread {

        public MinhaThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            System.out.println("MinhaThread - START "+Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
                //Get database connection, delete unused data from DB
                doDBProcessing();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("MinhaThread - END "+Thread.currentThread().getName());
        }

        private void doDBProcessing() throws InterruptedException {
            Thread.sleep(5000);
        }

    }


}
