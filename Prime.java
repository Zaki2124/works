import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class Prime {
    /**
     * 素数判定
     * @{param} int num : 判定したい整数
     * @{return} bool : 素数ならtrue、そうでなければfalse
     */
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }

        if (num == 2) {
            return true;
        }

        if (num % 2 == 0) {
            return false;
        }

        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * 試し割法
     */
    public static void primeFactorize() {
        // 素因数分解したい数
        int N = 1024;

        // 因数を格納するマップ配列
        Map<Long, Long> res = new HashMap<>();

        // 2のみ先に処理する
        int cnt = 0;
        // 2で割り切れなくなるまで割り続ける
        while(N % 2 == 0) {
            cnt++;
            N /= 2;
        }
        // cntが0より大きければ、因数に2を含むため、答えに追加
        if (cnt > 0) {
            res.put(Long.valueOf(2), Long.valueOf(cnt));
        }

        // 3<= p <= √(N)の範囲の奇数で割っていく O(√(N))
        for (int p = 3; p * p <= N; p += 2) {
            // 割り切れない場合はスキップ
            if (N % p != 0) {
                continue;
            }

            // Nの素因数pで割り切れなくなるまで割り続ける
            cnt = 0;
            while (N % p == 0) {
                cnt++;
                N /= p;
            }

            // 答えに追加
            res.put(Long.valueOf(p), Long.valueOf(cnt));
        }

        // Nが0になっていなければ、それも因数である
        if (N != 1) {
            res.put(Long.valueOf(N), Long.valueOf(1));
        }

        // 求めた因数を表示
        System.out.println("因数 : 指数");
        for (Long key : res.keySet()) {
            System.out.printf("%4d : %4d\n", key, res.get(key));
        }
    }

    /**
     * エラトステネスの篩
     */
    public static void Eratosthenes() {
        int[] numbers = {32 ,4574 ,324236 ,124 ,345 ,10000, 2017};

        // 配列の中から最大値を求める
        Arrays.sort(numbers);
        int maxNum = numbers[numbers.length - 1];

        // ふるい
        boolean[] primeTable;
        primeTable = new boolean [maxNum + 1];
        for(int i = 2; i <= maxNum; i++) {
            primeTable[i] = isPrime(i);
        }

        // 素数判定
        for(int num : numbers) {
            if (primeTable[num]) {
                System.out.println(Integer.toString(num) + " : prime");
            } else {
                System.out.println(Integer.toString(num) + " : not prime");
            }
        }
    }
}
