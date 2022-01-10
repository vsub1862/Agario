<h1 align="center">T-Rex  Game</h1>
<p align="center">
 
  
  ![2022-01-10-01-24-06](https://user-images.githubusercontent.com/90798678/148743440-cc7302ae-d150-4fce-b152-e7a09ea100ec.gif)

  
 
## Game Description

The Dinosaur game is the iconic, not so secret game that many google users have played while waiting to get back internet access. The purpose of the game is to play as a dino that has to survive as long as possible while avoiding obstacles in a desert, traditionally a cactus and bird. In our dino game instead of avoiding a measly cactus, you have to avoid the actual cause of dino extinction… a meteor. Through this game you use the spacebar and down arrow key to jump and duck the meteor and cacti that progressively get faster as your score goes up. The purpose of the game is to get Highest score you can till you inevitably hit an obstacle, and are forced to give up, or try to set a new highscore.
  
  
  <img width="100" alt="Screenshot 2022-01-09 233212" src="https://user-images.githubusercontent.com/90798678/148739291-26fdccaf-3b7d-4f3d-9a3c-32f77af2f8d4.png">

  

## Usage
Space Bar: Restart Game/Dino Jump
 
Down Key: Dino Accelerates Down

# Classes
### ***Background***
Background class is img that doesn't chage throught entire game
  
<img width="300" alt="Screenshot 2022-01-10 005301" src="https://user-images.githubusercontent.com/90798678/148739504-7db1dbb7-af50-4798-8321-13b2841d7ba5.png">
  
<img width="300" alt="Screenshot 2022-01-10 005410" src="https://user-images.githubusercontent.com/90798678/148739638-69c9832e-1b8c-45ab-803f-5517910f41b1.png">



### ***Dino***
The character the player controls, and is the one that eitehr jumps or ducks. Created in the Frame.
 
 <img width="100" alt="Screenshot 2022-01-09 233212" src="https://user-images.githubusercontent.com/90798678/148739291-26fdccaf-3b7d-4f3d-9a3c-32f77af2f8d4.png">
  
  
  

### ***Cacti***
This is the main obsticale throught the Entire playthrough of the game. There are 2 cacti objects present in the slower stages of the game, while there is 1 object present throughout the rest of the game, which does move faster as the game progresses and is complemented by the meteor that will me covered in the next class. 
  
  ![Cactus](https://user-images.githubusercontent.com/90798678/148739757-150f985d-210f-4799-b5ec-8966fea2cb00.png)

 ### ***Meteor***
  The secondary obsticale throughout the game. There is only 1 meteor object present, but it appears above the cactus and dino, and is meant to catch the player off-gurad whie jumping. It has movement mechnics similar to the cacti where it gets faster as the score progresses, but resets once it colides with the dino, or goes past the dino on the left side of the screen where it resets it's x position to the right so it can continue being an obsticale to the player.
  
 ![Meteor](https://user-images.githubusercontent.com/90798678/148740006-cfdf8565-8ef2-465f-9a9a-dc6bfb574e1c.gif)


 
# Methods
### ***Paint***
This method draws the background, meteor, cacti, and the dino. Essenstially being the reason why we are able to see anything that goes on due to the code. The paint method is constantly updated to display the objects at various locations and at diffrent intervals making it vital for every object in the game.
 
!<img width="682" alt="image" src="https://user-images.githubusercontent.com/90798678/148740294-d0f2693b-e1e5-41bc-bcb2-8a9174b28fff.png">
  
### ***Boundries***
This method prevents the dino from going out of bounds, and regulates how fast the acceleration of the dino is. It also is where the game can recognize to stop all movement and display game over when the dino collides with an obstacle.
  
  
 <img width="673" alt="Screenshot 2022-01-10 011137" src="https://user-images.githubusercontent.com/90798678/148741555-8c2ef521-4f11-43ce-bb54-bdeb96fc3bc5.png">
  
### ***Collisions***
Collisons occur when the dino collides with either the meteor or the cacti. The way the collison works is that since the dinosaur itself doesn't move  on the x-axis, the meteor and cacti move to the left, and if the meteor and cacti have a certain range of x values while the dino is either mid air or on the ground, a collison occurs stopping the game. Reseting the positions of the meteor and cacti, while stopping the dino in the exact position it was when it was hit.
 
<img width="631" alt="image" src="https://user-images.githubusercontent.com/90798678/148740473-3f8dc450-3332-4bb0-b5d1-0f22ff58a90d.png">
<img width="646" alt="image" src="https://user-images.githubusercontent.com/90798678/148740561-3cb6a47c-590e-49be-9000-b4f247da2c43.png">

### ***Jump***
When Space bar is pressed, it makes sure the Dino jumps once, and can't jump again mid air to avoid objects.
the game.
 
<img width="517" alt="image" src="https://user-images.githubusercontent.com/90798678/148740731-d9061f02-a277-43e6-923c-22019b44269b.png">
<img width="697" alt="Screenshot 2022-01-10 010844" src="https://user-images.githubusercontent.com/90798678/148741290-13c6ab44-ac50-47d6-a1d1-fd54fd2e3e89.png">

### ***Creating Objects***
Objects created individualy, except cacti that were arrays and made multiple times.
 
<img width="559" alt="image" src="https://user-images.githubusercontent.com/90798678/148741735-d6bda5ec-3614-448a-9c06-ec04139b5252.png">
<img width="389" alt="Screenshot 2022-01-10 011354" src="https://user-images.githubusercontent.com/90798678/148742012-c40a05fd-7992-4c81-8f06-3b0a65c84390.png">



# Support
Contact Vedant or Leon if there are any questions that need clarification, or any bugs you want to report.
 
# Roadmap
 Though future work on this project dosne't seem to likely, one possibility is to make the background correlate to the score intead of being a gif, Another is to make the ducking have an actual animation other and purpose other than going down faster.

 
# Contributing
 Anyone is free to contribute or add to this game.
 
# Authors and Acknowledgements
This game is ispired by the offline T-Rex Game, and could not have been completed without the help of Mr.David, who helped us with the array needed to show multiple cacti on the screen, as well as giving us this oppertunity to test out all the coding skills we have accumilated sicne the begining of the year.
  
