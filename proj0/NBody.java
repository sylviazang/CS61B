public class NBody {
	public static double readRadius (String filePath) {
		In in = new In(filePath);
		double n = in.readDouble();
		double rad = in.readDouble();
		return rad;
	}

	public static Planet[] readPlanets (String filePath) {
		Planet[] planets = new Planet[5];
		In in = new In(filePath);
		double n = in.readDouble();
		double rad = in.readDouble();
		for (int i = 0; i < n; i++) {
			double xP = in.readDouble();
			double yP = in.readDouble();
			double xV = in.readDouble();
			double yV = in.readDouble();
			double m = in.readDouble();
			String img = in.readString();

			planets[i] = new Planet(xP, yP, xV, yV, m, img);

		}

		return planets;
	}


	public static void main (String[] args) {
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double universeRadius = readRadius(filename);
		Planet[] planets = readPlanets(filename);

		StdDraw.setScale(universeRadius, universeRadius);
		StdDraw.clear();

		String backgroundImg = "./images/starfield.jpg";
		StdDraw.picture(0, 0, backgroundImg);
		// StdDraw.show();

		int i = 0;
		while (i < planets.length) {
			planets[i].draw();
			i++;
		}





	}
}