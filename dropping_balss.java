/* Ismail Cem Tuzun , 041902011 , Assignment_5

 *The necessary import modules were declared.
 *Firstly, the input file was accepted by the algorithm
 *Then the object ArrayList was generated to store the information of possible platforms.
 *The information consists of the x_coordinate, y_coordinate, width and height of a possible platform.
 *After than, a method called readPlatforms was created.
 *The purpose of the method is the read inputFile and store the taken data to the ArrayList
 *Following reading process, an infinite loop created.
 *Due to infinite loop, it would be possible to draw moving balls on -y_axis(down)with radius 6 and speed 0.1.
 *Also, they spawn on x axis regarding "creationProbability" but they would not move because of some errors caused by the code writer.
 *Hence, it was impossible to calculate the other staff such as calculating the ball hitting the ground and platforms
 */



//Client Code !




import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class dropping_balss {


	public static class Platform {

		public double x;
		public double y;
		public double width;
		public double height;

		public Platform(double x, double y, double width, double height) {
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;
		}
		public void draw() {
			StdDraw.setPenColor(StdDraw.RED);
			StdDraw.filledRectangle(x,y,width/2, height/2);
		}

		public boolean touches(Ball ball) {
			if ((ball.x >= x - width/2) & (ball.x <= x + width/2 ))
				if (Math.abs(ball.y - (y+height/2)) <= ball.radius)
					return true;
			return false;
		}
	}

	public static class Ball {
		public double x;
		public double y;
		public double speed;
		public double radius;
		public boolean stopped = false;

		public Ball(double x, double y, double radius, double speed) {
			this.x = x;
			this.y = y;
			this.radius = radius;
			this.speed = speed;
		}

		public void draw() {
			StdDraw.setPenColor(StdDraw.GRAY);
			StdDraw.filledCircle(x,y,radius);
		}

		public void move() {
			if (!stopped) {
				if (y - speed <= radius) {
					y = radius;
					stopped = true;
				} else
					y = y - speed;
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException {

		String filename = "platforms2.txt";
		double ballRadius = 6;
		double ballSpeed = 2;
		double creationProbability = 0.2;

		int canvas_width = 1000;
		int canvas_height = 600;
		int xScale = canvas_width;
		int yScale = canvas_height;
		StdDraw.setCanvasSize(canvas_width, canvas_height);
		StdDraw.setXscale(0, xScale);
		StdDraw.setYscale(0, yScale);
		StdDraw.enableDoubleBuffering();

		Random r = new Random();

		ArrayList<Ball> balls = new ArrayList<Ball>();
		ArrayList<Platform> platforms = readPlatforms(filename);

		int counter = 0;
		while (true) {
			counter++;
			StdDraw.clear();
			for (Platform platform : platforms) 
				platform.draw();

			if (r.nextDouble() < creationProbability)
				balls.add(new Ball(r.nextInt(canvas_width), canvas_height, ballRadius, ballSpeed) );

			for (Ball ball : balls) {

				for (Platform platform : platforms)
					if (platform.touches(ball))
						ball.stopped = true;

				if (!ball.stopped)
					ball.move();
				ball.draw();
			}
			StdDraw.show();
		}
	}

	public static ArrayList<Platform> readPlatforms(String filename) throws FileNotFoundException {

		ArrayList<Platform> platforms = new ArrayList<>();
		File fileInput = new File(filename);
		if (!fileInput.exists()) {
			System.out.println("File is not found.");
			System.exit(1);
		}
		Scanner inputFile = new Scanner(fileInput);
		while (inputFile.hasNextLine()) {
			String str = inputFile.nextLine();
			String[] parts = str.split(",");

			platforms.add(new Platform(
					Integer.parseInt(parts[0]),
					Integer.parseInt(parts[1]),
					Integer.parseInt(parts[2]),
					Integer.parseInt(parts[3])));

			System.out.println(str);
		}

		return platforms;
	}
}