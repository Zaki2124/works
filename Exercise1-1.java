//４つの整数値の最大値を求める。
import java.util.Scanner;

    class Exercose1_1 {
        public static void main(String[] args) {
            Scanner stdIn = new Scanner(System.in);

            System.out.println("4つの整数の最大値を求めます。");
            System.out.print("aの値:"); int a = stdIn.nextInt();
            System.out.print("bの値:"); int b = stdIn.nextInt();
            System.out.print("cの値:"); int c = stdIn.nextInt();
            System.out.print("dの値:"); int d = stdIn.nextInt();
            
            int max = a;
            if (b > max) max = b;
            if (c > max) max = c;
            if (d > max) max = d;

            System.out.println("最大値は" + max + "です。");
        }
}
