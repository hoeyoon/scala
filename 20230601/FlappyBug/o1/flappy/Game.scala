package o1.flappy

import o1._

class Game {

  // Your code goes here. Please add only what is requested by the ebook. To avoid 
  // confusing our automatic assessment system, please don't invent additions of your own 
  // here (at least not until you're done with the ebook’s official FlappyBug assignments).  
 val bug = new Bug ( new Pos (100, 40))
 //val obstacle = new Obstacle (70, new Pos (1000, 100))
 val obstacle = new Obstacle (70)
 
 def timePasses() = {
   bug.fall()
   obstacle.approach()
 }
 
 def activateBug() = {
   bug.flap(WingPower)
   //bug.flap(bug.yVelocity)
 }
 
 def isLost = this.obstacle.touches(this.bug)
  
  
}
