public class For2 {
    
    public static void main(String[] args) {
    
        int sum = 0;
   
       for(int i = 1; i <= 100; i++) {
        if((i % 12 != 0) && (i % 2 == 0 || i % 3 == 0)) {     //(12の倍数でない)かつ(2の倍数かつ3の倍数)
        
            sum += i;
            }
       }

       System.out.println("1~100までの偶数の和は" + sum);

    }
}
