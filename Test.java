public class Test {
    double width;
    double height;

    double getArea() {
        return this.width * this.height;
    }

    boolean isLange(Test r) {
        if(this.getArea() > r.getArea()) {
                return true;
        } else {
                return false;
        }
    }

    Test(double x, double y) {
        this.width = x;
        this.height = y;
    }
}

class Cons {
    public static void main(String[] args) {
        Test r1 = new Test(11.5, 1.5);
        Test r2 = new Test(4.5, 2.5);
            if(r1.isLange(r2)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
    }
}