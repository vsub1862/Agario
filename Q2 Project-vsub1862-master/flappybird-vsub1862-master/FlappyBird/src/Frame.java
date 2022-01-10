import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Frame extends JPanel implements ActionListener, MouseListener, KeyListener {
	//declaring position of background, dino, meteorite, and cactus 
	//creating objects from classes and array
	Background 	b = new Background(0, 0);
	Dino d = new Dino(0, 400);	
	Cacti[] meteor = new Cacti[2];
	Meteor meteorite = new Meteor(500,300);
	
	//creating music objects 
	Music windowsSpawn = new Music("Microsoft Windows XP Shutdown Sound.wav", false);
	
	Music explosionSpawn = new Music("zapsplat_explosion_med_large_71697.wav", false);
	
	public void paint(Graphics g) {
		super.paintComponent(g);
		//asking the objects to paint themselves(background, d, and meteorite)
		b.paint(g);
		d.paint(g);
		meteorite.paint(g);
		//for loop goes through array and creates cacti 
		for(int i = 0; i < 2; i++) {
			//d score and rest of scores go up by 0.5 while game is running
			d.score+=0.5;
			meteorite.score = d.score;
			meteor[i].score = d.score;
			//meteor objects being painted
			meteor[i].paint(g);
			//The loop goes through and makes sure x values of the cacti aren't too close when randomly being generated 
		
			if(i != 0) {
				
				if(Math.abs(meteor[i].x - meteor[i-1].x) < 100 && d.score >20) {
					meteor[i].x += 200;// adds decent gap to seperate 2 cacti
					if(d.score > 800) {
						meteor[i-1].x += 10000000;//one meteor spawns there will be to much for one person to dodge
						//all ground + sky obstacles
					}
					
				}
				}
			//an if statement that verifies collison between and of the collison objects (meteor or cacti), and 
			//stop game when detected
			//if cacti are in a certain range and the y coordinates of the dino are in the range as well,
			//then collsion detected and gameStatus of all objects = 0 or false, stopping the game.
			if(meteor[i].x <= 90 && meteor[i].x >= 40 && d.y <= 410 && d.y >=370) {
				d.gameStatus = 0;
				
				for(int m = 0; m < 2; m++) {
				meteor[m].gameStatus = false;
				
				
				}
				windowsSpawn.play();//music played on death
				break;
			}
			//meteor collison similar to cacti, in where if x and y coordinates of both dino and meteor fall in a 
			//certain range, then game stoped
			if(meteorite.x <=50 && meteorite.x >= -40 &&d.y >330 && d.y <370) {
				d.gameStatus = 0;
				meteorite.gameStatus = false;
				for(int m = 0; m < 2; m++) {
					meteor[m].gameStatus = false;
					}
				windowsSpawn.play();
					break;
				
			}
			
			
		}
		
			
		
	}
	
	public static void main(String[] arg) {
		Frame f = new Frame();
	}
	
	public Frame() {
		//titles the game
		JFrame f = new JFrame("Dino Game");
		f.setSize(new Dimension(400, 600));
		f.setBackground(Color.blue);
		f.add(this);
		f.setResizable(false);
		//creating cactus objects from array with random x position between a certain range
		for(int i =0; i < meteor.length; i++) {
			
			int x = (int)(Math.random() * 300) + 600;
			
			int y = 445;
			
			meteor[i] = new Cacti(x,y);

		}
		
		
		
		
		f.setLayout(new GridLayout(1,2));
		f.addMouseListener(this);
		f.addKeyListener(this);
		Timer t = new Timer(16, this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		//if the space bar is pressed and the dino is confirmed to be on the ground (jump == 0), then 
		//the dino is allowed to jump and music is played
		if (arg0.getKeyCode() == 32) { 
			if(d.gameStatus == 1 && d.jump == 0) {
				d.flap();
				explosionSpawn.play();
				
			}
			//when you die/collide with a meteor and the game is over(gameStatus = 0), you can reset the entire game
			//by pressing space bar which turns all the previos values including score, speed, position of all objects
			//to their original values resetinng the game
			if(d.gameStatus == 0) {
				d.x = 0;
				d.duck = false;
				d.gameOver = " ";
				d.gameStatus = 1;
				meteorite.speed = -7;
				meteorite.score = 0;
				d.score = 0;
				for(int m = 0; m < 2; m++) {
					meteor[m].gameStatus = true;
					meteor[m].speed = -4;
					
					}
				
			}
		
		}
		if (arg0.getKeyCode() == 40) { 
			d.ay = 15;
			d.duck = true;
			
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}

