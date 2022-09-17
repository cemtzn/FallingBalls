
public class Platform {//a public class called Platform to do operations for balls
	
	
	public double x ;//x_axis of a ball
	public double y;//y_axis of a ball
	public double width ;//width of a platform
	public double height;//height of a platform

	public Ball ball;//a data field depends on the Ball class

//Constructor
	Platform(double x, double y , double width , double height){

		this. x = x;
		this. y = y;
		this.width=width;
		this.height=height;
	}

	//Drawing method
	public void draw() {

		StdDraw.setPenColor(StdDraw.RED); // set color for the rectangular
		StdDraw.filledRectangle(x, y, width, height);
          
		

	}
	//A method created (but not completed) in order to check if ball touches a platform
	public  boolean touches(Ball ball) {
		return true;
	}
	
	
}
