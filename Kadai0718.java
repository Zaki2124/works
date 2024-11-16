class Kadai0718 {
	Kadai0718() {
		System.out.println("[X]");
	}

	void a() {
		System.out.println("[x.a]");
	}

	void b() {
		System.out.println("[x.b]");
	}
}

class Y extends Kadai0718 {
	Y() {
		System.out.println("[Y]");
	}

	void a() {
		System.out.println("[y.a]");
	}
}

public class Practice7_2 {
	public static void main(String[] args) {
		Kadai0718 x = new Kadai0718();
		x.a();
		x.b();
		Y y = new Y();
		y.a();
		y.b();
	}
}