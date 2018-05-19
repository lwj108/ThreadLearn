/**
 * Runnable可以避免Thread方式由于单继承特性带来的缺陷,
 * 可以被多个线程共享,适用于多个线程处理统一资源的情况
 * Created by 李维俊 on 2018/5/19.
 */
class MyThread2 implements Runnable{

    private int ticketCount = 15;

    @Override
    public void run() {
        while (ticketCount>0){
            ticketCount--;
            System.out.println(Thread.currentThread().getName() + "卖出一张票,还剩票数:" + ticketCount);
        }
    }
}

public class TicketRunnable {
    public static void main(String[] args) {
        MyThread2 mt = new MyThread2();
        Thread th1 = new Thread(mt,"窗口一");
        Thread th2 = new Thread(mt,"窗口二");
        Thread th3 = new Thread(mt,"窗口三");
        th1.start();
        th2.start();
        th3.start();
    }
}
