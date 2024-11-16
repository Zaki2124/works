//３値の大小関係１３種類全ての組み合わせに対して中央値を求めて表示する
import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;

class Median {

    static int med3(int a, int b, int c) {
        if (a >= b)
            if (b >= c)
                return b;
            else if (a <= c)
                return a;
            else 
                return c;
        else if (a > c)
            return a;
        else if (b > c)
            return c;
        else
            return b;
    }

    public static void main(String[] args) {
        System.out.println("med3(3,2,1) = " + med3(3,2,1));
        System.out.println("med3(3,2,2) = " + med3(3,2,2));
        System.out.println("med3(3,2,1) = " + med3(3,1,2));
        System.out.println("med3(3,2,1) = " + med3(2,1,3));
        System.out.println("med3(3,2,1) = " + med3(3,3,2));
        System.out.println("med3(3,2,1) = " + med3(3,3,3));
        System.out.println("med3(3,2,1) = " + med3(2,2,3));
        System.out.println("med3(3,2,1) = " + med3(2,3,1));
        System.out.println("med3(3,2,1) = " + med3(2,3,2));
        System.out.println("med3(3,2,1) = " + med3(1,3,2));
        System.out.println("med3(3,2,1) = " + med3(2,3,3));
        System.out.println("med3(3,2,1) = " + med3(1,2,3));

        System.out.println("中央値は" + med3(a, b, c) + "です。");
    }
}