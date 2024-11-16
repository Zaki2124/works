public class IsPrime01 {
    public static void main(String[] args) {
        for (int i = 2; i <= 100; i++) {
            if (isPrime(i)) {
                System.out.println(i + "は素数です");
            } else {
                System.out.println(i + "は素数ではありません");
            }
        }
    }
   
    // 引数の値が素数ならtrueを，そうでなければfalseを返すメソッド isPrime
    public static boolean isPrime(int i) {
        if (i < 2) {
            return false;
        }
        else if (i == 2) {
            return true;
        }
        else if (i % 2 == 0) {
            return false;
        }

        double sqrtNum = Math.sqrt(i);

        for (int n = 3; n <= sqrtNum; n += 2) {
                if (i % n == 0) {
                    return false;
                }
        }

        return true;
    }
}
