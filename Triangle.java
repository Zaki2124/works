import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        int max = 5;
        String star = "$";

        for (int i = 0; i < max; i++) {
            for (int j = 0; j < max-i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k <= i; k++){
                System.out.print(star);
            }
            System.out.println(" ");
        }
    }
}
