package o1.flappy.gui

import o1._
import o1.flappy._

// This class is introduced in Chapter 2.7.

object FlappyBugApp extends App {

  val sky        = rectangle(ViewWidth, ViewHeight,  LightBlue)
  val ground     = rectangle(ViewWidth, GroundDepth, SandyBrown)
  val trunk      = rectangle(30, 250, SaddleBrown)
  val foliage    = circle(200, ForestGreen) 
  val tree       = trunk.onto(foliage, TopCenter, Center)
  val rootedTree = tree.onto(ground, BottomCenter, new Pos(ViewWidth / 2, 30))
  val scenery    = sky.place(rootedTree, BottomLeft, BottomLeft)

  val bugPic = Pic("ladybug.png")


  def rockPic(obstacle: Obstacle) = circle(obstacle.radius * 2, Black)

  
  // INSERT YOUR OWN CODE BELOW.
  val game = new Game()
  
   val gui = new View(game, "FlappyBug") {
    var background = scenery
    def makePic = {
      //val blockPic = rectangle(block.size, block.size, block.color)
      //background.place(blockPic, block.location)
      background.place(bugPic, game.bug.pos).place (rockPic (game.obstacle), (game.obstacle.pos)) //return하는것
    }
    
    override def onKeyDown(pressedKey: Key) = {
      if (pressedKey == Key.Space)
      game.activateBug()
    }
    override def onTick() = {
      game.timePasses()
      this.background = this.background.shiftLeft(2)
      //if( game.bug.pos.y <350) game.bug.yVelocity = game.bug.yVelocity + 0.8
    }
    override def isDone = game.isLost
  }
  
  
                   
  gui.start()                 


}

