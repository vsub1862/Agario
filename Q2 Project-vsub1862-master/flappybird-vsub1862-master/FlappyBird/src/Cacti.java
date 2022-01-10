import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;
import java.util.Random;

public class Cacti{
	
	//add location attributes
	//x and y coordinated of cacti
	double x; 
	double y;
	//game status 
	boolean gameStatus = true;
	//speed of cacti
	
	//score linked to meteor and bord score
	double score;
	//acceleration/movement of cacti
	double ax;
	double vx ;
	int speed = -4;
	
	private Image img; 	
	private AffineTransform tx;
	
	 
	
	
	//img variables and loading of cacti
	public Cacti(int x, int y) {
		this.x = x;
		this.y = y;
		img = getImage("/imgs/Cactus.png"); 

		tx = AffineTransform.getTranslateInstance(x, y );
		init(x, y); 				//initialize the location of the image
									//use your variables
	}
	
	public void changePicture(String newFileName) {
		img = getImage(newFileName);
		init(x, y);
		
		
	}
	
	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;

		//call update to update the actualy picture location
		update();
		g2.drawImage(img, tx, null);
		
		
		
		
		
	

	}
	
	//method which constantly updates and finds out the position and score of game in relation to the cacti
	public void update() {
		//after the dino is on the ground + the game is not over = you haven't collided with anything
		//other conditionals dictating the speed and position of the cacti take into effect
		if(score >=10 && gameStatus == true ) {
			//if cacti is not off screen/ to the left of the dino
			//then the cacti's velocity to the right increases every 400 points you get
			if(x > - 50) {
				if(score%400 == 0) {
					speed -=1;
				}
				ax = speed;
				
			} 
			//whe cacti goes of screen it's x position is reset between a certain range between 900 and 600
			if(x < -50) {
				
				
				x = (int)(Math.random() * 300) + 600;	
			}
		}
		//when collison is detected the cacti stop moving and are set to x = -51, so that the momment one resets
		//the game they can get new x positions
		else if (gameStatus == false) {
			ax = 0;
			x = -51;
		}
			
			
		
		//x position updates based of velocity and acceleration
		x += vx;
		vx = ax;
		tx.setToTranslation(x, y);
		tx.scale(.7	, .7);
		
	}
	/* update the picture variable location */

	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(.5, .5);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Cacti.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}

}
