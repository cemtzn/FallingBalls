
public class Ball {//a public class called Ball to do operations for balls

	
	//data fields
	public double x ;//x_axis of a ball
	public double y ;//y_axis of a ball
	public double radius;//radius of a ball
	public double speed;//speed of a ball

	public boolean stopped=false;//boolean statement

//Constructor
	Ball(double x , double y , double radius , double speed){
		this.x=x;
		this.y=y;
		this.radius=radius;
		this.speed=speed;

	}
	
//Drawing method
	public void draw() {

		StdDraw.setPenColor(StdDraw.BLACK);// set color for the ball
		StdDraw.filledCircle(x,y,radius);

		StdDraw.show();
		// pause for 20 ms (double buffering)
		StdDraw.pause(10);



	}
//Moving a ball downward on y_axis method
	// It changes the value of y but can not change the value of y on the client code
	public void move() {
		while(!stopped) {
			this.y = y;
			y=y-speed;
			
			if(y<=0) {
				y=800;
				continue;
			}
		}
	}
}



