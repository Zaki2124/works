/*
要素の移動回数をカウントするように第１版と第２版を書き換えたプログラムを作成せよ。
色々な配列に対してプログラミングを実行して移動回数を比較すること。

*/
//シェルソート(第１版)

import java.util.Scanner;

public class ShellSort {
    
	//--- シェルソート（要素の移動回数を返却）---//
	static int shellSort(int[] a, int n) {

		int count = 0;										// 移動回数
        
		for (int h = n / 2; h > 0; h /= 2)
			for (int i = h; i < n; i++) {
				int j;
				int tmp = a[i];
				for (j = i - h; j >= 0 && a[j] > tmp; j -= h) {
					a[j + h] = a[j];
					count++;
				}
				a[j + h] = tmp;
				count++;
			}
		return count;
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.println("シェルソート");
		System.out.print("要素数：");
		int nx = stdIn.nextInt();
		int[] x = new int[nx];

		for (int i = 0; i < nx; i++) {
			System.out.print("x[" + i + "]:");
			x[i] = stdIn.nextInt();
		}

		int count = shellSort(x, nx);		// 配列xをシェルソート

		System.out.println("昇順にソートしました。");
		for (int i = 0; i < nx; i++)
			System.out.println("x[" + i + "]=" + x[i]);
		System.out.println("要素の移動回数は" + count + "回でした。");
	}
}
