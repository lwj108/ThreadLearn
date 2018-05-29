package Array;

import java.util.Scanner;

/**
 * Created by 李维俊 on 2018/5/29.
 */
public class Demo {
    public static void main(String[] args) {
        int [] array = new int[10];
        getNumberFromStdin(array);
        printIntArray(array);
    }

    /**
     * 从键盘上获取数据保存到数组中
     * @param array 传入的是一个类型的数组,把从键盘上获取的数据保存到array数组中
     */
    public static void getNumberFromStdin(int[] array){
        //1.参数合法性判断
        if(null == array){
            System.out.println("传入参数不合法");
            return;
        }

        Scanner sc = new Scanner(System.in);
        //2.利用for循环从键盘获取用户输入的int类型
        for(int i = 0;i < array.length; i++){
            array[i] = sc.nextInt();
        }
    }

    /**
     * 打印传入的int类型数组里面的数据
     */
    public static void printIntArray(int[] array){
        if(null == array){
            System.out.println("传入参数不合法");
            return;
        }

        for (int i=0;i<array.length;i++){
            System.out.println("array["+i+"] ="+array[i]);
        }
    }
}
