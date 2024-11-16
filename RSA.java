public class RSA {
    // 公開鍵
    private int n; // p * q
    private int e; // p-1,q-1と互いに素な整数

    // 秘密鍵
    private int d;

    /**
     * @{param} int p   : qと異なる素数
     * @{param} int q   : pと異なる素数
     * @{param} int _e  : p-1,q-1と互いに素な整数
    */
    public RSA(int p, int q, int _e) throws IllegalNumberException
    {
        // pが素数でなければ例外
        if (!Prime.isPrime(p)) {
            throw new IllegalNumberException("pは素数ではありません。");
        }

        // pが素数でなければ例外
        if (!Prime.isPrime(q)) {
            throw new IllegalNumberException("qは素数ではありません。");
        }

        // pとqが同じであれば例外
        if (p == q) {
            throw new IllegalNumberException("pとqは互いに素ではありません。");
        }

        // _eとphiが互いに素な整数でなければ例外
        int phi = (p - 1) * (q - 1);
        if (gcd(_e, phi) != 1) {
            throw new IllegalNumberException("(p-1)(q-1)と_eは互いに素ではありません。");
        }

        this.e = _e;

        this.n = p * q;

        int l = (p - 1) * (q - 1) / gcd(p - 1, q - 1);

        int[] x = new int[1];
        int[] y = new int[1];
        extendGCD(this.e, -1 * l, x, y);
        this.d = x[0];
    }

    /**
     * a,bの最大公約数を求める(ユークリッドの互除法)
     * @{param} int a   : 自然数
     * @{param} int b   : 自然数
     * @{return} int    : 最大公約数(GCD：Greatest Common Divisor)
     */
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    /**
     * ax+by=1の解を求める(拡張ユークリッドの互除法)
     * @{param} int a   : 自然数
     * @{param} int b   : 自然数
     * @{param} int[] x : 解  参照渡し用 int[1]
     * @{param} int[] y : 解  参照渡し用 int[1]
     * @{return} int    : 最大公約数
     */
    private int extendGCD(int a, int b, int[] x, int[] y) {
        if (b == 0) {
            x[0] = 1;
            y[0] = 0;
            return a;
        } else {
            int d = extendGCD(b, a % b, y, x);
            y[0] -= a / b * x[0];
            return d;
        }
    }

    /**
     * 暗号化
     * @{param} int[] nums  : 平文
     * @{return} int[]      : 暗号文
     */

    /**
     * 復号
     * @{param} int[] nums  : 暗号文
     * @{return} int[]      : 復号結果
     */
}
