import java.util.*;

public class FactorialRecursiveCall {
    static int fact(int n) {
        int ans;

        if (n <= 0) ans = 1;
        else ans = n * fact(n - 1);
            return ans;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n, ans;

        while (true) {
            System.out.print("0以上の整数を入力して下さい。:");
            n = sc.nextInt();
            if (n >= 0) break;
        }

        ans = fact(n);
        System.out.println(n + "の階乗は" + ans + "です。");
    }
}