import java.util.ArrayList;
import java.util.Vector;

/**
 * ArrayList线程不安全,Vector线程安全
 * Created by 李维俊 on 2018/5/14.
 */
public class ArrayListMultiThread {
    //static ArrayList<Integer> arrayList = new ArrayList<Integer>(10);
    static Vector<Integer> vector = new Vector<Integer>(10);
    public static class AddThread implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 1000000; i++) {
                //arrayList.add(i);
                vector.add(i);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new AddThread());
        Thread t2 = new Thread(new AddThread());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        //System.out.println(arrayList.size());
        System.out.println(vector.size());
    }
}
