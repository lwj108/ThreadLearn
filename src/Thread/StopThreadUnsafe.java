package Thread;

/**
 * Created by 李维俊 on 2018/5/9.
 */
public class StopThreadUnsafe {

    public static User u = new User();

    public static class User{
        private int id;
        private int name;

        public User(){
            id = 0;
            name = 0;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getName() {
            return name;
        }

        public void setName(int name) {
            this.name = name;
        }

        @Override
        public String toString(){
            return "User [id="+id+", name="+name+"]";
        }

    }

    public static class ChangeObjectThread extends Thread{

        @Override
        public void run(){
            while (true){
                synchronized (u){
                    int v = (int)(System.currentTimeMillis()/1000);
                    u.setId(v);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    u.setName((int)(System.currentTimeMillis()/1000));
                }
                Thread.yield();
            }
        }
    }

    public static class ReadObjectThread extends Thread{

        @Override
        public void run() {
            while (true){
                synchronized (u){
                    if(u.getId() != u.getName()){
                        System.out.println(u.toString());
                    }
                }
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        new ReadObjectThread().start();
        while (true){
            Thread t = new ChangeObjectThread();
            t.start();
            Thread.sleep(150);
            t.stop();
        }

    }
}
