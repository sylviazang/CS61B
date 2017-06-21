public class stars{
	public static void main(String[] args) {
		// int row;
		// int col;
		for (int row = 1; row <= 5; row ++) {
			for (int  col = 1; col <= row; col ++) {
				System.out.print("* ");
			}
			System.out.print("\n");
		}
	}
}