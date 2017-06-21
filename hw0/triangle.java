public class triangle {
	public static void drawTrangle (int N) {
		for (int row = 1; row <= N; row ++) {
			for (int col = 1; col <= row; col ++) {
				System.out.print("* ");
			}
			System.out.print("\n");
		}
	}

	public static void main (String[] args) {
		drawTrangle(10);
	}
}