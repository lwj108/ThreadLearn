/**
 * Created by 李维俊 on 2018/5/19.
 */
class MyThread extends Thread{
    private int ticketCount = 5;
    private String name = null;

    public MyThread(String name){
        this.name = name;
    }

    @Override
    public void run() {
        while (ticketCount>0){
            ticketCount--;
            System.out.println(name + "卖出一张票,还剩票数:" + ticketCount);
        }
    }
}

public class TicketThread {
    public static void main(String[] args) {
        Thread th1 = new MyThread("窗口一");
        Thread th2 = new MyThread("窗口二");
        Thread th3 = new MyThread("窗口三");
        th1.start();
        th2.start();
        th3.start();
    }
}
