import java.sql.Time;
import java.util.HashMap;

public class day01 {
    //题目1：一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法

    //递归,会有爆栈的风险

    public static int f1(int n){
        if(n == 1){
            return 1;
        }else if(n ==2){
            return 2;
        }else{
            return f1(n-1) + f1(n-2);
        }
    }

    //动态规划，不会爆栈，速度很快
    static HashMap<Integer,Long> hashMap = new HashMap<>();

    public static long f2(int n){
        if(n <= 0){
            return 0;
        }else if(n <= 2){
            return n;
        }else{
            if(hashMap.containsKey(n)){
                return hashMap.get(n);
            }else {
                long m = f2(n-1) + f2(n-2);
                hashMap.put(n,m);
                return m;

            }
        }

    }

    //类似于斐波纳切数列,最快而且空间最小，但是使用条件特殊，不是通解
    public static  long f3(int n){
        if(n <= 0){
            return  0;
        }else if (n <= 2){
            return n;
        }

        long f1 = 1;
        long f2 = 2;
        long sum = 0;
        for(int i = 3; i <= n ; i++) {
            sum = f1 + f2;
            f1 = f2;
            f2 = sum;
        }
        return sum;

    }


    //一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。 求该青蛙跳上一个n级的台阶总共有多少种跳法。
    static HashMap<Integer,Long> hashMap1= new HashMap<>();
    public static  long f4 (int n){
        if(n <= 0){
            return 0;
        }else if(n <= 2){
            return n;
        }else {
            if(hashMap1.containsKey(n)){
                return hashMap1.get(n);
            }else {
                long m = 0;
                for(int i = 1; i<= n - 1; i ++){
                    m += f4(i);
                }
                hashMap1.put(n,m);
                return m;
            }
        }
    }









    public static void main(String args[]) {
        long t1 = System.currentTimeMillis();
        System.out.println(f1(40));
        System.out.println("时间为：" + (System.currentTimeMillis() - t1));
        long t2 = System.currentTimeMillis();
        System.out.println(f2(1000));
        System.out.println("时间为：" + (System.currentTimeMillis() - t2));
        long t3 = System.currentTimeMillis();
        System.out.println(f3(1000));
        System.out.println("时间为：" + (System.currentTimeMillis() - t3));
        long t4 = System.currentTimeMillis();
        System.out.println(f4(50));
        System.out.println("时间为：" + (System.currentTimeMillis() - t4));

    }

}
