public class IsEven01 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            if (isEven(i)) {
                System.out.println(i + "は偶数です");
            } else {
                System.out.println(i + "は奇数です");
            }
        }
    }
   
    // 引数の値が偶数ならtrueを，そうでなければfalseを返すメソッド isEven
    public static boolean isEven(int i) {
        if (i%2 == 0) {
            return true;
        }
        else {
            return false;
        }
    }
}
