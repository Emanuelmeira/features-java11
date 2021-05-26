package estudos.thread.schedule;

import java.time.LocalDate;
import java.util.TimerTask;

public class ExecAgendado extends TimerTask {

    private static Integer count=0;

    @Override
    public void run() {
        //metodo onde contem o que deve ser feito nas threads
        System.out.println("Id da thread: " + Thread.currentThread().getId() +" - "+ LocalDate.now().toString());

    }

    public synchronized static Integer soma(Integer[] nums){
        count=0;
        for (Integer num : nums){
            count += num;
        }
        return count;
    }
}
