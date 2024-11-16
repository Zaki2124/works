import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        RSA rsa;
        int p = 7, q = 11, e = 7;

        // p,q,eが条件を満たしていないと例外が発生する
        try {
            rsa = new RSA(p, q, e);
        } catch (IllegalNumberException exception){
            System.out.println(exception.getMessage());
            return;
        }

        // 平文
        int[] input = {35, 6, 23, 54, 48, 5, 35, 23, 67, 3};
    }
}
