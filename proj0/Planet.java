public class Planet {
	double xxPos, yyPos, xxVel, yyVel, mass;
	String imgFileName;

	public Planet (double xP, double yP, double xV, double yV, double m, String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Planet (Planet p) {
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;
	}

	public double calcDistance (Planet anotherP) {
		double dist = Math.sqrt((xxPos - anotherP.xxPos) * (xxPos - anotherP.xxPos) + 
								(yyPos - anotherP.yyPos) * (yyPos - anotherP.yyPos));
		return dist;
	}

	public double calcForceExertedBy (Planet anotherP) {
		double g = 6.67e-11;
		double force = g * mass * anotherP.mass / 
					(calcDistance(anotherP) * calcDistance(anotherP));
		return force;
	}

	public double calcForceExertedByX (Planet anotherP) {
		double forcex = calcForceExertedBy(anotherP) * (anotherP.xxPos - xxPos) / calcDistance(anotherP);
		return forcex;
	}

	public double calcForceExertedByY (Planet anotherP) {
		double forcey = calcForceExertedBy(anotherP) * (anotherP.yyPos - yyPos) / calcDistance(anotherP);
		return forcey;
	}

	public double calcNetForceExertedByX (Planet[] planets) {
		double netForceX = 0;
		for (int i = 0; i < planets.length; i ++ ) {
			if (!this.equals(planets[i])) {
				netForceX += calcForceExertedByX(planets[i]);
			}
		}
		return netForceX;
	}

	public double calcNetForceExertedByY (Planet[] planets) {
		double netForceY = 0;
		for (int j = 0; j < planets.length; j++) {
			if (!this.equals(planets[j])) {
				netForceY += calcForceExertedByY(planets[j]);
			}
		}
		return netForceY;
	}

	public void update(double dt, double fX, double fY) {
		double aX = fX / mass;
		double aY = fY / mass;
		xxVel = xxVel + dt * aX;
		yyVel = yyVel + dt * aY;
		xxPos = xxPos + dt * xxVel;
		yyPos = yyPos + dt * yyVel;
	}

	public void draw() {
		StdDraw.picture(this.xxPos, this.yyPos, "./images/" + imgFileName);
		StdDraw.show();
	}

}