package Thread;

import java.util.HashMap;
import java.util.Map;

/**
 * HashMap线程不安全
 * 两个线程正在遍历HashMap的内部数据,由于多线程冲突,链表结构遭到破坏,变成环Key1,Key2互为对方下一个next元素
 * 通过next引用遍历将形成死循环
 * 最简单的解决办法是使用ConcurrentHashMap
 * Created by 李维俊 on 2018/5/14.
 */
public class HashMapMultiThread {
    static Map<String,String> map = new HashMap<String, String>();

    public static class AddThread implements Runnable{
        int start = 0;
        public AddThread(int start){
            this.start=start;
        }

        @Override
        public void run() {
            for (int i=start;i<100000;i+=2){
                map.put(Integer.toString(i),Integer.toBinaryString(i));
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new HashMapMultiThread.AddThread(0));
        Thread t2 = new Thread(new HashMapMultiThread.AddThread(1));
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(map.size());
    }
}
