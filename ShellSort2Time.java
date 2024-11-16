// シェルソート (第２版：h = ・・・, 40, 13, 4, 1)

import java.util.Scanner;
import java.util.Random;

public class ShellSort2Time {
    
    //--- シェルソート ---//
    static void shellsort(int[] a, int n) {
      int h;                                            
      for (h = 1; h < n; h = h * 3 + 1)                 
        ;

      for ( ; h > 0; h /= 3)
        for(int i = h; i < n; i++) {
          int j;
          int tmp = a[i];
          for(j = i - h; j >= 0 && a[j] > tmp; j -= h)
            a[j + h] = a[j];
        a[j + h] = tmp;
        }
    }
    
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        Random rand = new Random();

        int nx = 100000000;
        int[] x = new int[nx];
        for (int i = 0; i < nx; i++) {
          x[i] = rand.nextInt(10);

        }

        long startTime = System.currentTimeMillis();

        shellsort(x, nx);                          //配列xをシェルソート

        long endTime = System.currentTimeMillis();

        System.out.println("昇順にソートしました。");
        //for(int i = 0; i < nx; i++)
         // System.out.println("x[" + i + "]=" + x[i]);

        System.out.println("開始時間" + startTime + "ms");
        System.out.println("終了時間" + endTime + "ms");
        System.out.println("処理時間" + (endTime - startTime) + "ms");
  }
}
