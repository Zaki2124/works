// 配列の要素に値を読み込んで並びを反転する

import java.util.Arrays;
import java.util.Scanner;

class ReverseArrayEx {

   //--- 配列の要素a[idx1]とa[idx2]を交換 ---//
   static void swap(int[] a, int idx1, int idx2) {
      int t = a[idx1];  a[idx1] = a[idx2];  a[idx2] = t;
   }

   //--- 配列aの要素の値を表示 ---//
   static void print(int[] a) {
      for (int i = 0; i < a.length; i++)
         System.out.print(a[i] + " ");
      System.out.println();
   }


   //--- 配列aの要素の並びを逆転 ---//
   static void reverse(int[] a) {
      print(a);
      for (int i = 0; i < a.length / 2; i++) {
         System.out.println("a[" + i + "]とa[" + (a.length - i - 1) + "]を交換します。");
         swap(a, i, a.length - i - 1);
         print(a);
      }
   }

   public static void main(String[] args) {
      Scanner stdIn = new Scanner(System.in);

      System.out.print("要素数は：");
      int num = stdIn.nextInt();      // 要素数

      int[] x = new int[num];         // 要素数numの配列

      for (int i = 0; i < num; i++) {
         System.out.print("x[" + i + "] : ");
         x[i] = stdIn.nextInt();

      }

      reverse(x);      // 配列aの要素の並びを逆転
   
      System.out.println(Arrays.toString(x));
      System.out.println(" 反転が終了しました。");
   }
}
