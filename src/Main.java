import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

public class Main {



    public static void main(String[] args) throws InterruptedException, IOException {
        FileMaker fm = new FileMaker();
        Thread t0 = new Thread(new WorkerClass());
        Thread t1 = new Thread(new DeworkerClass());




        long startTime = System.currentTimeMillis();

        fm.createFile(10);
        fm.deleteFiles(10);

        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);

        int nrThreads = 2;

        System.out.println(sharedResource.number);
        //Assign writes

        for (int i = nrThreads; i < nrThreads/10; i++){


        }
    }
}


class sharedResource {

    public static volatile int number = 10;
    public static synchronized void increment(){number++;}
    public static synchronized void decrement(){number--;}

}

class DeworkerClass implements Runnable {


    @Override
    public void run() {
        increment();
    }

    public synchronized void increment() {
        synchronized (this) {
            for (int i = 0; i < 50000; i++) {
                sharedResource.increment();
            }
        }
    }
}


class WorkerClass implements Runnable {

    @Override
    public void run() {
        increment();
    }

    public synchronized void increment() {
        synchronized (this) {

            for (int i = 0; i < 50000; i++) {
                sharedResource.decrement();
            }
        }
    }
}



