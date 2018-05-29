package Thread;

/**
 * 多线程写入冲突,需保证同步在t1写入时t2是不能写不能读;使用synchronized实现
 * Created by 李维俊 on 2018/5/14.
 */
public class AccountingVol implements Runnable {
    static AccountingVol instance = new AccountingVol();
    static volatile int i = 0;

    public static synchronized void increase() {//synchronized作用于静态方法时可保证main方法中创建了2个runnable实例对象
        i++;
    }
    @Override
    public void run() {
        for (int j=0;j<1000000;j++){
            increase();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance);//保证在一个对象中时increase方法可不用加静态
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
        int v1 = 1072382748;
        int v2 = 1230495182;
        int ave = (v1+v2)/2;
        System.out.println(ave);//v1+v2的结果导致int溢出
    }
}
