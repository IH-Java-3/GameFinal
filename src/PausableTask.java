import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public abstract class PausableTask implements  Runnable{

    private ExecutorService executor = Executors.newSingleThreadExecutor();
    private Future<?> publisher;
    protected volatile int counter;
    private void someJob() {
        System.out.println("Job Done :- " + counter);

    }

    abstract void task();

    @Override
    public void run() {
        while(!Thread.currentThread().interrupted()){
            task();
        }
    }

    public void start(){
        publisher = executor.submit(this);
    }

    public void pause() {
        publisher.cancel(true);
    }

    public void resume() {
        start();
    }

    public void stop() {
        executor.shutdownNow();
    }
}