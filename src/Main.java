public class Main {

    public static void main(String[] args) throws InterruptedException {
        Thread t0 = new Thread(new WorkerClass());

        Thread t1 = new Thread(new DeworkerClass());


        t0.join();
        t1.join();

        System.out.println(sharedResource.number);
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



