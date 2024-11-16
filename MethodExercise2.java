public class MethodExercise2 {
    public static void main(String[] args) {
        System.out.println("GCD(24, 8) = " + gcd(24, 8));
        System.out.println("GCD(144, 84) = " + gcd(144, 84));
    }    

    // 2つの引数の最大公約数を求めるメソッド gcd
    private static int gcd(int i, int j) {
       while(i > 0 && j > 0) {
           if (i > j)
               i = i % j;
            else
               j = j % i;
            if(i == 0)
                return j;
            if(j == 0)
                return i;
       }
       return 0;
   	}
       
}
