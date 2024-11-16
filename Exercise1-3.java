//四つの整数値を読み込んで最小値を求める。

import java.util.Scanner;

class Exericse1_3 {
     
    static int min4(int a, int b, int c, int d) {
        int min = a;
        if (b < min) min = b;
        if (c < min) min = c;
        if (d < min) min = d;

        return min;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("四つの整数の最小値を求めます。");
        System.out.print("aの値:"); int a = stdIn.nextInt();
        System.out.print("bの値:"); int b = stdIn.nextInt();
        System.out.print("cの値:"); int c = stdIn.nextInt();
        System.out.print("dの値:"); int d = stdIn.nextInt();

        int min = min4(a, b, c, d);

        System.out.println("最小値は" + min + "です。");
    }
}