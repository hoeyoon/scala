package o1.flappy

import o1._

import scala.util.Random

// This class is introduced in Chapter 2.4.

//class Obstacle(val radius: Int, var initialPos: Pos) {  
class Obstacle(val radius: Int) {  
 
  private var currentPos = randomLaunchPosition()
  
  //private def randomLaunchPosition() = {
    //val launchX = Add up the view’s width (1000), the obstacle’s radius, and a random integer between 0 and 499.
    //val launchY = Pick a random integer that is at least 0 and less than the view’s height (400).
    //new Pos(launchX, launchY)
  //}
  
  private def randomLaunchPosition() = {
    val launchX = 1000 + radius + Random.nextInt(500)
    val launchY = Random.nextInt(ViewHeight)
    new Pos(launchX, launchY)
  }
  def pos = this.currentPos //원래 위치를 currentPos로 리턴하게끔
  def approach() = {
    if (isActive) this.currentPos = this.currentPos.addX(-ObstacleSpeed)
    //else currentPos = new Pos (ViewWidth + radius, ViewHeight/2)
    else currentPos = randomLaunchPosition()
  }
  
  def touches(mbug: Bug) = {//Bug와 Obstacle의 거리
    val distance = mbug.pos.distance(this.currentPos)
    distance < (mbug.radius + this.radius) //조건문 
  }

  override def toString = "center at " + this.pos + ", radius " + this.radius
  
  def isActive = currentPos.x > -radius
    
}
