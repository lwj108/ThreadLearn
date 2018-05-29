package Thread;

/**
 * Created by 李维俊 on 2018/5/9.
 */
public class CreateThread implements Runnable{
    @Override
    public void run(){
        System.out.println("Oh!I am Runable");
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new CreateThread());
        t1.start();
    }
}
