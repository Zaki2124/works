//配列の要素の最大値を表示する(値は乱数で生成)

import java.util.Random;

class MaxOfArrayRand {

    //--- 配列aの最大値を求めて返却 ---//
    static int maxOf(int[] a) {
        int max = a[0];
        for (int i = 1; i < a.length; i++)
        if(a[i] > max)
         max = a[i];
    return max;
    }

public static void main(String[] args) {
    Random rand = new Random();
  
    System.out.println("身長の最大値を求めます。");
    System.out.print("人数は:");
    int num = rand.nextInt(20);

    int[] height = new int[num];

    System.out.println("身長は次の様になっています。");
    for (int i = 0; i < num; i++) {
        height[i] = 100 + rand.nextInt(90);
        System.out.println("height[" + i + "]:" + height[i]);
     }

     System.out.println("最大値は" + maxOf(height) + "です。");
    }
}