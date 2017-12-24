import java.lang.Math;

 public class Day3 {
	private static int nbr = 347991;

	public static void main(String args[]) {
		int corner = 1;
		int n = 0;
		while (corner < nbr) {
			corner += 4 * n;
			n += 2;
		}
		n -= 2;
		int outer = 4 * n;
		int back = (n + 1) * (n + 1) - nbr;
		int side = n - 1;
		int topBot = n + 1;
		int x, y = n;
		if (topBot - back > 0) {
			x = topBot - back - 1;
			y = n;
		} else if (topBot + side - back > 0) {
			x = 0;
			y = topBot - side - back;
		} else if (2 * topBot + side - back > 0) {
			x = back - (topBot + side);
			y = 0;
		} else {
			x = n;
			y = n - outer - back;
		}
		int length = Math.abs(n/2 - x) + Math.abs(n/2 - y);
		System.out.println("Length: " + length);
	}
}