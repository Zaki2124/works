//読み込んだ10進整数を２進数～３６進数へと基数変換して表示
/**
 * p.51 演習2-6
 *
 * 下に示すように、基数変換の仮定を詳細に表示するプログラムを作成せよ。
 *
            10進数を基数変換します。
            変換する非負の整数 : 59
            何進数に変換しますか(2-36) : 2
            2 | 59
              +-----
            2 | 29   ･･･ 1
              +-----

    ･･･       中略       ･･･

            2 |  1   ･･･ 1
              +-----
                  0  ･･･ 1
            2進数では111011です。
 */

import java.util.Scanner;

public class Exercise2_6 {
    static void cardConv(int x, int r, char[] d) {
        int digits = 0;   //変換後の桁数
        String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        System.out.println(r + "|" + x );
        System.out.println("+-------");

        while (x > 0) {
            int remainder = x % r;
            d[digits++] = dchar.charAt(remainder);  //rで割った余剰を格納
            x /= r;  
            System.out.println(r + "|" + x +   "    ・・・" + remainder);
            System.out.println(" +-------");   
        }

        System.out.println(    x +   "    ・・・" + d[x++]);

        for (int i = 0; i < digits / 2; i++) {      //配列dの並びを反転
            char t = d[i];
            d[i] = d[digits - i - 1];
            d[digits - i - 1] = t;
        }

        return;
    }

    static public void main(String[] args) {
        try (Scanner stdIn = new Scanner(System.in)) {
            int no;                                                     //変換する整数
            int cd;                                                     //基数                                      
            int retry;                                                  //もう一度？                                     
            char[] cno = new char[32];                                  //変換度の各桁を格納する文字の配列

            System.out.println("10進数を基数変換します。");
            do {
                do {
                    System.out.print("変換する非負の整数 : ");
                    no = stdIn.nextInt();
                } while (no < 0);

                do {
                    System.out.print("何進数に変換しますか(2-36) : ");
                    cd = stdIn.nextInt();
                } while (cd < 2 || cd > 36);

                cardConv(no, cd, cno);
                
                System.out.print(cd + "進数では");

                System.out.print(cno);
                System.out.println("です。");

                System.out.print("もう一度しますか(1:はい / 0:いいえ) : ");
                retry = stdIn.nextInt();

                cno = new char[32];
            } while (retry == 1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return;
    }
}
