//アッカーマン関数・処理経過時間
class Ack {
    private int ack(int m, int n) {                                     //アッカーマン関数
        if(m == 0) return n + 1;
        else if(n == 0) return ack(m-1, 1);
        else return ack(m-1, ack(m, n-1));

    }

    public static void main(String arg[]) {

        
        long startTime = System.currentTimeMillis();                    //処理前の時間の取得

        Ack ack = new Ack();
        System.out.println(ack.ack(3,9));

        long endTime = System.currentTimeMillis();                      //処理後の時間の取得

        System.out.println("開始時間：" + startTime + "ms");
        System.out.println("終了時間：" + endTime + "ms");
        System.out.println("処理時間：" + (endTime - startTime) + "ms");

    }
}
