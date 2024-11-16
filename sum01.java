public class sum01 {
    public static void main(String[] args) {
        for (int i = 0; i <= 30; i++) {
            System.out.println("sum 0 - i = " + sum(i));
        }
    }

 // 0 から n までの合計を計算して返すメソッド sum
    private static int sum(int n) {
        if(n > 0) {
            int i = 0;
            int j = 0;
            while(j < n+1) {
                i += j;
                j++;
            }
            return i;
            }
    
            return 0; 
    }
}
