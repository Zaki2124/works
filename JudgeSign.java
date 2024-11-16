//読み込んだ整数値の符号(正/負/0)を判定

import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;

class JudgeSign {

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("整数:");
        int n = stdIn.nextInt();

        if (n > 0)
         System.out.println("正です。");
        else if (n < 0)
         System.out.println("負です。");
        else
         System.out.println("0です。");
    }
}