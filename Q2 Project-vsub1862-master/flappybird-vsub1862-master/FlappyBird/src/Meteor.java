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

public class Meteor{
	Random rnd = new Random(1234);
	//x and y position of the meteor
	double x; 
	double y;
	//tells whether the game is in progress or over
	boolean gameStatus = true;
	//the movement variables for meteor
	int speed = -7; //going left
	double ax;
	double vx ;
	//score that is synched with the the other scores in bird and cactus class
	double score = 0;
	
	
	
	private Image img; 	
	private AffineTransform tx;
	Music groundSpawn  = new Music("Ground.wav", false);
	 
	
	
	//meteor img variables and display
	public Meteor(int x, int y) {
		this.x = x;
		this.y = y;
		img = getImage("/imgs/Meteor.gif"); //load the image for Tree

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
	//method which constantly updates and finds out the position and score of game in relation to the meteor
	public void update() {
		//if statement makes it so that after scoring 1200 points the meteors will start to appear 
		//and progressivly speedup as long as you are alive and the score is going up
		if(gameStatus == true && score > 800) {
			if(score%400 == 0) {
				speed -=1;
			}
			ax = speed;
		}
		//if statement to make the meteor reset its x position between 1500 to 1000 
		if(x < -50) {
			
			x = (int)(Math.random() * 500) + 1000;
		}
		//if statement that declares when game is over that the meteor stop moving and be sent to x
		//position of 100
		if(gameStatus == false) {
			ax = 0;
			x = 1000;
		}
			
			
		
		//x position updates based of velocity and acceleration
		
		x += vx;
		vx = ax;
		//size of meteor declared
		tx.setToTranslation(x, y);
		tx.scale(1, 1);
		
	}
	/* update the picture variable location */

	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(.5, .5);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Meteor.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}

}
