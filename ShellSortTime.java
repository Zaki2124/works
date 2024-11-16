/*
要素の移動回数をカウントするように第１版と第２版を書き換えたプログラムを作成せよ。
色々な配列に対してプログラミングを実行して移動回数を比較すること。

*/
//シェルソート(第１版)

import java.util.Scanner;
import java.util.Random;

public class ShellSortTime {
    
    //--- シェルソート ---//
    static void shellSort(int[] a, int n) {
        for (int h = n / 2; h > 0; h /= 2)
          for (int i = h; i < n; i++) {
            int j;
            int tmp = a[i];
            for (j = i - h; j >= 0 && a[j] > tmp; j -= h)
              a[j + h] = a[j];
            a[j + h] = tmp;
          }
    } 

    public static void main(String[] args) {

        Scanner stdIn = new Scanner(System.in);
        Random rand = new Random();

        int nx = 1000000;
        int[] x = new int[nx];
        for (int i = 0; i < nx; i++) {
          x[i] = rand.nextInt(10);

        }

        long startTime = System.currentTimeMillis();

        shellSort(x, nx);                          //配列xをシェルソート

        long endTime = System.currentTimeMillis();

        System.out.println("昇順にソートしました。");
        //for(int i = 0; i < nx; i++)
         // System.out.println("x[" + i + "]=" + x[i]);

        System.out.println("開始時間" + startTime + "ms");
        System.out.println("終了時間" + endTime + "ms");
        System.out.println("処理時間" + (endTime - startTime) + "ms");
    }
}
