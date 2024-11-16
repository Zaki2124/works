public class Rectagle {
     double width;               //幅
     double height;              //高さ

    //面積を戻り値にするメソッド
    public double getArea() {
        return this.width * this.height;
    }

    //boolean型の面積比較のメソッド
    boolean isLange(Rectagle r) {
        if (this.getArea() > r.getArea()) {
                return true;
        } else {
                return false;
        }
    }

    //幅と高さを指定するコンストラクタ
    Rectagle(double w, double h) {
        this.width = w;
        this.height = h;
    }

    public static void main(String[] args) {
        double width,height;
        width = 0;
        height = 0;
        Rectagle rectagle = new Rectagle(width, height);
            Rectagle r1 = new Rectagle(11.5, 1.5);
            Rectagle r2 = new Rectagle(4.5, 2.5);

                if (r1.isLange(r2)) {
                    System.out.println("True");
                } else {
                    System.out.println("False");
            }
    }
}
