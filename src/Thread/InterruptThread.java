package Thread;

/**
 * Created by 李维俊 on 2018/5/9.
 */
public class InterruptThread {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(){
            @Override
            public void run() {
                while (true){
                    if(Thread.currentThread().isInterrupted()){
                        System.out.println("Interrupted!");
                        break;
                    }
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        System.out.println("Interrupted When Sleep");
                        Thread.currentThread().isInterrupted();
                    }
                    Thread.yield();
                }

            }
        };
        t1.start();
        Thread.sleep(2000);
        t1.interrupt();
    }
}
