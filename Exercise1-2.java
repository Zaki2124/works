//三つの整数値を読み込んで最小値を求める。

import java.util.Scanner;

class Exericse1_2 {
     
    static int min3(int a, int b, int c) {
        int min = a;
        if (b < min) min = b;
        if (c < min) min = c;

        return min;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("三つの整数を読み込んで最小値を求めます。");
        System.out.print("aの値:"); int a = stdIn.nextInt();
        System.out.print("bの値:"); int b = stdIn.nextInt();
        System.out.print("cの値:"); int c = stdIn.nextInt();

        int min = min3(a, b, c);

        System.out.println("最小値は" + min + "です。");
    }
}