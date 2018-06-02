package Array;

import java.util.Scanner;

/**
 * 数组的增删改成操作
 * Created by 李维俊 on 2018/5/29.
 */
public class ArrayCurd {
    public static void main(String[] args) {
//        int[] arr = {0,1,2,3,4,5,6};
//        int ret = getIndex(arr,10);
//        if(ret != -1){
//            System.out.println(ret);
//        }else {
//            System.out.println("not data found");
//        }
        // 测试findMaxIndex
//        int [] arr = new int[10];
//        getNumberFromStdin(arr);
//        int ret = findMaxIndex(arr);
//
//        if (ret != -1){
//            System.out.println("Max is "+arr[ret]+"; index at "+ret);
//        }

        int [] arr = new int[10];
        int [] indexs = new int[arr.length];
        System.out.println("请输入10个值");
        getNumberFromStdin(arr);
        int count = findAllMaxIndex(arr,indexs);
        for(int i=0;i<count;i++){
            System.out.println("arr["+indexs[i]+"] = "+arr[indexs[i]]);
        }
    }

    /**
     * 从数组中找出元素值为2得到下标
     */
    public static int getIndex(int[] array,int number){
        //1.参数合法性判断
        if(null == array || array.length == 0){
            System.out.println("传入的参数不合法");
            return -1;
        }
        //用来保存找到的下标
        int index = -1;
        //2.查找
        for (int i = 0;i<array.length;i++){
            if(array[i] == number){
                index = i;
                break;
            }
        }
        return index;
    }

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
     * 找出数组中最大值所在的下标;缺陷{1,2,3,4,5,1,2,3,4,5}只能查出第一个,因为函数只返回了一个值
     * @param array
     * @return
     */
    public static int findMaxIndex(int[] array){
        //1.参数合法性判断
        if(null == array || array.length == 0){
            System.out.println("传入的参数不合法");
            return -1;
        }

        //2.查找最大值,假设下标为0的元素是数组中最大值
        int index = 0;
        for (int i = 1;i<array.length;i++){
            //如果当前的index下标的数据小于i的元素,说明index保存的数据不是最大值,把i的值赋给index
            if (array[index] < array[i]){
                index = i;
            }
        }
        return index;
    }

    /**
     * 找出数组中所有最大值的下标个数
     * @param array 数据源所在数据
     * @param indexs 保存最大值下标数组
     * @return 返回个数
     */
    public static int findAllMaxIndex(int[] array,int[] indexs){
        //1.参数合法性判断
        if(null == array || array.length == 0 || null == indexs || indexs.length==0){
            System.out.println("传入的参数不合法");
            return -1;
        }

        //2.找到数据中的最大值
        int max = array[0];
        for (int i = 1;i<array.length;i++){
            if(max<array[i]){
                //始终保存最大值
                max = array[i];
            }
        }
        //3.根据最大值找到所有最大值下标,保存到indexs数组中
        //用一个count保存找到的最大值个数
        int count = 0;
        for (int j = 0;j<array.length;j++){
            if(max ==array[j]){
                //indexs[count++]=j;简写
                //count统计找到的下标个数,count还是数据保存的位置
                indexs[count] = j;
                count++;
            }
        }
        return count;
    }
}
