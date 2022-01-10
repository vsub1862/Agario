import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Dino{
	//add location attributes
	int x; //position of the dino
	int y ;
	//acceleration and movement variables
	int vy;
	int ay;//acceleration is down 
	//score variables
	double score = 0;
	double highScore = 0;
	//action variables jump/duck
	int jump = 0; 
	boolean duck = false;
	//game status whether you are currently in middle of the game or have died and yest to reset
	int gameStatus = 1;
	String gameOver = " ";
	//variables used for dino img
	private Image img; 	
	private AffineTransform tx;
	
	//img position variables
	public Dino(int x, int y) {
		this.x = x;
		this.y = y;
		img = getImage("/imgs/output-onlinegiftools (4).gif"); //load the image for Tree
		//("/imgs/output-onlinegiftools (4).gif")
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
		//using draw function to display score, high score, and game over (when necessary) on the screen 
		g2.drawImage(img, tx, null);
		g.drawString(score+ "", 220, 120);
		g.drawString("High Score: "+highScore+ "",20 , 550);
		//converting text of game over to red and bold to make it stand out on both night and day backgrounds of 
		//the game.
		g.setColor(Color.red);
		g.drawString(gameOver+ "", 160, 300);
		Font f1 = new Font(Font.SERIF, Font.BOLD, 16);
		g.setFont(f1);

	}
	//the method helps the dinosaur jump 
	public void flap() {
		duck = false;
		if(jump == 0)// so that it allows dino to jump only if on the ground {
			vy -= 120;
		
			jump = 1;
			//jump set at 1 to prevent it from jumping in the air
			
		}
		
	
	/* update the picture variable location */
	private void update() {
		
		if(duck == false) {
			//if dinosaur is not  ducking/ if duck = false, the code will go through these statements that define
			//the rules of how many times the dino jumps, when it can jump, and the acceleration applied on the dino
			//depending on the score
			if (y >= 400) {
				//this if statement prevents dino from going past the ground
				//sets jump at 0 when its on the ground and allows the dino to jump, and when jump = 1, essentially
				//when the dino is in the air, it can't jump.
				ay = 0;
				jump = 0;
				
			}
			//acceleration of the dino when starting the game for the first time to help it get down to the ground 
			//faster
			if(y <= 400 && score > 10) {
				
				ay = 10;
				jump = 1;
			}
			//regular acceleration that is applied to dino through most of the game
			
			if(y <= 400 && score >= 25) {
				
				ay = 5;
				jump = 1;
				 
			}
		}
		//when dino is ducking which is essentially accelerating downwards this code prevents it from going past the
		//ground
		else {
			if (y >= 400) {
				ay = 0;
				jump = 0;
			}
			
		}
		//gameStatus ='s 0 when the you run into either a cactus or meteor, and the game is over
		//the if statement makes the dino stop accelerating downwards and makes a string gameOver = "GAME OVER" 
		//displayed on the screen
		//if the current score is greater than the highscore, then the new highscore will be displayed on the bottom left
		//and the score is reset to 0
		if(gameStatus == 0) {
			
			ay = 0;
			gameOver = "GAME OVER";
			if(score >= highScore) {
				highScore = score;
			}
			score = 0;
		}
		 
		
		
		
		
		
		//update y based on by
		vy += ay;
		y =+ vy; // velocity in y affects the y
		
		
		
		tx.setToTranslation(x, y);
		tx.scale(1.3	, 1.3);
		
		
		
	}
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(.5, .5);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Dino.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}

}
