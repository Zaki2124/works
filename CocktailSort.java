import java.util.Scanner;

class CocktailSort {

    //--- 配列の要素a[idx1]とa[idx2]の値を交換 ---//
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1]; a[idx1] = a[idx2]; a[idx2] = t;
	}

     //--- 双方向バブルソート（シェーカーソート）---//
     static void shakerSort(int[] a, int n) {

        int ccnt = 0;                                   //比較交換 
        int scnt = 0;                                   //
        
        int left = 0;
        int right = n - 1;
        int last = right;

        int i = 0;
		int k = 0;

        while (left < right){
            System.out.printf("パス%d:\n", ++i);
			int lastn = n - 1;	
            for (int j = right; j > left; j--){
                for (int m = 0; m < n - 1; m++)
					System.out.printf("%3d %c" , a[m], (m != j-1) ? ' ' :
											(a[j - 1] > a[j]) ? '+' : '-');
				System.out.printf("%3d\n", a[n - 1]);
				ccnt++;

                if (a[j - 1] > a[j]){
                    swap(a, j - 1, j);
                    last = j;
                    scnt++;
                }
            }
            left = last;

            for (int j = left; j < right; j++){
                for (int m = 0; m < n - 1; m++)
					System.out.printf("%3d %c" , a[m], (m != j-1) ? ' ' :
											(a[j - 1] > a[j]) ? '+' : '-');
				System.out.printf("%3d\n", a[n - 1]);
				ccnt++;

                if (a[j] > a[j + 1]){
                    swap(a, j, j + 1);
                    last = j;
                }
            }
            right = last;
        }
        System.out.println("比較は" + ccnt + "回でした。");
		System.out.println("交換は" + scnt + "回でした。");
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("双方向バブルソート（シェーカーソート）");
        System.out.print("要素数：");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "]:");
            x[i] = stdIn.nextInt();
        }

        shakerSort(x, nx);                // 配列xを双方向バブルソート

        System.out.println("昇順にソートしました。");
        for (int i = 0; i < nx; i++)
            System.out.println("x[" + i + "]=" + x[i]);
    }
}
